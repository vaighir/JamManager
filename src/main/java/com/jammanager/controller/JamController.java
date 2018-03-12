package com.jammanager.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;
import com.jammanager.repository.CommentRepository;
import com.jammanager.repository.JamRepository;

@Controller
public class JamController {

	@Autowired
	private JamRepository jamRepository;

	@Autowired
	private CommentRepository commentRepository;

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

		jamRepository.save(jam);

		return "redirect:all";
	}

	@GetMapping(path = "/jam/{id}")
	public String showJam(@PathVariable(name = "id", required = true) long id, Model model) {
		Jam jam = jamRepository.findOne(id);
		Collection<Comment> comments = commentRepository.findAllByJamId(id);

		model.addAttribute("comments", comments);
		model.addAttribute("jam", jam);
		return "jam/jam";
	}

	@PostMapping(path = "/jam/{id}/comment")
	public String commentJam(@Valid Comment comment, @PathVariable(name = "id", required = true) long id, Model model) {
		Jam jam = jamRepository.findOne(id);

		commentRepository.save(comment);

		Collection<Comment> comments = commentRepository.findAllByJamId(id);

		model.addAttribute("comments", comments);
		model.addAttribute("jam", jam);
		return "jam/jam";
	}
	
	@GetMapping(path = "/jam/delete")
	public String showDeleteConfirmForm(@RequestParam(name = "id", required = true) long id, Model model) {
				
		Jam jam = jamRepository.findOne(id);
		
		model.addAttribute("jam", jam);

		return "jam/delete";
	}
	
	@PostMapping(path = "jam/delete")
	public String deleteJam(final @RequestParam(name = "id", required = true) long id) {
		
		jamRepository.delete(id);
		
		return "redirect:all";
	}

}
