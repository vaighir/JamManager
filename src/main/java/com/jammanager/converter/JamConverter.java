package com.jammanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.jammanager.entity.Jam;
import com.jammanager.repository.JamRepository;

public class JamConverter implements Converter<String, Jam>{

	@Autowired
	private JamRepository jr;

	@Override
	public Jam convert(String source) {
		Long id = Long.parseLong(source);
		Jam jam = jr.findOne(id);
		return jam;
	}
		
}
