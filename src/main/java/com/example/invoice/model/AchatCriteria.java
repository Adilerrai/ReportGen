package com.example.invoice.model;

import com.example.invoice.enums.StatusAchat;

import java.sql.Date;


public class AchatCriteria {


    private    Long  fournisseurId;

    private StatusAchat statusAchat;

    private Date dateRecherheDebut;

    private Date dateRechercheFin;

    private Date dateAchat;


    public Date getDateRecherheDebut() {
        return dateRecherheDebut;
    }

    public void setDateRecherheDebut(Date dateRecherheDebut) {
        this.dateRecherheDebut = dateRecherheDebut;
    }

    public Date getDateRechercheFin() {
        return dateRechercheFin;
    }

    public void setDateRechercheFin(Date dateRechercheFin) {
        this.dateRechercheFin = dateRechercheFin;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public StatusAchat getStatusAchat() {
        return statusAchat;
    }

    public void setStatusAchat(StatusAchat statusAchat) {
        this.statusAchat = statusAchat;
    }
}
