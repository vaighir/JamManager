package com.jammanager.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityAppConfiguration extends WebSecurityConfigurerAdapter  {

//	@Autowired
//	private UserRepository userRepository;
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	
//		Collection<com.jammanager.entity.User> users = userRepository.findAll();
//		for (com.jammanager.entity.User u : users) {
//			manager.createUser(User.withUsername(u.getUsername()).roles(u.getRolesAsArray()).build());
//		}
		
		manager.createUser(User.withUsername("admin").password("password").roles("ADMIN").build());

		
		return manager;
		
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.exceptionHandling().accessDeniedPage("/error/403page")
			.and()
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/usermanagement/**").hasRole("ADMIN")
//				.antMatchers("/jams/**").hasAnyRole("ADMIN", "USER")  
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll();
	}
}