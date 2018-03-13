package com.jammanager.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jammanager.entity.City;
import com.jammanager.entity.Instrument;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.InstrumentRepository;
import com.jammanager.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@GetMapping(path = "/user/login")
	public String showLoginForm() {
		return "user/login";
	}
	
//	@PostMapping(path = "/user/login")
//	public String processLoginForm() {
//		return "user/success";
//	}
	
	@GetMapping(path = "/user/edit")
	public String edit(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
			User user = userRepository.findByUsername(currentUserName);
			model.addAttribute("user", user);
			return "user/edit";
		}
		
		return "user/login";
	}
	
	@PostMapping(path = "/user/edit")
	public String processEdit(@Valid User user, BindingResult bresult) {
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
	
	@GetMapping(path = "/user/logout")
	public String logout() {
		// TODO add logout functionality
		
		
		
		return "index/index";
	}
	
	@ModelAttribute("cities")
	public Collection<City> cities() {
		Collection<City> cities = cityRepository.findAll();
		return cities;
	}
	
	@ModelAttribute("instruments")
	public Collection<Instrument> instruments() {
		Collection<Instrument> instruments = instrumentRepository.findAll();
		return instruments;
	}
}
