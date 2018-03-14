//package com.jammanager.conf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//
//@Configuration
//public class AuthenticationProviderConfig {
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/jam&SSL=false");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("coderslab");
//		return driverManagerDataSource;
//	}
//
//	@Bean(name = "userDetailsService")
//	public UserDetailsService userDetailsService() {
//		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
//		jdbcImpl.setDataSource(dataSource());
//		jdbcImpl.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
//		jdbcImpl.setAuthoritiesByUsernameQuery(
//				"select b.username, a.role from roles a from users b where b.username=? and a.id=users_roles.role_id join a on users_roles.user_id=b.id");
//		return jdbcImpl;
//	}
//}
