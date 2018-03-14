package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Jam;
import com.jammanager.entity.User;

public interface JamRepository extends JpaRepository<Jam, Long> {

	Collection<Jam> findAllByCityId(long id);

	Collection<Jam> findAllByFounder(User founder);
}
