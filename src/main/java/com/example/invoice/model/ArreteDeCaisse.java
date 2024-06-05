package com.example.invoice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;


@Entity
public class ArreteDeCaisse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private BigDecimal totalEnteteAchat = BigDecimal.ZERO;

    private BigDecimal totalVente = BigDecimal.ZERO;

    private BigDecimal totalDepense = BigDecimal.ZERO;


    private BigDecimal totalBenefice = BigDecimal.ZERO;


    public ArreteDeCaisse(BigDecimal totalEnteteAchat, Long id, BigDecimal totalVente, BigDecimal totalDepense, BigDecimal totalBenefice) {
        this.totalEnteteAchat = totalEnteteAchat;
        this.id = id;
        this.totalVente = totalVente;
        this.totalDepense = totalDepense;
        this.totalBenefice = totalBenefice;
    }

    public ArreteDeCaisse() {
    }

    public BigDecimal getTotalEnteteAchat() {
        return totalEnteteAchat;
    }

    public void setTotalEnteteAchat(BigDecimal totalEnteteAchat) {
        this.totalEnteteAchat = totalEnteteAchat;
    }

    public BigDecimal getTotalVente() {
        return totalVente;
    }

    public void setTotalVente(BigDecimal totalVente) {
        this.totalVente = totalVente;
    }

    public BigDecimal getTotalDepense() {
        return totalDepense;
    }

    public void setTotalDepense(BigDecimal totalDepense) {
        this.totalDepense = totalDepense;
    }



    public BigDecimal getTotalBenefice() {
        return totalBenefice;
    }

    public void setTotalBenefice(BigDecimal totalBenefice) {
        this.totalBenefice = totalBenefice;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
