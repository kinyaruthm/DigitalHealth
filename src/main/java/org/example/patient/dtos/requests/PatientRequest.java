package org.example.patient.dtos.requests;

import jakarta.persistence.*;
import org.example.patient.Model.PatientsEntity;

import java.time.LocalDate;

public class PatientRequest {
    private int id;

    private int identifier;

    private String givenName;

    private String familyName;

    private LocalDate birthDate;

    private PatientsEntity.Gender gender;

    public PatientRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PatientsEntity.Gender getGender() {
        return gender;
    }

    public void setGender(PatientsEntity.Gender gender) {
        this.gender = gender;
    }

    public PatientRequest(int identifier, String givenName, String familyName, LocalDate birthDate, PatientsEntity.Gender gender) {
        this.identifier = identifier;
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}

