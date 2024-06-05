package com.example.invoice.dto;

import com.example.invoice.enums.ModePaiement;
import com.example.invoice.enums.Status;
import com.example.invoice.model.Client;
import com.example.invoice.model.DetVente;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class EnteteVenteDTO {

    private Long id;

    private Long numeroFacture;

    private Date dateFacture;

    private ModePaiement modePaiement;

    private Date createdDate;

    private Status statut;

    private BigDecimal totalFacture = BigDecimal.ZERO;

    private Client client;

    private List<DetVente> DetVentes;

    public EnteteVenteDTO() {
    }

    public EnteteVenteDTO(BigDecimal totalFacture ,Long id, Long numeroFacture, Date dateFacture, ModePaiement modePaiement, Status statut, Client client, List<DetVente> DetVentes) {
        this.id = id;
        this.numeroFacture = numeroFacture;
        this.dateFacture = dateFacture;
        this.modePaiement = modePaiement;
        this.statut = statut;
        this.client = client;
        this.totalFacture = totalFacture;
        this.DetVentes = DetVentes;
    }


    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Timestamp getDateFacture() {
        return (Timestamp) dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Status getStatut() {
        return statut;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public List<DetVente> getDetVentes() {
        return DetVentes;
    }

    public void setDetVentes(List<DetVente> DetVentes) {
        this.DetVentes = DetVentes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(BigDecimal totalFacture) {
        this.totalFacture = totalFacture;
    }
}
