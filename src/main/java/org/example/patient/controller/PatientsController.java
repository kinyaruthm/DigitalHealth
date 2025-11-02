package org.example.patient.controller;

import org.example.patient.Model.EncounterEntity;
import org.example.patient.Model.PatientsEntity;
import org.example.patient.dtos.requests.EncounterRequest;
import org.example.patient.dtos.requests.PatientRequest;
import org.example.patient.dtos.responses.EncounterResponse;
import org.example.patient.dtos.responses.PatientsResponse;
import org.example.patient.service.PatientsService;
import org.example.patient.utils.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientsController {
    @Autowired
    private PatientsService patientsService;

    @GetMapping(path = "/patient/{idNumber}")
    public BasicResponse getPatientInfo(@PathVariable("idNumber") int idNumber) {
            BasicResponse res = new BasicResponse();
            res.setStatus(HttpStatus.OK.value());
            res.setMessage("Success");
            res.setData(patientsService.getAPatient(idNumber));
            return res;

    }

    @PostMapping(path = "/patient")
    public BasicResponse PatientInfoPOST(@RequestBody PatientsEntity request) {
        return patientsService.insertPatientsInfo(request);
    }

    @PutMapping(path = "/patient/{idNumber}")
    public BasicResponse updatePatientInfo(@RequestBody PatientsEntity request, @PathVariable("idNumber") int idNumber) {
        return patientsService.updatePatientInfo(request, idNumber);
    }

    @DeleteMapping(path = "/patient/{idNumber}")
    public BasicResponse deletePatient(@PathVariable("idNumber") int idNumber) {
        return patientsService.deleteAPatient(idNumber);
    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<PatientsResponse>> searchPatients(@RequestParam("family") String familyName, @RequestParam("given") String givenName, @RequestParam("identifier") int identifier, @RequestParam("birthDate") String birthDate) {
//        Connection conn = null;
//        List<PatientsResponse> results = patientsService.findPatientsByCriteria(
//                familyName,
//                givenName,
//                identifier,
//                birthDate
//        );
//        return ResponseEntity.ok(results);
//    }

    @GetMapping
    public List<PatientsEntity> search(
            @RequestParam(required = false) String family,
            @RequestParam(required = false) String given,
            @RequestParam(required = false) String identifier,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDateTo) {

        return patientsService.search(family, given, identifier, birthDate, birthDateFrom, birthDateTo);
    }

    @GetMapping(path = "/patient/{patientId}")
    public BasicResponse getPatientEncounters(@PathVariable("patientId") int patientId) {
        List<EncounterEntity> encounters =
                patientsService.getEncountersByPatientId(patientId);
        return BasicResponse.OfSuccess(encounters);

    }

    @GetMapping(path = "/patient/observation/{patientId}")
    public BasicResponse getPatientObservatiosn(@PathVariable("patientId") int patientId) {
        List<EncounterEntity> encounters =
                patientsService.getEncountersByPatientId(patientId);
        return BasicResponse.OfSuccess(encounters);

    }
}
