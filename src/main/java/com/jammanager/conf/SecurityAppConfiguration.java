package com.jammanager.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityAppConfiguration extends WebSecurityConfigurerAdapter  {

//@Autowired
//private UserDetailsService userDetailsService;

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
		manager.createUser(User.withUsername("user1").password("password").roles("USER").build());
		manager.createUser(User.withUsername("user2").password("password").roles("USER").build());
		manager.createUser(User.withUsername("user3").password("password").roles("USER").build());

		
		return manager;
		
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.exceptionHandling().accessDeniedPage("/error/403page")
			.and()
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/user/signup").permitAll()
				.antMatchers("/usermanagement/**").hasRole("ADMIN")
				.antMatchers("/jam/**").hasAnyRole("ADMIN", "USER") 
				.antMatchers("/city/**").hasAnyRole("ADMIN", "USER")
				.antMatchers("/comment/**").hasAnyRole("ADMIN", "USER")  
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll().and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID").invalidateHttpSession(true);
	}
}