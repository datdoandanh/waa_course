package edu.mum.waa.lab07.prob1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.mum.waa.lab07.prob1.entities.Team;

@Service
public class TeamService {
	private static int idCount = 1;
	
	private Map<Integer, Team> teams = new HashMap<>();
	
	public TeamService() {
		add(new Team("Real Madrid FC", "Real Madrid", "1", "White", "Black"));
		add(new Team("Barcelona FC", "Barcelona", "1", "White", "Black"));
	}
	public void add(Team team) {
		team.setTeamKey(idCount);
		teams.put(idCount, team);
		idCount++;
	}
	
	public Team get(int teamKey) {
		Team result = teams.get(teamKey);
		if (result == null) {
			throw new NoSuchResourceException("Team", teamKey);
		}
		return result;
	}
	
	public void update(int teamKey, Team team) {
		teams.put(teamKey, team);
	}
	
	public void delete(int teamKey) {
		Team team = teams.remove(teamKey);
		if (team == null) {
			throw new NoSuchResourceException("Team", teamKey);
		}
	}
	
	public List<Team> getAll() {
		return new ArrayList<>(teams.values());
	}
}
