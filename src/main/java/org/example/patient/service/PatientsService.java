package org.example.patient.service;

import org.example.patient.Model.EncounterEntity;
import org.example.patient.Model.ObservationEntity;
import org.example.patient.Model.PatientsEntity;
import org.example.patient.dtos.requests.PatientRequest;
import org.example.patient.dtos.responses.EncounterResponse;
import org.example.patient.dtos.responses.PatientsResponse;
import org.example.patient.repository.EncounterRepository;
import org.example.patient.repository.ObservationRepository;
import org.example.patient.repository.PatientRepository;
import org.example.patient.utils.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {
    private final PatientRepository patientRepository;
    private final EncounterRepository encounterRepository;
    private final ObservationRepository observationRepository;

    @Autowired
    public PatientsService(PatientRepository patientRepository, EncounterRepository encounterRepository, ObservationRepository observationRepository) {
        this.patientRepository = patientRepository;
        this.encounterRepository = encounterRepository;
        this.observationRepository = observationRepository;
    }

    public Optional<Optional<PatientsEntity>> getAPatient(int id) {
        Optional<Optional<PatientsEntity>> patientinfo = Optional.ofNullable(patientRepository.findByIdentifier(id));
        return patientinfo;
    }

    public BasicResponse insertPatientsInfo(PatientsEntity request) {
        PatientsEntity patient = new PatientsEntity(
                request.getIdentifier(),
                request.getGivenName(),
                request.getFamilyName(),
                request.getBirthDate(),
                request.getGender()
        );
        patientRepository.save(patient);
        return BasicResponse.OfSuccess();
    }


    public BasicResponse updatePatientInfo(PatientsEntity request, int idNumber) {
        PatientsEntity existingPatient = patientRepository.findByIdentifier(idNumber).orElseThrow(() -> new RuntimeException("Patient not found with identifier: " + idNumber));
        existingPatient.setIdentifier(request.getIdentifier());
        existingPatient.setGivenName(request.getGivenName());
        existingPatient.setFamilyName(request.getFamilyName());
        existingPatient.setBirthDate(request.getBirthDate());
        existingPatient.setGender(request.getGender());
        patientRepository.save(existingPatient);
        return BasicResponse.OfSuccess();
    }

    public BasicResponse deleteAPatient(int idNumber) {
        PatientsEntity existingPatient = patientRepository.findByIdentifier(idNumber).orElseThrow(() -> new RuntimeException("Patient not found with identifier: " + idNumber));
        existingPatient.setIdentifier(idNumber);
        patientRepository.delete(existingPatient);
        return BasicResponse.OfSuccess("successfully deleted");
    }
//
//
//    public List<PatientsResponse> findPatientsByCriteria( String familyName, String givenName, int identifier, String birthDateString) {
//        Optional<Optional<PatientsEntity>> patientinfo = Optional.ofNullable(patientRepository.findByIdentifier(identifier));
//        if(!familyName.isEmpty()){
//            List<EncounterEntity> encounterEntities = encounterRepository.findByPatientId_Id(patientinfo.get().get().getIdentifier());
//        }
//
//        List<PatientsResponse> response = patientRepository.findPatientsByCriteria(familyName, givenName, identifier, birthDateString);
////
//        return response;
//    }

    public List<EncounterEntity> getEncountersByPatientId(int patientId) {
        List<EncounterEntity> encounters = encounterRepository.findByPatientId_Id(patientId);
        return encounters;
    }

    public List<ObservationEntity> getObservationsByPatientId(int patientId) {
        List<ObservationEntity> observations = observationRepository.findByPatientId_Id(patientId);
        return observations;
    }
}
