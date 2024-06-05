package com.example.invoice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "det_facture")
public class DetVente {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Long quantite;



    private int promotion;



    private BigDecimal prixUnitaire;



    @ManyToOne
    private Produit produit;



    private BigDecimal montantTotalParProduit;



    @ManyToOne
    @JoinColumn(name = "facture_id")
    private EnteteVente enteteVente;












    public DetVente(Long id, Long quantite, BigDecimal prixUnitaire,  Produit produit, BigDecimal montantTotalParProduit, EnteteVente enteteVente) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire= prixUnitaire;
        this.produit = produit;
        this.montantTotalParProduit = montantTotalParProduit;
        this.enteteVente = enteteVente;
    }







    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }


    public DetVente() {
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

    public EnteteVente getEnteteVente() {
        return enteteVente;
    }

    public void setEnteteVente(EnteteVente facture) {
        this.enteteVente = facture;
    }



}
