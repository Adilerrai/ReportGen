package com.example.invoice.model;


import com.example.invoice.enums.Status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class EnteteFact {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long numeroFacture;

    private Date dateFacture;

    private String modePaiement;

    private Status statut;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(fetch = FetchType.EAGER)
    private List<DetFacture> detFactures;

    public EnteteFact() {
    }

    public EnteteFact(Long id, Long numeroFacture, Date dateFacture, String modePaiement, Status statut, Client client, List<DetFacture> detFactures) {
        this.id = id;
        this.numeroFacture = numeroFacture;
        this.dateFacture = dateFacture;
        this.modePaiement = modePaiement;
        this.statut = statut;
        this.client = client;
        this.detFactures = detFactures;
    }


    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
