package com.example.invoice.dto;

import jakarta.persistence.*;

public class DetAchatDTO {


    private Long id;

    private ProduitDTO produit;


    private int quantiteAchete;

    private double prixUnitaire;

    public DetAchatDTO() {
    }

    public DetAchatDTO(Long id, ProduitDTO produit, int quantiteAchete, double prixUnitaire) {
        this.id = id;
        this.produit = produit;
        this.quantiteAchete = quantiteAchete;
        this.prixUnitaire = prixUnitaire;

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
