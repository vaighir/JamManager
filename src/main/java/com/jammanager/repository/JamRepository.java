package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jammanager.entity.Jam;
import com.jammanager.entity.User;

public interface JamRepository extends JpaRepository<Jam, Long> {

	@Query("SELECT j FROM Jam j ORDER BY j.date desc")
	Collection<Jam> findAllSortByDate();
	
	Collection<Jam> findAllByCityId(long id);

	Collection<Jam> findAllByFounder(User founder);
}
