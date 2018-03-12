package com.jammanager.webapp;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.jammanager.conf.SecurityAppConfiguration;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(SecurityAppConfiguration.class);
	}
	
}