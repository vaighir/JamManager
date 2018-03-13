package com.jammanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.jammanager.entity.Instrument;
import com.jammanager.repository.InstrumentRepository;

public class InstrumentConverter implements Converter<String, Instrument>{

	@Autowired
	private InstrumentRepository ir;

	@Override
	public Instrument convert(String source) {
		Long id = Long.parseLong(source);
		Instrument instrument = ir.findOne(id);
		return instrument;
	}
		
}
