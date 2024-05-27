package com.example.invoice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "det_facture")
public class DetFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantite;

    private BigDecimal prixUnitaire;


    @ManyToOne
    private Produit produit;

    private BigDecimal montantTotalParProduit;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private EnteteFact facture;


    public DetFacture(Long id, Long quantite, BigDecimal prixUnitaire, Produit produit, BigDecimal montantTotalParProduit, EnteteFact facture) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.produit = produit;
        this.montantTotalParProduit = montantTotalParProduit;
        this.facture = facture;
    }


    public DetFacture() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public BigDecimal getMontantTotalParProduit() {
        return montantTotalParProduit;
    }

    public void setMontantTotalParProduit(BigDecimal montantTotalParProduit) {
        this.montantTotalParProduit = montantTotalParProduit;
    }

    public EnteteFact getFacture() {
        return facture;
    }

    public void setFacture(EnteteFact facture) {
        this.facture = facture;
    }
}
