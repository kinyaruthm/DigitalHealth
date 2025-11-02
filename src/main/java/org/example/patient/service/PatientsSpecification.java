package org.example.patient.service;

import org.example.patient.Model.PatientsEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class PatientsSpecification {

        public static Specification<PatientsEntity> hasFamilyName(String familyName) {
            return (root, query, cb) ->
                    familyName == null ? null :
                            cb.like(cb.lower(root.get("familyName")),
                                    "%" + familyName.toLowerCase() + "%");
        }

        public static Specification<PatientsEntity> hasGivenName(String givenName) {
            return (root, query, cb) ->
                    givenName == null ? null :
                            cb.like(cb.lower(root.get("givenName")),
                                    "%" + givenName.toLowerCase() + "%");
        }

        public static Specification<PatientsEntity> hasIdentifier(String identifier) {
            return (root, query, cb) ->
                    identifier == null ? null :
                            cb.equal(root.get("identifier"), identifier);
        }

        public static Specification<PatientsEntity> birthDateExact(LocalDate birthDate) {
            return (root, query, cb) ->
                    birthDate == null ? null :
                            cb.equal(root.get("birthDate"), birthDate);
        }

        public static Specification<PatientsEntity> birthDateBetween(LocalDate from, LocalDate to) {
            return (root, query, cb) -> {
                if (from == null && to == null) return null;
                if (from == null) return cb.lessThanOrEqualTo(root.get("birthDate"), to);
                if (to == null) return cb.greaterThanOrEqualTo(root.get("birthDate"), from);
                return cb.between(root.get("birthDate"), from, to);
            };
        }
}
