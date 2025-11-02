//package org.example.patient.repository;
//
//import org.example.patient.dtos.requests.PatientRequest;
//import org.example.patient.dtos.responses.EncounterResponse;
//import org.example.patient.dtos.responses.PatientsResponse;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public abstract class PatientsRepository implements JpaRepository<PatientRequest, Long> {
//
//    public PatientsRepository() {
//        // no-arg constructor
//    }
//
//    //GET patients by id
////
////    public static PatientsResponse getPatientById(Connection conn, int id) {
////        PatientsResponse patientresponse = new PatientsResponse();
////
////        String sql = "SELECT * FROM Patient.PatientsFile where IDNumber=?";
////
////        try {
////            try (PreparedStatement pst = conn.prepareStatement(sql);) {
////                pst.setInt(1, id);
////                try (ResultSet rs = pst.executeQuery()) {
////                    if (rs.next()) {
////                        patientresponse.setIdentifier(rs.getInt("IdNumber"));
////                        patientresponse.setGender(PatientRequest.Gender.valueOf(rs.getString("Gender")));
////                        patientresponse.setFamilyName(rs.getString("FamilyName"));
////                        patientresponse.setGivenName(rs.getString("GivenName"));
////                        patientresponse.setBirthDate(rs.getDate("BirthdDate").toLocalDate());
////                    }
////                }
////            }
////            return patientresponse;
////        } catch (Exception e) {
////            throw new RuntimeException("Failed to find all activities !", e);
////        }
////    }
//
//    public static int updateInfo(Connection conn, PatientRequest request, int idNumber) {
//
//        String update = "UPDATE Patient.PatientsFile SET IdNumber=?,Gender=?,FamilyName=?,GivenName=?,BirthdDate=? where IDNumber=?";
//
//        try (PreparedStatement updateStmt = conn.prepareStatement(update)) {
//            updateStmt.setInt(1, request.getIdentifier());
//            updateStmt.setString(2, request.getGender().toString());
//            updateStmt.setString(3, request.getFamilyName());
//            updateStmt.setString(4, request.getGivenName());
//            updateStmt.setString(5, request.getBirthDate().toString());
//            updateStmt.setInt(6, idNumber);
//
//            int updated = updateStmt.executeUpdate();
//            if (updated > 0) {
//                return 1;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return 1;
//    }
//
//    public static int insertpatientsInfo(Connection conn, PatientRequest request) {
//        String insert = "INSERT INTO Patient.PatientsFile (IdNumber,Gender,FamilyName,GivenName,BirthdDate) VALUES (?,?,?,?,?)";
//        int updated;
//        try (PreparedStatement stmt = conn.prepareStatement(insert)) {
//            stmt.setInt(1, request.getIdentifier());
//            stmt.setString(2, request.getGender().toString());
//            stmt.setString(3, request.getFamilyName());
//            stmt.setString(4, request.getGivenName());
//            stmt.setString(5, request.getBirthDate().toString());
//
//            updated = stmt.executeUpdate();
//            if (updated > 0) {
//                return updated;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return updated;
//    }
//
//    public static int deleteInfo(Connection conn, int idNumber) {
//        int updated;
//
//        String delete = "SELECT * FROM Patient.PatientsFile where IDNumber=?";
//        try (PreparedStatement stmt = conn.prepareStatement(delete)) {
//            stmt.setInt(1, idNumber);
//            updated = stmt.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return updated;
//    }
//
//    public static List<PatientsResponse> findPatientsByCriteria(
//            Connection conn,
//            String familyName,
//            String givenName,
//            String identifier,
//            String birthDateString
//    ) {
//        List<PatientsResponse> results = new ArrayList<>();
//        List<Object> parameters = new ArrayList<>();
//
//        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Patient.PatientsFile WHERE 1=1");
//
//        if (familyName != null && !familyName.isEmpty()) {
//            sqlBuilder.append(" AND FamilyName = ?");
//            parameters.add(familyName);
//        }
//        if (givenName != null && !givenName.isEmpty()) {
//            sqlBuilder.append(" AND GivenName = ?");
//            parameters.add(givenName);
//        }
//        if (identifier != null && !identifier.isEmpty()) {
//            sqlBuilder.append(" AND IdNumber = ?");
//            parameters.add(identifier);
//        }
//        if (birthDateString != null && !birthDateString.isEmpty()) {
//            sqlBuilder.append(" AND BirthDate = ?");
//
//            try {
//                LocalDate date = LocalDate.parse(birthDateString);
//                parameters.add(Date.valueOf(date));
//            } catch (Exception e) {
//                throw new IllegalArgumentException("Invalid birthDate format: expected YYYY-MM-DD", e);
//            }
//        }
//
//        String finalSql = sqlBuilder.toString();
//        try (PreparedStatement pst = conn.prepareStatement(finalSql)) {
//
//            for (int i = 0; i < parameters.size(); i++) {
//                pst.setObject(i + 1, parameters.get(i));
//            }
//
//            try (ResultSet rs = pst.executeQuery()) {
//
//                while (rs.next()) {
//                    PatientsResponse patientResponse = new PatientsResponse();
//                    patientResponse.setIdentifier(rs.getInt("IdNumber"));
//                    patientResponse.setGender(PatientRequest.Gender.valueOf(rs.getString("Gender").toUpperCase()));
//                    patientResponse.setFamilyName(rs.getString("FamilyName"));
//                    patientResponse.setGivenName(rs.getString("GivenName"));
//                    Date sqlDate = rs.getDate("BirthDate");
//                    if (sqlDate != null) {
//                        patientResponse.setBirthDate(sqlDate.toLocalDate());
//                    }
//
//                    results.add(patientResponse);
//                }
//            }
//            return results;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to execute patient search query: " + finalSql, e);
//        }
//    }
//
//    public static List<EncounterResponse> getEncounterByPatientid(Connection conn, int id) {
//        List<EncounterResponse> encounters = new ArrayList<>();
//
//        String sql = "SELECT * FROM Patient.Encounters where patient_id=?";
//
//        try {
//            try (PreparedStatement pst = conn.prepareStatement(sql);) {
//                pst.setInt(1, id);
//                try (ResultSet rs = pst.executeQuery()) {
//                    while (rs.next()) {
//                        EncounterResponse res = new EncounterResponse();
//                        res.setStart(rs.getDate("StartDate").toLocalDate());
//                        res.setEnd(rs.getDate("EndDate").toLocalDate());
//                        res.getPatientId().setId(id);
//                        encounters.add(res);
//                        return encounters;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to find !", e);
//        }
//        return encounters;
//    }
//}
