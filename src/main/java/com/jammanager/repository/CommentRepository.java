package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Collection<Comment> findAllByJam(Jam jam); 
}
