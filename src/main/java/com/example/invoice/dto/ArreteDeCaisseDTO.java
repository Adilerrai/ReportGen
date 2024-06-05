package com.example.invoice.dto;

import java.math.BigDecimal;

public class ArreteDeCaisseDTO {

    private Long id;


    private BigDecimal totalEnteteAchat = BigDecimal.ZERO;

    private BigDecimal totalVente = BigDecimal.ZERO;

    private BigDecimal totalDepense = BigDecimal.ZERO;


    private BigDecimal totalBenefice = BigDecimal.ZERO;



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

    public ArreteDeCaisseDTO () {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArreteDeCaisseDTO(BigDecimal totalBenefice,  BigDecimal totalDepense, BigDecimal totalVente, BigDecimal totalEnteteAchat, Long id) {
        this.totalBenefice = totalBenefice;

        this.totalDepense = totalDepense;
        this.totalVente = totalVente;
        this.totalEnteteAchat = totalEnteteAchat;
        this.id = id;
    }
}
