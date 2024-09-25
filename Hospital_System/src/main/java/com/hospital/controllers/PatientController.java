package com.hospital.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.models.Doctor;
import com.hospital.models.Patient;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientController {
	    @Autowired
	    private PatientRepository patientRepo;
		@GetMapping("/addPatient")
		public String addPatient() {
			return "/patient/registerpatient";
		}
		
		@PostMapping("/savePatient")
		public String savePatient(Model m,@ModelAttribute Patient patient,@RequestParam String date
				,@RequestParam List<String> medicalHistory) {
			patient.setHistory(patient.getMedicalHistory().toString());
			System.out.println(patient.getMedicalHistory().toString());
			patient.setDOB(Date.valueOf(date));
			patientRepo.save(patient);
			m.addAttribute("success","Patient is registered successfully!");
			return "/patient/registerpatient";
		}
}
