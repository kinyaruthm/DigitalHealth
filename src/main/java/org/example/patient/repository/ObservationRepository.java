package org.example.patient.repository;

import jakarta.transaction.Transactional;
import org.example.patient.Model.EncounterEntity;
import org.example.patient.Model.ObservationEntity;
import org.example.patient.Model.PatientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ObservationRepository extends JpaRepository<ObservationEntity, Integer> {
    List<ObservationEntity> findByPatientId_Id(int patientId);
}
