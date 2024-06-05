package com.example.invoice.model;

import com.example.invoice.enums.StatusEnteteAchat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.sql.Date;


public class EnteteAchatCriteria {


    private    Long  fournisseurId;
    private StatusEnteteAchat statusEnteteAchat;

    private Date dateRecherheDebut;

    private Date dateRechercheFin;

    private Date dateEnteteAchat;


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

    public Date getDateEnteteAchat() {
        return dateEnteteAchat;
    }

    public void setDateEnteteAchat(Date dateEnteteAchat) {
        this.dateEnteteAchat = dateEnteteAchat;
    }

    public StatusEnteteAchat getStatusEnteteAchat() {
        return statusEnteteAchat;
    }

    public void setStatusEnteteAchat(StatusEnteteAchat statusEnteteAchat) {
        this.statusEnteteAchat = statusEnteteAchat;
    }
}
