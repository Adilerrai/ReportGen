package com.example.invoice.dto;

import com.example.invoice.model.EnteteFact;
import jakarta.persistence.*;

import java.util.List;


public class ClientDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private List<EnteteFact> enteteFacts;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String nom, String prenom, String adresse, String email, String telephone, List<EnteteFact> enteteFacts) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.enteteFacts = enteteFacts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<EnteteFact> getEnteteFacts() {
        return enteteFacts;
    }

    public void setEnteteFacts(List<EnteteFact> enteteFacts) {
        this.enteteFacts = enteteFacts;
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
