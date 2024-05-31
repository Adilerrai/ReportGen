package com.example.invoice.fileGeneration;

import com.example.invoice.model.Achat;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.repository.EnteteRepository;
import com.example.invoice.repository.achat.AchatRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.*;




@Service
public class ReportService {



    private final AchatRepository achatRepository;

    private  final EnteteRepository enteteRepository;

    public ReportService( EnteteRepository enteteRepository, AchatRepository  achatRepository) {
        this.enteteRepository = enteteRepository;
        this.achatRepository = achatRepository;
    }

    public String generateEntete(Long id) {
        try {
            // Fetch data
            List<EnteteFact> enteteList = new ArrayList<>();

            EnteteFact entete = enteteRepository.findById(id).get();
            enteteList.add(entete);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "Invoice.pdf";

            String reportPath = "src/main/resources/reports/Invoice.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);


            System.out.println("entete: " + entete);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(enteteList);
            Map<String, Object> parameters = new HashMap<>();
            BigDecimal totalAmount = entete.getDetFactures().stream()
                    .filter(detFacture -> detFacture.getMontantTotalParProduit() != null)
                    .map(detFacture -> detFacture.getMontantTotalParProduit())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            parameters.put("total", totalAmount);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);




            JasperExportManager.exportReportToPdfFile(jasperPrint, outputDirectory + outputFileName);
            return "Report successfully generated";
        } catch (JRException e) {
            e.printStackTrace();
            return "Error occurred while generating report";
        }
    }


    public String generateAchat(Long id) {
        try {
            // Fetch data
            List<Achat> achatList = new ArrayList<>();

            Achat achat = achatRepository.findById(id).get();
            achatList.add(achat);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "achat_" + achat.getId() + ".pdf";
            String reportPath = "src/main/resources/reports/achat.jrxml";

            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(achatList);

            BigDecimal total = achat.getTotalAchat();


            Map<String, Object> parameters = new HashMap<>();

            parameters.put("total", total);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputDirectory + outputFileName);

            return "Report successfully generated";
        } catch (JRException e) {
            e.printStackTrace();
            return "Error occurred while generating report";
        }
    }}
