package com.jammanager.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jammanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	Collection<User> findAllByCityId(long id);

	Optional<User> findAllByUsername(String username);

	@Query("select u from User u where u.username like %?1% order by u.username")
	Collection<User> searchByUsername(String name);
	
}
