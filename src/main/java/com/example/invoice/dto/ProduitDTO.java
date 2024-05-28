package com.example.invoice.dto;



import java.math.BigDecimal;


public class ProduitDTO {

    private Long id;

    private String designation;

    private BigDecimal prixUnitaire;


    private String description;


    public ProduitDTO(Long id, String designation, BigDecimal prixUnitaire, String description) {
        this.id = id;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.description = description;
    }

    public ProduitDTO() {

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
