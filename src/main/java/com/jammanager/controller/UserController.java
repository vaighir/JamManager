package com.jammanager.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jammanager.entity.City;
import com.jammanager.entity.Instrument;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.InstrumentRepository;
import com.jammanager.repository.UserRepository;
import com.jammanager.service.UserAuthenticationHelper;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private UserAuthenticationHelper uah;
	
	@GetMapping(path = "/user/login")
	public ModelAndView showLoginForm() {
		ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
	}
	
	@GetMapping(path = "/user/edit")
	public String edit(Model model) {

		User user = uah.loadUserFromAuthentication();
			
		if (user != null) {
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
	
	@GetMapping(path = "/user/details/{id}")
	public String showJam(@PathVariable(name = "id", required = true) long id, Model model) {
		User user = userRepository.findOne(id);

		model.addAttribute("user", user);

		return "user/details";
	}
	
	@GetMapping(path = "/user/signup")
	public String showSignupForm(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "user/signup";
	}
	
	@PostMapping(path = "/user/signup")
	public String processSignupForm(@Valid User user, BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return "user/signup";
		}
				
		userRepository.save(user);
		
		return "user/success";
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
