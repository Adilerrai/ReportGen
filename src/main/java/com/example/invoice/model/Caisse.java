package com.example.invoice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Caisse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal soldeDeCaisse=BigDecimal.ZERO;
    private BigDecimal totalEnteteAchats=BigDecimal.ZERO;
    private BigDecimal totalDepenses=BigDecimal.ZERO;
    private BigDecimal difference=BigDecimal.ZERO;
    private BigDecimal totalVentes=BigDecimal.ZERO;

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
