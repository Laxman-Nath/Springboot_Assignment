package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
