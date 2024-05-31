package com.example.invoice.model;


import jakarta.persistence.*;


@Entity
public class DetAchat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        private Produit produit;


        private int quantiteAchete;

        private double prixUnitaire;


        @ManyToOne(fetch = FetchType.LAZY)
        private Achat achat;


        public DetAchat() {
        }

        public DetAchat(Long id, Produit produit, int quantiteAchete, double prixUnitaire, Achat achat) {
            this.achat = achat;
            this.id = id;
            this.produit = produit;
            this.quantiteAchete = quantiteAchete;
            this.prixUnitaire = prixUnitaire;

        }


    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
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



    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
