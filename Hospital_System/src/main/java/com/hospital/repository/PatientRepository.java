package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
