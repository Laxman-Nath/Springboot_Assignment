package com.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.models.Doctor;
import com.hospital.repository.DoctorRepository;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepo;
	@GetMapping("/addDoctor")
	public String addDoctor() {
		return "/doctor/registerdoctor";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(Model m,@ModelAttribute Doctor doctor) {
		doctorRepo.save(doctor);
		m.addAttribute("success","Doctor is registered successfully!");
		return "/doctor/registerdoctor";
	}
}
