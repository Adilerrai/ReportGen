package com.example.invoice.model;

import com.example.invoice.enums.StatusEnteteAchat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class EnteteAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private BigDecimal totalEnteteAchat = BigDecimal.ZERO;



    @OneToMany(mappedBy = "EnteteAchat")
    private List<DetAchat> DetAchats= new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    private    Fournisseur fournisseur;

    private StatusEnteteAchat statusEnteteAchat = StatusEnteteAchat.EN_ATTENTE;

    private Date dateEnteteAchat;

    public EnteteAchat() {
    }


    @Override
    public String toString() {
        return "EnteteAchat{" +
                "id=" + id +
                ", totalEnteteAchat=" + totalEnteteAchat +
                ", DetAchats=" + DetAchats +
                ", fournisseur=" + fournisseur +
                ", statusEnteteAchat=" + statusEnteteAchat +
                ", dateEnteteAchat=" + dateEnteteAchat +
                '}';
    }

    public EnteteAchat(Long id, BigDecimal totalEnteteAchat, List<DetAchat> DetAchats , Date dateEnteteAchat , StatusEnteteAchat   statusEnteteAchat , Fournisseur fournisseur) {
        this.id = id;
        this.totalEnteteAchat = totalEnteteAchat;
        this.fournisseur = fournisseur;
        this.DetAchats = DetAchats;
        this.statusEnteteAchat = statusEnteteAchat;
        this.dateEnteteAchat = dateEnteteAchat;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetAchat> getDetAchats() {
        return DetAchats;
    }

    public void setDetAchats(List<DetAchat> DetAchats) {
        this.DetAchats = DetAchats;
    }


    public Date getDateEnteteAchat() {
        return dateEnteteAchat;
    }

    public void setDateEnteteAchat(Date dateEnteteAchat) {
        this.dateEnteteAchat = dateEnteteAchat;
    }

    public BigDecimal getTotalEnteteAchat() {
        return totalEnteteAchat;
    }

    public void setTotalEnteteAchat(BigDecimal totalEnteteAchat) {
        this.totalEnteteAchat = totalEnteteAchat;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public StatusEnteteAchat getStatusEnteteAchat() {
        return statusEnteteAchat;
    }

    public void setStatusEnteteAchat(StatusEnteteAchat statusEnteteAchat) {
        this.statusEnteteAchat = statusEnteteAchat;
    }
}
