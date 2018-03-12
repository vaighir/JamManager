package com.jammanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jammanager.entity.User;
import com.jammanager.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/user/login")
	public String showLoginForm() {
		return "user/login";
	}
	
//	@PostMapping(path = "/user/login")
//	public String processLoginForm() {
//		return "user/success";
//	}
	
	//poprawić, żeby id bylo ukryte
	@GetMapping(path = "/user/edit/")
	public String edit(final @RequestParam(name = "id", required = true) long id, final Model model) {
		
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@PostMapping(path = "/user/edit")
	public String processEdit(final @Valid User user, final BindingResult bresult) {
		if(bresult.hasErrors()) {
			return "user/edit";
		}
		
		userRepository.save(user);
		return "user/success";
	}
	
	@GetMapping(path = "/user/signup")
	public String showSignupForm() {
		return "user/signup";
	}
	
	@PostMapping(path = "/user/signup")
	public String processSignupForm() {
		return "user/success";
	}
	
}
