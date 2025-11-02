package org.example.patient.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Observation")
public class ObservationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false,name="Id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "IdNumber")
    private PatientsEntity patientId;
    @Column(name = "encounterId")
    private boolean encounterId;
    @Column(name = "code")
    private String code;
    @Column(name = "value")
    private String value;
    @Column(name = "effectDate")
    private LocalDate effectiveDateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientsEntity getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientsEntity patientId) {
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

    public ObservationEntity(PatientsEntity patientId, boolean encounterId, String code, String value, LocalDate effectiveDateTime) {
        this.patientId = patientId;
        this.encounterId = encounterId;
        this.code = code;
        this.value = value;
        this.effectiveDateTime = effectiveDateTime;
    }

    public ObservationEntity() {
    }
}
