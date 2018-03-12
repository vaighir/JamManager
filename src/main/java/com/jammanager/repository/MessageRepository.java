package com.jammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {


}
