package com.example.invoice.fileGeneration;

import com.example.invoice.enums.StatusEnteteAchat;
import com.example.invoice.model.EnteteAchat;
import com.example.invoice.model.EnteteVente;
import com.example.invoice.repository.EnteteRepository;
import com.example.invoice.repository.achat.EnteteAchatRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.*;




@Service
public class ReportService {


    private final EnteteAchatRepository enteteAchatRepository;

    private  final EnteteRepository enteteRepository;

    public ReportService( EnteteRepository enteteRepository, EnteteAchatRepository  enteteAchatRepository) {
        this.enteteRepository = enteteRepository;
        this.enteteAchatRepository = enteteAchatRepository;
    }

    public String generateVente(Long id) {




        try {
            // Fetch data
            List<EnteteVente> enteteList = new ArrayList<>();

            EnteteVente entete = enteteRepository.findById(id).get();
            enteteList.add(entete);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "Vente_" + entete.getId() + ".pdf";
            String reportPath = "src/main/resources/reports/Vente.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);


            System.out.println("entete: " + entete);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(enteteList);

            Map<String, Object> parameters = new HashMap<>();

            BigDecimal totalAmount = entete.getDetVentes().stream()
                    .filter(DetVente -> DetVente.getMontantTotalParProduit() != null)
                    .map(DetVente -> DetVente.getMontantTotalParProduit())
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





    public String generateEnteteAchat(Long id) {
        try {
            // Fetch data from repo
            List<EnteteAchat> EnteteAchatList = new ArrayList<>();

            EnteteAchat enteteAchat = enteteAchatRepository.findById(id).get();
            EnteteAchatList.add(enteteAchat);


            System.out.println("enteteAchat: " + enteteAchat);

            String outputDirectory = "src/main/resources/reports/";
            String outputFileName = "Achat_" + enteteAchat.getId().hashCode() + ".pdf";
            String reportPath = "src/main/resources/reports/Achat.jrxml";

            JasperDesign jasperDesign = JRXmlLoader.load(reportPath);

            JRDesignDataset subDataset = new JRDesignDataset(false);




            subDataset.setName("Dataset1");

            // Add fields to the subdataset (id , designation, quantiteAchete, prixUnitaire)
            addFieldToDataset(subDataset, "produit.id", Long.class);
            addFieldToDataset(subDataset, "produit.designation", String.class);
            addFieldToDataset(subDataset, "quantiteAchete", Integer.class);
            addFieldToDataset(subDataset, "prixUnitaire", Double.class);
            addFieldToDataset(subDataset, "totalParProduit", BigDecimal.class);


            jasperDesign.addDataset(subDataset);


            // Add fields to the main dataset
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "fournisseur.email", String.class);
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "fournisseur.telephone", String.class);
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "id", Long.class);
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "dateEnteteAchat", java.sql.Date.class);
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "detAchats", List.class);
            addFieldToDataset(jasperDesign.getMainDesignDataset(), "statusEnteteAchat", StatusEnteteAchat.class);



            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(EnteteAchatList);

            BigDecimal total = enteteAchat.getTotalEnteteAchat();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("total", total);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputDirectory + outputFileName);

            return "Report successfully generated";
        } catch (JRException e) {
            e.printStackTrace();
            return "Error occurred while generating report";
        }
    }



    private void addFieldToDataset(JRDesignDataset dataset, String fieldName, Class<?> valueClass) throws JRException {
        JRDesignField field = new JRDesignField();
        field.setName(fieldName);
        field.setValueClass(valueClass);
        dataset.addField(field);
    }



}
