package com.jammanager.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jammanager.entity.City;
import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.CommentRepository;
import com.jammanager.repository.JamRepository;
import com.jammanager.repository.UserRepository;

@Controller
public class JamController {

	@Autowired
	private JamRepository jamRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/jam/all")
	public String showAllJams(Model model) {
		Collection<Jam> jams = jamRepository.findAll();

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

		User user = loadUserFromAuthentication();
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
		Collection<Comment> comments = commentRepository.findAllByJam(jam);
		User founder = jam.getFounder();
		Collection<User> participants = jam.getUsers();
		Comment comment = new Comment();
		comment.setJam(jam);

		User user = loadUserFromAuthentication();
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
		model.addAttribute("jam", jam);
		
		return "jam/jam";
	}

	@PostMapping(path = "/jam/{id}/join")
	public String joinJam(@PathVariable(name = "id", required = true) long id, Model model) {

		Jam jam = jamRepository.findOne(id);
		User user = loadUserFromAuthentication();

		if (user == jam.getFounder()) {
			String msg = "You cannot join your own jam session";
			model.addAttribute("msg", msg);
			return "error/custom";
		}

		List<User> users = jam.getUsers();

		for (User u : users) {
			if (u.equals(user)) {
				String msg = "You've already joined this jam";
				model.addAttribute("msg", msg);
				return "error/custom";
			}
		}

		users.add(user);
		jam.setUsers(users);
		return "redirect:../jam/" + id;
	}

	@PostMapping(path = "/jam/comment")
	public String commentJam(@Valid Comment comment, BindingResult bresult) {
		Date dateTime = new Date();
		User user = loadUserFromAuthentication();
		comment.setUser(user);
		comment.setDateTime(dateTime);

		Jam jam = comment.getJam();
		commentRepository.save(comment);

		return "redirect:../jam/" + jam.getId();
	}

	@GetMapping(path = "/jam/delete/{id}")
	public String showDeleteConfirmForm(@PathVariable(name = "id", required = true) long id, Model model) {

		Jam jam = jamRepository.findOne(id);
		model.addAttribute("jam", jam);

		User user = loadUserFromAuthentication();
		if (user == jam.getFounder()) {
			return "jam/delete";
		} else {
			return "error/403";
		}
	}

	@PostMapping(path = "jam/delete")
	public String deleteJam(final @RequestParam(name = "id", required = true) long id) {

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

	private User loadUserFromAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			User user = userRepository.findByUsername(currentUserName);
			return user;
		} else {
			return null;
		}

	}

}
