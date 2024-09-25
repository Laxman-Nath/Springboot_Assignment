package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.models.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
