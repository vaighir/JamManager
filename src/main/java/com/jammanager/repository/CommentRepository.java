package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jammanager.entity.Comment;
import com.jammanager.entity.Jam;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Collection<Comment> findAllByJam(Jam jam);
	
	@Query("SELECT c FROM Comment c WHERE c.jam = ?1 ORDER BY c.dateTime desc")
	Collection<Comment> findAllByJamOrderByDateTime(Jam jam);
}
