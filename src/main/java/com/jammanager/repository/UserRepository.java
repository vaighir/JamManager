package com.jammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
