package com.example.invoice.model;


import com.example.invoice.enums.ModePaiement;
import com.example.invoice.enums.Status;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class EnteteVente {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Long numeroFacture;



    private Timestamp dateFacture;



    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;



    private Timestamp createdDate;




    private BigDecimal totalFacture = BigDecimal.ZERO;



    @Enumerated(EnumType.STRING)
    private Status statut;



    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;


    @OneToMany(fetch = FetchType.EAGER)
    private List<DetVente> detVentes ;





    public EnteteVente() {
    }

    public EnteteVente (Long id, Client client, Status statut, BigDecimal totalFacture, Timestamp createdDate, Timestamp dateFacture, Long numeroFacture, ModePaiement modePaiement, List<DetVente> detVentes) {
        this.id = id;
        this.client = client;
        this.statut = statut;
        this.totalFacture = totalFacture;
        this.createdDate = createdDate;
        this.dateFacture = dateFacture;
        this.numeroFacture = numeroFacture;
        this.modePaiement = modePaiement;
        this.detVentes = detVentes;
    }

    public BigDecimal getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(BigDecimal totalFacture) {
        this.totalFacture = totalFacture;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Timestamp getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Timestamp dateFacture) {
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
        return detVentes;
    }

    public void setDetVentes(List<DetVente> DetVentes) {
        this.detVentes = DetVentes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "EnteteVente{" +
                "id=" + id +
                ", numeroFacture=" + numeroFacture +
                ", dateFacture=" + dateFacture +
                ", modePaiement=" + modePaiement +
                ", createdDate=" + createdDate +
                ", statut=" + statut +
                ", client=" + client +
                ", DetVentes=" + detVentes +
                '}';
    }
}
