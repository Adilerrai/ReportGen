package com.example.invoice.dto;

import com.example.invoice.enums.StatusEnteteAchat;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EnteteAchatDTO {

    private Long id;



    private BigDecimal totalEnteteAchat = BigDecimal.ZERO;



    private List<DetAchatDTO> DetAchats= new ArrayList<>();


    private    FournisseurDTO fournisseur;

    private StatusEnteteAchat statusEnteteAchat = StatusEnteteAchat.EN_ATTENTE;

    private Date dateEnteteAchat;

    public EnteteAchatDTO() {
    }

    public EnteteAchatDTO(Long id, BigDecimal totalEnteteAchat, List<DetAchatDTO> DetAchats, StatusEnteteAchat statusEnteteAchat, FournisseurDTO fournisseur, Date dateEnteteAchat) {
        this.id = id;
        this.totalEnteteAchat = totalEnteteAchat;
        this.DetAchats = DetAchats;
        this.statusEnteteAchat = statusEnteteAchat;
        this.fournisseur = fournisseur;
        this.dateEnteteAchat = dateEnteteAchat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public FournisseurDTO getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDTO fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<DetAchatDTO> getDetAchats() {
        return DetAchats;
    }

    public void setDetAchats(List<DetAchatDTO> DetAchats) {
        this.DetAchats = DetAchats;
    }

    public BigDecimal getTotalEnteteAchat() {
        return totalEnteteAchat;
    }

    public void setTotalEnteteAchat(BigDecimal totalEnteteAchat) {
        this.totalEnteteAchat = totalEnteteAchat;
    }
}
