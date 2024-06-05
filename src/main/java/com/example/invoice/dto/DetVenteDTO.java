package com.example.invoice.dto;


import com.example.invoice.model.EnteteVente;
import com.example.invoice.model.Produit;
import jakarta.persistence.*;

import java.math.BigDecimal;


public class DetVenteDTO {

    private Long id;

    private Long quantite;

    private BigDecimal prixUnitaire;

    private BigDecimal montantTotalParProduit;

    public Produit getProduit() {
        return produit;
    }

    @ManyToOne
    private Produit produit;



    private EnteteVente EnteteVente;


    public DetVenteDTO(Long id, Long quantite, BigDecimal prixUnitaire, BigDecimal montantTotalParProduit, Produit produit, EnteteVente EnteteVenteDTO) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantTotalParProduit = montantTotalParProduit;
        this.produit = produit;
        this.EnteteVente = EnteteVente;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public EnteteVente getEnteteVenteDTO() {
        return EnteteVente;
    }

    public void setEnteteVenteDTO(EnteteVente EnteteVente) {
        this.EnteteVente = EnteteVente;
    }

    public DetVenteDTO() {
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
