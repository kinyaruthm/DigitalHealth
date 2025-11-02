package org.example.patient.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Encounters")
public class EncounterEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false,name="Id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY) // LAZY is recommended for performance
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "IdNumber")
    private PatientsEntity patientId;

    @Column(name = "start-date")
    private LocalDate start;

    @Column(name = "end-date")
    private LocalDate end;

    @Column(name = "encounter-class")
    private String encounterClass;

    public EncounterEntity() {

    }


    public PatientsEntity getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientsEntity patientId) {
        this.patientId = patientId;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getEncounterClass() {
        return encounterClass;
    }

    public void setEncounterClass(String encounterClass) {
        this.encounterClass = encounterClass;
    }

    public EncounterEntity(PatientsEntity patientId, LocalDate start, LocalDate end, String encounterClass) {
        this.patientId = patientId;
        this.start = start;
        this.end = end;
        this.encounterClass = encounterClass;
    }
}
