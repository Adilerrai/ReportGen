package com.example.invoice.dto;

import java.math.BigDecimal;

public class ArreteDeCaisseDTO {

    private Long id;


    private BigDecimal totalAchat = BigDecimal.ZERO;

    private BigDecimal totalVente = BigDecimal.ZERO;

    private BigDecimal totalDepense = BigDecimal.ZERO;


    private BigDecimal totalBenefice = BigDecimal.ZERO;



    public BigDecimal getTotalAchat() {
        return totalAchat;
    }

    public void setTotalAchat(BigDecimal totalAchat) {
        this.totalAchat = totalAchat;
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

    public ArreteDeCaisseDTO () {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArreteDeCaisseDTO(BigDecimal totalBenefice,  BigDecimal totalDepense, BigDecimal totalVente, BigDecimal totalAchat, Long id) {
        this.totalBenefice = totalBenefice;

        this.totalDepense = totalDepense;
        this.totalVente = totalVente;
        this.totalAchat = totalAchat;
        this.id = id;
    }
}
