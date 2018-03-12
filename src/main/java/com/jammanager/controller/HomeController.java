package com.jammanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping(path = "/")
	public String index() {

		return "index/index";
	}
	
	@GetMapping(path = "/error/403page")
	public String page403() {
		return "/error/403page";
	}
	
	@GetMapping(path = "/error/404page")
	public String page404() {
		return "/error/404page";
	}
}
