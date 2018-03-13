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
import org.springframework.web.bind.annotation.RequestParam;

import com.jammanager.entity.City;
import com.jammanager.entity.Instrument;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.InstrumentRepository;
import com.jammanager.repository.UserRepository;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@GetMapping(path = "/usermanagement")
	public String showLoginForm(Model model) {
		Collection<User> users = userRepository.findAll();
		
		model.addAttribute("users", users);
		return "usermanagement/all";
	}
	
	@GetMapping(path = "/usermanagement/delete")
	public String showDeleteConfirmForm(@RequestParam(name = "id", required = true) long id, Model model) {
				
		User user = userRepository.findOne(id);
		
		model.addAttribute("user", user);

		return "usermanagement/delete";
	}
	
	@PostMapping(path = "/usermanagement/delete")
	public String deleteUser(final @RequestParam(name = "id", required = true) long id) {
		
		userRepository.delete(id);
		
		return "redirect:all";
	}
	
	@GetMapping(path = "/usermanagement/add")
	public String showAddUserForm(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "usermanagement/add";
	}

	@PostMapping(path = "/usermanagement/add")
	public String processAddUserForm(@Valid User user, BindingResult bresult) {

		if(bresult.hasErrors()) {
			return "usermanagement/add";
		}
				
		userRepository.save(user);

		return "redirect:all";
	}
	
	@GetMapping(path = "/usermanagement/edit/{id}")
	public String showEditForm(@PathVariable(name = "id", required = true) long id, Model model) {

		User user = userRepository.findOne(id);
		user.getCity().getJams();		
		
		model.addAttribute("user", user);
		return "usermanagement/edit";
	}

	@PostMapping(path = "/usermanagement/edit")
	public String editUser(@Valid User user, final BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return "usermanagement/edit";
		}
				
		userRepository.save(user);
		
		return "redirect:all";
	}
	
	
	@ModelAttribute("cities")
	public Collection<City> cities() {
		Collection<City> cities = cityRepository.findAll();
		
		for (City c : cities) {
	        c.getJams();
		}
		
		return cities;
	}
	
	@ModelAttribute("instruments")
	public Collection<Instrument> instruments() {
		Collection<Instrument> instruments = instrumentRepository.findAll();
		return instruments;
	}
}
