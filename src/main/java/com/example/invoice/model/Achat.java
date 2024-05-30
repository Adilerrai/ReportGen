package com.example.invoice.model;

import com.example.invoice.enums.StatusAchat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private BigDecimal totalAchat = BigDecimal.ZERO;



    @OneToMany(mappedBy = "achat")
    private List<DetAchat> detAchats= new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    private    Fournisseur fournisseur;

    private StatusAchat statusAchat = StatusAchat.EN_ATTENTE;

    private Date dateAchat;

    public Achat() {
    }


    @Override
    public String toString() {
        return "Achat{" +
                "id=" + id +
                ", totalAchat=" + totalAchat +
                ", detAchats=" + detAchats +
                ", fournisseur=" + fournisseur +
                ", statusAchat=" + statusAchat +
                ", dateAchat=" + dateAchat +
                '}';
    }

    public Achat(Long id, BigDecimal totalAchat, List<DetAchat> detAchats , Date dateAchat , StatusAchat   statusAchat , Fournisseur fournisseur) {
        this.id = id;
        this.totalAchat = totalAchat;
        this.fournisseur = fournisseur;
        this.detAchats = detAchats;
        this.statusAchat = statusAchat;
        this.dateAchat = dateAchat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetAchat> getDetAchats() {
        return detAchats;
    }

    public void setDetAchats(List<DetAchat> detAchats) {
        this.detAchats = detAchats;
    }


    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public BigDecimal getTotalAchat() {
        return totalAchat;
    }

    public void setTotalAchat(BigDecimal totalAchat) {
        this.totalAchat = totalAchat;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public StatusAchat getStatusAchat() {
        return statusAchat;
    }

    public void setStatusAchat(StatusAchat statusAchat) {
        this.statusAchat = statusAchat;
    }
}
