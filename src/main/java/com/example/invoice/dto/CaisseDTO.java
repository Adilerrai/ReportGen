package com.example.invoice.dto;

import java.math.BigDecimal;

public class CaisseDTO {

    private Long id;

    private BigDecimal soldeDeCaisse=BigDecimal.ZERO;
    private BigDecimal totalEnteteAchats=BigDecimal.ZERO;
    private BigDecimal totalDepenses=BigDecimal.ZERO;
    private BigDecimal difference=BigDecimal.ZERO;
    private BigDecimal totalVentes= BigDecimal.ZERO;


    public CaisseDTO() {
    }

    public CaisseDTO(Long id, BigDecimal soldeDeCaisse, BigDecimal totalEnteteAchats, BigDecimal totalDepenses, BigDecimal difference, BigDecimal totalVentes) {
        this.id = id;
        this.soldeDeCaisse = soldeDeCaisse;
        this.totalEnteteAchats = totalEnteteAchats;
        this.totalDepenses = totalDepenses;
        this.difference = difference;
        this.totalVentes = totalVentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSoldeDeCaisse() {
        return soldeDeCaisse;
    }

    public void setSoldeDeCaisse(BigDecimal soldeDeCaisse) {
        this.soldeDeCaisse = soldeDeCaisse;
    }

    public BigDecimal getTotalEnteteAchats() {
        return totalEnteteAchats;
    }

    public void setTotalEnteteAchats(BigDecimal totalEnteteAchats) {
        this.totalEnteteAchats = totalEnteteAchats;
    }

    public BigDecimal getTotalDepenses() {
        return totalDepenses;
    }

    public void setTotalDepenses(BigDecimal totalDepenses) {
        this.totalDepenses = totalDepenses;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }

    public BigDecimal getTotalVentes() {
        return totalVentes;
    }

    public void setTotalVentes(BigDecimal totalVentes) {
        this.totalVentes = totalVentes;
    }
}
