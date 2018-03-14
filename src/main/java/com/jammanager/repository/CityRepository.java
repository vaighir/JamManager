package com.jammanager.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jammanager.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	
	
	@Query("select c from City c where c.name like %?1%")
	Collection<City> searchByName(String name);
	
}
