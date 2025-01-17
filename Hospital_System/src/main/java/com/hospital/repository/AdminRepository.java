package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	boolean existsByName(String name);

	boolean existsByNameAndPassword(String name, String password);
}
