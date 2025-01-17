package com.hospital.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.models.Appointment;
import com.hospital.models.Doctor;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentRepository AppointmentRepo;

	@GetMapping("/addAppointment")
	public String addDoctor() {
		return "/appointment/registerappointment";
	}

	@PostMapping("/saveAppointment")
	public String saveDoctor(Model m, @ModelAttribute Appointment appointment,
			@RequestParam String formDate) {
		appointment.setDate(Date.valueOf(formDate));
         this.AppointmentRepo.save(appointment);
		m.addAttribute("success", "Appointment is registered successfully!");
		return "/appointment/registerappointment";
	}
}
