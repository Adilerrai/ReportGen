package com.example.invoice.dto;


import com.example.invoice.model.EnteteFact;
import com.example.invoice.model.Produit;
import jakarta.persistence.*;

import java.math.BigDecimal;


public class DetFactureDTO {

    private Long id;

    private Long quantite;

    private BigDecimal prixUnitaire;

    private BigDecimal montantTotalParProduit;

    public Produit getProduit() {
        return produit;
    }

    @ManyToOne
    private Produit produit;



    private EnteteFact enteteFact;


    public DetFactureDTO(Long id, Long quantite, BigDecimal prixUnitaire, BigDecimal montantTotalParProduit, Produit produit, EnteteFact enteteFactDTO) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantTotalParProduit = montantTotalParProduit;
        this.produit = produit;
        this.enteteFact = enteteFact;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public EnteteFact getEnteteFactDTO() {
        return enteteFact;
    }

    public void setEnteteFactDTO(EnteteFact enteteFact) {
        this.enteteFact = enteteFact;
    }

    public DetFactureDTO() {
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getMontantTotalParProduit() {
        return montantTotalParProduit;
    }

    public void setMontantTotalParProduit(BigDecimal montantTotalParProduit) {
        this.montantTotalParProduit = montantTotalParProduit;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
