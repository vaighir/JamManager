package com.jammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {


}
