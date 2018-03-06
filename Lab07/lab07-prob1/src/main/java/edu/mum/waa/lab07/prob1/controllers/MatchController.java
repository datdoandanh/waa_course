package edu.mum.waa.lab07.prob1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.waa.lab07.prob1.entities.Match;
import edu.mum.waa.lab07.prob1.entities.Stadium;
import edu.mum.waa.lab07.prob1.entities.Team;
import edu.mum.waa.lab07.prob1.services.StadiumService;
import edu.mum.waa.lab07.prob1.services.TeamService;

@Controller
@RequestMapping("/match")
public class MatchController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private StadiumService stadiumService;
	
	@RequestMapping(value = { "/", "/create" }, method = RequestMethod.GET)
	public String get(@ModelAttribute("match") Match match) {
		return "match/add";
	}
	
	@RequestMapping(value = { "/", "/create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("match") Match match) {
		System.out.println(match.toString());
		return "match/add";
	}
	
	@ModelAttribute("teams")
	public List<Team> teams() {
		return teamService.getAll();
	}
	
	@ModelAttribute("stadiums")
	public List<Stadium> stadiums() {
		return stadiumService.getAll();
	}
}
