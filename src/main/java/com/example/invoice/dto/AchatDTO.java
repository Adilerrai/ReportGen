package com.example.invoice.dto;

import com.example.invoice.enums.StatusAchat;
import com.example.invoice.model.DetAchat;
import com.example.invoice.model.Fournisseur;
import com.example.invoice.model.Produit;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AchatDTO {

    private Long id;



    private BigDecimal totalAchat = BigDecimal.ZERO;



    private List<DetAchatDTO> detAchats= new ArrayList<>();


    private    FournisseurDTO fournisseur;

    private StatusAchat statusAchat = StatusAchat.EN_ATTENTE;

    private Date dateAchat;

    public AchatDTO() {
    }

    public AchatDTO(Long id, BigDecimal totalAchat, List<DetAchatDTO> detAchats, StatusAchat statusAchat, FournisseurDTO fournisseur, Date dateAchat) {
        this.id = id;
        this.totalAchat = totalAchat;
        this.detAchats = detAchats;
        this.statusAchat = statusAchat;
        this.fournisseur = fournisseur;
        this.dateAchat = dateAchat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public FournisseurDTO getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDTO fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<DetAchatDTO> getDetAchats() {
        return detAchats;
    }

    public void setDetAchats(List<DetAchatDTO> detAchats) {
        this.detAchats = detAchats;
    }

    public BigDecimal getTotalAchat() {
        return totalAchat;
    }

    public void setTotalAchat(BigDecimal totalAchat) {
        this.totalAchat = totalAchat;
    }
}
