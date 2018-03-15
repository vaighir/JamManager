package com.jammanager.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;
import com.jammanager.entity.Role;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.CommentRepository;
import com.jammanager.repository.JamRepository;
import com.jammanager.service.UserAuthenticationHelper;

@Controller
public class JamController {

	@Autowired
	private JamRepository jamRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private UserAuthenticationHelper uah;

	@GetMapping(path = "/jam/all")
	public String showAllJams(Model model) {
		Collection<Jam> jamsTmp = jamRepository.findAllSortByDate();
		Collection<Jam> jams = new ArrayList<Jam>();
		Date now = new Date();
		for (Jam jam : jamsTmp) {
			Date date = jam.getDate();
			if (date.getTime() > now.getTime()) {
				jams.add(jam);
			}
		}
		
		model.addAttribute("jams", jams);
		return "jam/all";
	}
	
	@GetMapping(path = "/jam/archive")
	public String showPastJams(Model model) {
		Collection<Jam> jamsTmp = jamRepository.findAllSortByDateDesc();
		Collection<Jam> jams = new ArrayList<Jam>();
		Date now = new Date();
		for (Jam jam : jamsTmp) {
			Date date = jam.getDate();
			if (date.getTime() < now.getTime()) {
				jams.add(jam);
			}
		}
		
		model.addAttribute("jams", jams);
		return "jam/all";
	}
	
	
	@PostMapping(path = "/jam/searchByCity")
	public String showFoundCities(@RequestParam(name = "name", required = true) String name, Model model) {
		Collection<Jam> jams = this.jamRepository.findAllByCityName(name);

		model.addAttribute("jams", jams);
		return "jam/all";
	}
	
	@GetMapping(path = "/jam/myjam")
	public String showMyJam(Model model) {
		User user = uah.loadUserFromAuthentication();
		Collection<Jam> jams = jamRepository.findAllByFounder(user);

		model.addAttribute("jams", jams);
		return "jam/all";
	}

	@GetMapping(path = "/jam/add")
	public String showAddJamForm(Model model) {

		Jam jam = new Jam();
		model.addAttribute("jam", jam);

		return "jam/add";
	}

	@PostMapping(path = "/jam/add")
	public String processAddJamForm(@Valid Jam jam, BindingResult bresult) {

		if (bresult.hasErrors()) {
			return "jam/add";
		}

		User user = uah.loadUserFromAuthentication();
		jam.setFounder(user);
		jamRepository.save(jam);

		return "redirect:all";
	}

	@GetMapping(path = "/jam/edit/{id}")
	public String showEditJamForm(@PathVariable(name = "id", required = true) long id, Model model) {

		Jam jam = jamRepository.findOne(id);
		System.out.println(jam);
		model.addAttribute("jam", jam);

		return "jam/edit";
	}

	@PostMapping(path = "/jam/edit")
	public String processEditJamForm(@Valid Jam jam, BindingResult bresult) {

		if (bresult.hasErrors()) {
			return "jam/edit";
		}

		jamRepository.save(jam);

		return "redirect:all";
	}

	@GetMapping(path = "/jam/{id}")
	public String showJam(@PathVariable(name = "id", required = true) long id, Model model) {
		Jam jam = jamRepository.findOne(id);
		Collection<Comment> comments = commentRepository.findAllByJamOrderByDateTime(jam);
		User founder = jam.getFounder();
		Collection<User> participants = jam.getUsers();
		Comment comment = new Comment();
		comment.setJam(jam);

		User user = uah.loadUserFromAuthentication();
		List<User> users = jam.getUsers();

		for (User u : users) {
			if (u.equals(user)) {
				String msg = "hideButton";
				model.addAttribute("msg", msg);
			}
		}

		model.addAttribute("comment", comment);
		model.addAttribute("founder", founder);
		model.addAttribute("participants", participants);
		model.addAttribute("comments", comments);
		model.addAttribute("users", users);
		model.addAttribute("jam", jam);

		return "jam/jam";
	}

	@PostMapping(path = "/jam/join")
	public String joinJam(Jam jam, Model model) {

		User user = uah.loadUserFromAuthentication();
		long jamId = jam.getId();
		
		Jam newJam = jamRepository.getOne(jamId);
		if (user == newJam.getFounder()) {
			String msg = "You cannot join your own jam session";
			model.addAttribute("msg", msg);
			return "error/custom";
		}

		List<User> users = newJam.getUsers();

		if (users != null) {
			

			for (User u : users) {
				if (u.getId() == user.getId()) {
					String msg = "You've already joined this jam";
					model.addAttribute("msg", msg);
					return "error/custom";
				}
			}
		} else {
			users = new ArrayList<User>();
		}
		
		users.add(user);
		newJam.setUsers(users);
		jamRepository.save(newJam);
		return "redirect:../jam/" + newJam.getId();
	}

	@GetMapping(path = "/jam/delete/{id}")
	public String showDeleteConfirmForm(@PathVariable(name = "id", required = true) long id, Model model) {

		Jam jam = jamRepository.findOne(id);
		model.addAttribute("jam", jam);

		User user = uah.loadUserFromAuthentication();
		if (user == jam.getFounder()) {
			return "jam/delete";
		} else {
			List<Role> roles = user.getRoles();
			for (Role r : roles) {
				if (r.getName().equalsIgnoreCase("admin")) {
					return "jam/delete";
				}
			}
			return "error/403page";
		}
	}

	@PostMapping(path = "jam/delete")
	public String deleteJam(@RequestParam(name = "id", required = true) long id) {

		jamRepository.delete(id);
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

	

}
