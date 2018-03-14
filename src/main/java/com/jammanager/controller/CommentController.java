package com.jammanager.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;
import com.jammanager.entity.User;
import com.jammanager.repository.CommentRepository;
import com.jammanager.service.UserAuthenticationHelper;

@Controller
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserAuthenticationHelper uah;
	
	@PostMapping(path = "/jam/comment")
	public String commentJam(@Valid Comment comment, BindingResult bresult) {
		Date dateTime = new Date();
		User user = uah.loadUserFromAuthentication();
		comment.setUser(user);
		comment.setDateTime(dateTime);

		Jam jam = comment.getJam();
		commentRepository.save(comment);

		return "redirect:../jam/" + jam.getId();
	}
}
