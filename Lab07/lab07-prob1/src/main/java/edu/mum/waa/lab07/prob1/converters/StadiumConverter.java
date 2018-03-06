package edu.mum.waa.lab07.prob1.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.mum.waa.lab07.prob1.entities.Stadium;
import edu.mum.waa.lab07.prob1.services.StadiumService;

@Component
public class StadiumConverter implements Converter<Integer, Stadium>{

	@Autowired
	private StadiumService stadiumService;
	
	@Override
	public Stadium convert(Integer stadiumKey) {
		return stadiumService.get(stadiumKey);
	}

}
