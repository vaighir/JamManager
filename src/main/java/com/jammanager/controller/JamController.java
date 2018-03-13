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
import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;
import com.jammanager.entity.User;
import com.jammanager.repository.CityRepository;
import com.jammanager.repository.CommentRepository;
import com.jammanager.repository.JamRepository;

@Controller
public class JamController {

	@Autowired
	private JamRepository jamRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CityRepository cityRepository;

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

		//TODO read user from session
		//add user as founder
		
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
		
		//TODO
		//load user from session
		//if user is already a participant, add "hide join button"
		
		model.addAttribute("comment", comment);
		model.addAttribute("founder", founder);
		model.addAttribute("participants", participants);
		model.addAttribute("comments", comments);
		model.addAttribute("jam", jam);
		return "jam/jam";
	}
	
	@PostMapping(path = "/jam/{id}/join")
	public String joinJam(@PathVariable(name = "id", required = true) long id, Model model) {
		//TODO
		//read user from session
		//if user == founder
		//return "can't join your own jam session"
		//if user is already a participant
		//return "you've already joined this jam"
		//else add user to participants
		return "jam/jam";
	}

	@PostMapping(path = "/jam/comment")
	public String commentJam(@Valid Comment comment, @RequestParam(name = "jam", required = true) Jam jam, Model model) {
//		Jam jam = jamRepository.findOne(id);
//		comment.setJam(jam);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		comment.setDate(sqlDate);
		
		commentRepository.save(comment);

		Collection<Comment> comments = commentRepository.findAllByJam(jam);

		model.addAttribute("comments", comments);
		model.addAttribute("jam", jam);
		return "redirect:jam";
	}
	
	@GetMapping(path = "/jam/delete/{id}")
	public String showDeleteConfirmForm(@PathVariable(name = "id", required = true) long id, Model model) {
				
		Jam jam = jamRepository.findOne(id);
		
		model.addAttribute("jam", jam);
		
		//TODO read user from session
		//if user == founder
		return "jam/delete";
		//if user != founder; redirect403
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

}
