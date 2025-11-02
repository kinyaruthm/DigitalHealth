package org.example.patient.repository;

import jakarta.transaction.Transactional;
import jdk.jfr.Registered;
import org.example.patient.Model.PatientsEntity;
import org.example.patient.dtos.requests.PatientRequest;
import org.example.patient.dtos.responses.PatientsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<PatientsEntity, Integer>, JpaSpecificationExecutor<PatientsEntity> {

    Optional<PatientsEntity> findByIdentifier(int identifier);

}
