package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Jam;

public interface JamRepository extends JpaRepository<Jam, Long> {

	Collection<Jam> findAllByCityId(long id);


}
