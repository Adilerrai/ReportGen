package com.example.invoice.dto;

import com.example.invoice.model.EnteteVente;

import java.util.List;


public class ClientDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private List<EnteteVente> EnteteVentes;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String nom, String prenom, String adresse, String email, String telephone, List<EnteteVente> EnteteVentes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.EnteteVentes = EnteteVentes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<EnteteVente> getEnteteVentes() {
        return EnteteVentes;
    }

    public void setEnteteVentes(List<EnteteVente> EnteteVentes) {
        this.EnteteVentes = EnteteVentes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
