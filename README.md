# OHS Backend API – Patient & Encounter Management

A **Spring Boot 3** REST API for managing **Patients** and **Encounters**, with **search**, **validation**, **testing**, and **Docker** support. Ready for **Observations** in the future.

---

## Features

- **CRUD** for `Patient` and `Encounter`
- **Search patients** by:
  - `family`, `given` (partial, case-insensitive)
  - `identifier` (exact)
  - `birthDate` (exact or range: `birthDateFrom`, `birthDateTo`)
- **JPA + H2** (PostgreSQL-ready)
- **Bean Validation** + **RFC 7807 Problem Details**
- **OpenAPI/Swagger UI** at `/swagger-ui.html`
- **Dockerized** with healthcheck
- **2+ Integration tests** using `TestRestTemplate`

---

## Quick Start
# Run locally 
mvn spring-boot:run

#Run with docker
docker build -t ohs-api
docker run -p 8080:8080 ohs-api

## Endpoints
POST /api/patients - add new patient
GET /api/patients/{id} - gets patients information by id
PUT /api/patients/{id} - edits patients details
DELETE /api/patients/{id} - delete patients details
GET /api/patients?family=&given=&identifier=&birthDate= • As capacity allows, they’d
love to list a Patient’s Encounters and Observations:
GET /api/patients/{id}/encounters
GET /api/patients/{id}/observations 

