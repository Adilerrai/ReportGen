package com.example.invoice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusAchat {
    REGLE("REGLE"),
    EN_ATTENTE("EN_ATTENTE"),
    ANNULE("ANNULE");

    private String value;

    StatusAchat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static StatusAchat fromValue(String value) {
        for (StatusAchat statusAchat : StatusAchat.values()) {
            if (statusAchat.value.equalsIgnoreCase(value)) {
                return statusAchat;
            }
        }
        throw new IllegalArgumentException("Unknown enum value : " + value);
    }
}
