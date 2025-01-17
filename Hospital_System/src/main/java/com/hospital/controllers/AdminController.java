package com.hospital.controllers;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.models.Admin;
import com.hospital.repository.AdminRepository;

import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;

@Controller
//@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/")
	public String login() {
		return "admin/login";
	}

	@GetMapping("/register")
	public String getRegister() {
		return "admin/register";
	}

	@PostMapping("/saveAdmin")
	public String registerAdmin(Model m, @ModelAttribute Admin admin) {
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		if (this.adminRepo.existsByName(admin.getName())) {
			m.addAttribute("error", "Admin with similar name already exists!");
			
		}
		this.adminRepo.save(admin);

		m.addAttribute("success", "Admin is successfully registered!");
		return "admin/register";

	}

	@PostMapping("/verifyAdmin")
	public String verify(@ModelAttribute Admin admin,Model m) {
		admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
		if(this.adminRepo.existsByNameAndPassword(admin.getName(), admin.getPassword())){
			return "admin/adminpanel";
		}
		m.addAttribute("error","Error logging in!");
		return "admin/login";
	}

}