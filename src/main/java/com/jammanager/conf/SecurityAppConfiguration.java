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
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	

		
		manager.createUser(User.withUsername("admin").password("password").roles("ADMIN").build());
		manager.createUser(User.withUsername("bad_influence").password("password").roles("USER").build());
		manager.createUser(User.withUsername("satan").password("password").roles("USER").build());
		manager.createUser(User.withUsername("metal4eva").password("password").roles("USER").build());
		manager.createUser(User.withUsername("bestbeat").password("password").roles("USER").build());
		
		return manager;
		
	}
	
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService);
////	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.exceptionHandling().accessDeniedPage("/error/403page")
			.and()
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/about").permitAll()
				.antMatchers("/contact").permitAll()
				.antMatchers("/user/signup").permitAll()
				.antMatchers("/usermanagement/**").hasRole("ADMIN")
				.antMatchers("/jam/**").hasAnyRole("ADMIN", "USER") 
				.antMatchers("/city/**").hasAnyRole("ADMIN", "USER")
				.antMatchers("/comment/**").hasAnyRole("ADMIN", "USER")  
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll();//.and()
//			.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
//				.deleteCookies("JSESSIONID").invalidateHttpSession(true);
	}
	
//	@Autowired
//	UserDetailsService userDetailsService;

//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/jam?useSSL=false");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("coderslab");
//		
//		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
//		jdbcImpl.setDataSource(driverManagerDataSource);
//		jdbcImpl.setUsersByUsernameQuery("select username, password from users where username=?");
//		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT u.username, r.name FROM roles r JOIN users_roles ur ON r.id = ur.role_id JOIN users u ON ur.user_id = u.id WHERE u.name=?;");
//		
//		auth.userDetailsService(jdbcImpl).passwordEncoder(passwordencoder());
//	}
//
//	@Bean(name = "passwordEncoder")
//	public PasswordEncoder passwordencoder() {
//		return new BCryptPasswordEncoder();
//	}
}