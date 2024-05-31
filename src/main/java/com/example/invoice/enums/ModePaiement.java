package com.example.invoice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ModePaiement {
    ESPECE("ESPECE"),
    CHEQUE("CHEQUE"),
    VIREMENT("VIREMENT"),
    CARTE_BANCAIRE("CARTE_BANCAIRE");

    private String value;

    ModePaiement(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ModePaiement fromValue(String value) {
        for (ModePaiement modePaiement : ModePaiement.values()) {
            if (modePaiement.value.equalsIgnoreCase(value)) {
                return modePaiement;
            }
        }
        throw new IllegalArgumentException("Unknown enum value : " + value);
    }
}
