package org.example.patient.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PatientsFile")
public class PatientsEntity {

    public enum Gender {
        MALE, FEMALE, NON_BINARY, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Id")
    private int id;

    @Column(unique = true, name = "IdNumber", nullable = false)
    private int identifier;

    @Column(name = "GivenName")
    private String givenName;

    @Column(name = "FamilyName")
    private String familyName;

    @Column(name = "BirthDate")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    public PatientsEntity() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PatientsEntity(int identifier, String givenName, String familyName, LocalDate birthDate, Gender gender) {
        this.identifier = identifier;
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
