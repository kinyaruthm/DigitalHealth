package org.example.patient.dtos.responses;

import jakarta.persistence.Column;
import org.example.patient.dtos.requests.PatientRequest;

import java.time.LocalDate;

public class EncounterResponse {
    private PatientRequest patientId;
    private LocalDate start;
    private LocalDate end;
    private String encounterClass;

    public PatientRequest getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientRequest patientId) {
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
}
