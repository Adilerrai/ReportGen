package com.example.invoice.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String adresse;

    private String telephone;

    private String email;

    private String infoSupplementaire;


    @OneToMany(mappedBy = "fournisseur")
    private List<Achat> achats;

    public Fournisseur() {
    }

    public Fournisseur( List<Achat> achats,  Long id, String nom, String adresse, String telephone, String email, String infoSupplementaire) {
        this.id = id;
        this.nom = nom;
        this.achats = achats;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.infoSupplementaire = infoSupplementaire;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoSupplementaire() {
        return infoSupplementaire;
    }

    public void setInfoSupplementaire(String infoSupplementaire) {
        this.infoSupplementaire = infoSupplementaire;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
}
