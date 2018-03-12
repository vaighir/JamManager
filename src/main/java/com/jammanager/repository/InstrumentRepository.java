package com.jammanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jammanager.entity.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {


}
