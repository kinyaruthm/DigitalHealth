package org.example.patient.dtos.requests;
import jakarta.persistence.*;
import org.example.patient.Model.PatientsEntity;

import java.time.LocalDate;

public class EncounterRequest {

    private int id;
    private PatientsEntity patientId;
    private LocalDate start;

    private LocalDate end;

    private String encounterClass;

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

    public EncounterRequest(PatientsEntity patientId, LocalDate start, LocalDate end, String encounterClass) {
        this.patientId = patientId;
        this.start = start;
        this.end = end;
        this.encounterClass = encounterClass;
    }

    public EncounterRequest() {
    }
}
