package com.example.invoice.dto;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class DetAchatDTO {


    private Long id;

    private ProduitDTO produit;

    private BigDecimal totalParProduit;


    private int quantiteAchete;

    private double prixUnitaire;

    public DetAchatDTO() {
    }

    public DetAchatDTO(Long id, ProduitDTO produit, BigDecimal totalParProduit,int quantiteAchete, double prixUnitaire) {
        this.id = id;
        this.produit = produit;
        this.totalParProduit= totalParProduit;
        this.quantiteAchete = quantiteAchete;
        this.prixUnitaire = prixUnitaire;

    }


    public BigDecimal getTotalParProduit() {
        return totalParProduit;
    }

    public void setTotalParProduit(BigDecimal totalParProduit) {
        this.totalParProduit = totalParProduit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProduitDTO getProduit() {
        return produit;
    }

    public void setProduit(ProduitDTO produit) {
        this.produit = produit;
    }

    public int getQuantiteAchete() {
        return quantiteAchete;
    }

    public void setQuantiteAchete(int quantiteAchete) {
        this.quantiteAchete = quantiteAchete;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
