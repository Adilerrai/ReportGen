package com.example.invoice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnteteAchat {
    REGLE("REGLE"),
    EN_ATTENTE("EN_ATTENTE"),
    ANNULE("ANNULE");

    private String value;

    StatusEnteteAchat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static StatusEnteteAchat fromValue(String value) {
        for (StatusEnteteAchat statusEnteteAchat : StatusEnteteAchat.values()) {
            if (statusEnteteAchat.value.equalsIgnoreCase(value)) {
                return statusEnteteAchat;
            }
        }
        throw new IllegalArgumentException("Unknown enum value : " + value);
    }
}
