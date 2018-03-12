package com.jammanager.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jammanager.entity.User;
import com.jammanager.repository.UserRepository;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/usermanagement")
	public String showLoginForm(Model model) {
		Collection<User> users = userRepository.findAll();
		
		model.addAttribute("users", users);
		return "usermanagement/all";
	}
	
	@GetMapping(path = "/user/delete")
	public String showDeleteConfirmForm(@RequestParam(name = "id", required = true) long id, Model model) {
				
		User user = userRepository.findOne(id);
		
		model.addAttribute("user", user);

		return "usermanagement/delete";
	}
	
	@PostMapping(path = "jam/delete")
	public String deleteUser(final @RequestParam(name = "id", required = true) long id) {
		
		userRepository.delete(id);
		
		return "redirect:all";
	}
}
