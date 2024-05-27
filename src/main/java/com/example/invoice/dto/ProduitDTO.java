package com.example.invoice.dto;



import java.math.BigDecimal;


public class ProduitDTO {

    private Long id;

    private String designation;

    private BigDecimal prixUnitaire;
    private String Description;


    public ProduitDTO(Long id, String designation, BigDecimal prixUnitaire, String description) {
        this.id = id;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        Description = description;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
