package com.jammanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jammanager.entity.User;
import com.jammanager.repository.UserRepository;

public class UserAuthenticationHelper {
	
	@Autowired
	private UserRepository ur;
	
	public User loadUserFromAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			User user = ur.findByUsername(currentUserName);
			return user;
		} else {
			return null;
		}

	}
}
