package com.jammanager.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProviderConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/jam&useSSL=false");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("coderslab");
		return driverManagerDataSource;
	}

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("select username, password from users where username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT u.username, r.name FROM roles r JOIN users_roles ur ON r.id = ur.role_id JOIN users u ON ur.user_id = u.id WHERE u.name=?;");
		return jdbcImpl;
	}
}
