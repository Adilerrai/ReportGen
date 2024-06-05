package com.example.invoice.batch;

import com.example.invoice.model.EnteteVente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobLauncher jobLauncher;
    private final EntityManagerFactory entityManagerFactory;
    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;

    public BatchConfiguration(JobLauncher jobLauncher, EntityManagerFactory entityManagerFactory,
                              PlatformTransactionManager transactionManager, JobRepository jobRepository) {
        this.jobLauncher = jobLauncher;
        this.entityManagerFactory = entityManagerFactory;
        this.transactionManager = transactionManager;
        this.jobRepository = jobRepository;
    }

    @Bean
    public JpaPagingItemReader<EnteteVente> reader() {
        return new JpaPagingItemReaderBuilder<EnteteVente>()
                .name("EnteteVenteReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select e from EnteteVente e where e.statut = 'REGLE'")
                .build();
    }

    @Bean
    public ItemProcessor<EnteteVente, EnteteVente> processor() {
        return EnteteVente -> EnteteVente;
    }


    @Bean
    public ItemWriter<EnteteVente> writer() {
        return items -> {
            ObjectMapper objectMapper = new ObjectMapper();
            for (EnteteVente item : items) {
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
                Files.write(Paths.get("output.json"), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        };
    }

    @Bean
    public Step myStep() {
        return new StepBuilder("myStep", jobRepository)
                .<EnteteVente, EnteteVente>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job myJob() {
        return new JobBuilder("myJob", jobRepository)
                .start(myStep())
                .build();
    }

    @Scheduled(cron = "0 0 * * * *")
    public void runMyJob() throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(myJob(), jobParameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
