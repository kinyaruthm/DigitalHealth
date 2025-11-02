package org.example.patient.dtos.responses;


import org.example.patient.Model.PatientsEntity;
import org.example.patient.dtos.requests.PatientRequest;

import java.time.LocalDate;
import java.util.List;


public class PatientsResponse {
    private int identifier;
    private String givenName;
    private String familyName;
    private LocalDate birthDate;
    private PatientsEntity.Gender gender;
    private List<EncounterResponse> encounters;
    private List<ObservationResponse> observations;

    public PatientsResponse(List<EncounterResponse> encounters, List<ObservationResponse> observations) {
        this.encounters = encounters;
        this.observations = observations;
    }

    public PatientsEntity.Gender getGender() {
        return gender;
    }

    public void setGender(PatientsEntity.Gender gender) {
        this.gender = gender;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PatientsResponse(String givenName, String familyName, LocalDate birthDate, PatientsEntity.Gender gender) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public List<EncounterResponse> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterResponse> encounters) {
        this.encounters = encounters;
    }

    public List<ObservationResponse> getObservations() {
        return observations;
    }

    public void setObservations(List<ObservationResponse> observations) {
        this.observations = observations;
    }
}
