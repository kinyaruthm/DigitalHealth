package org.example.patient.dtos.responses;

import java.time.LocalDate;

public class ObservationResponse {
    private int id;
    private int patientId;
    private boolean encounterId;
    private String code;
    private String value;
    private LocalDate effectiveDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public boolean isEncounterId() {
        return encounterId;
    }

    public void setEncounterId(boolean encounterId) {
        this.encounterId = encounterId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getEffectiveDateTime() {
        return effectiveDateTime;
    }

    public void setEffectiveDateTime(LocalDate effectiveDateTime) {
        this.effectiveDateTime = effectiveDateTime;
    }
}
