package com.jammanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserManagementController {
	
	@GetMapping(path = "/usermanagement")
	public String showLoginForm() {
		return "usermanagement/index";
	}
	
}
