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
    private List<EnteteAchat> EnteteAchats;

    public Fournisseur() {
    }

    public Fournisseur( List<EnteteAchat> EnteteAchats,  Long id, String nom, String adresse, String telephone, String email, String infoSupplementaire) {
        this.id = id;
        this.nom = nom;
        this.EnteteAchats = EnteteAchats;
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

    public List<EnteteAchat> getEnteteAchats() {
        return EnteteAchats;
    }

    public void setEnteteAchats(List<EnteteAchat> EnteteAchats) {
        this.EnteteAchats = EnteteAchats;
    }
}
