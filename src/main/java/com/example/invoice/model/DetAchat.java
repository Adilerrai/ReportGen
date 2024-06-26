package com.example.invoice.model;


import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class DetAchat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        private Produit produit;


        private int quantiteAchete;

        private double prixUnitaire;
            private BigDecimal totalParProduit;

        @ManyToOne(fetch = FetchType.LAZY)
        private EnteteAchat EnteteAchat;


        public DetAchat() {
        }

        public DetAchat(Long id, Produit produit, BigDecimal totalParProduit  , int quantiteAchete, double prixUnitaire, EnteteAchat EnteteAchat) {
            this.EnteteAchat = EnteteAchat;
            this.id = id;
            this.totalParProduit= totalParProduit;
            this.produit = produit;
            this.quantiteAchete = quantiteAchete;
            this.prixUnitaire = prixUnitaire;

        }


    public EnteteAchat getEnteteAchat() {
        return EnteteAchat;
    }

    public void setEnteteAchat(EnteteAchat EnteteAchat) {
        this.EnteteAchat = EnteteAchat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantiteAchete() {
        return quantiteAchete;
    }

    public void setQuantiteAchete(int quantite) {
        this.quantiteAchete = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public BigDecimal getTotalParProduit() {
        return totalParProduit;
    }

    public void setTotalParProduit(BigDecimal totalParProduit) {
        this.totalParProduit = totalParProduit;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
