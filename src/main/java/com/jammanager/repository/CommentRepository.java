package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Collection<Comment> findAllByJamId(long id); 
}
