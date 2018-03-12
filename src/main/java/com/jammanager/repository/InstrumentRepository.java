package com.jammanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Intrument;

public interface InstrumentRepository extends JpaRepository<Intrument, Long> {


}
