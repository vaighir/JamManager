package com.jammanager.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	Collection<User> findAllByCityId(long id);

	Optional<User> findAllByUsername(String username);
	
}
