package com.example.invoice.dto;

import com.example.invoice.enums.Status;
import com.example.invoice.model.Client;
import com.example.invoice.model.DetFacture;


import java.util.Date;
import java.util.List;

public class EnteteRechercheDTO {

    private Long id;

    private Long numeroFacture;

    private Date dateFacture;

    private String modePaiement;

    private Status statut;



    private Client client;

    private List<DetFacture> detFactures;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetFacture> getDetFactures() {
        return detFactures;
    }

    public void setDetFactures(List<DetFacture> detFactures) {
        this.detFactures = detFactures;
    }
}
