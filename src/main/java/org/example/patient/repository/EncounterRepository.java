package org.example.patient.repository;


import jakarta.transaction.Transactional;
import org.example.patient.Model.EncounterEntity;
import org.example.patient.dtos.responses.EncounterResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EncounterRepository extends JpaRepository<EncounterEntity, Integer> {
    List<EncounterEntity> findByPatientId_Id(int patientId);

}
