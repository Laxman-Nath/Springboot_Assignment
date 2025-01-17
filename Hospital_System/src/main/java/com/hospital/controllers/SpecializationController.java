package com.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.models.Specialization;
import com.hospital.repository.SpecializationRepository;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {
	@Autowired
	private SpecializationRepository specializationRepository;
	
	@GetMapping("/addSpecialization")
	public String addSpecialization() {
		return "specialization/registerspecialization";
	}
	
	@PostMapping("/saveSpecialization")
	public String saveSpecialization(@ModelAttribute Specialization specialization,Model m) {
		m.addAttribute("success","Specialization is registered successfully!");
		this.specializationRepository.save(specialization);
		
		return "specialization/registerspecialization";
	}
}
