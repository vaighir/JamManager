package com.jammanager.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jammanager.entity.City;
import com.jammanager.entity.Jam;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.JamRepository;
import com.jammanager.repository.UserRepository;

@Controller
public class CityController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JamRepository jamRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping(path = "/city")
	public String redirect() {
		
		return "redirect:city/all";
	}
	
	@GetMapping(path = "/city/all")
	public String showAllCities(Model model) {
		Collection<City> cities = cityRepository.findAll();

		model.addAttribute("cities", cities);
		return "city/all";
	}
	
	@GetMapping(path = "/city/{id}/users")
	public String showUsersOfACity(@PathVariable(name = "id", required = true) long id,Model model) {
		City city = cityRepository.findOne(id);
		Collection<User> users = userRepository.findAllByCityId(id);
		
		model.addAttribute("users", users);
		model.addAttribute("city", city);
		return "city/users";
	}
	
	@GetMapping(path = "/city/{id}/jams")
	public String showJamsOfACity(@PathVariable(name = "id", required = true) long id,Model model) {
		City city = cityRepository.findOne(id);
		Collection<Jam> jams = jamRepository.findAllByCityId(id);
		
		model.addAttribute("jams", jams);
		model.addAttribute("city", city);
		return "city/jams";
	}
	
}
