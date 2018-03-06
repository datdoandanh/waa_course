package edu.mum.waa.lab07.prob1.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.mum.waa.lab07.prob1.entities.Team;
import edu.mum.waa.lab07.prob1.services.TeamService;

@Component
public class TeamConverter implements Converter<Integer, Team>{

	@Autowired
	private TeamService teamService;
	
	@Override
	public Team convert(Integer teamKey) {
		return teamService.get(teamKey);
	}

}
