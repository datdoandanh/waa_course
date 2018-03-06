package edu.mum.waa.lab07.prob1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.mum.waa.lab07.prob1.entities.Stadium;

@Service
public class StadiumService {
	private static int idCount = 1;
	
	private Map<Integer, Stadium> stadiums = new HashMap<>();
	
	public StadiumService() {
		add(new Stadium("Santiago Bernabeu", "Real Madrid", "Marid"));
		add(new Stadium("Camp Nou", "Barcelona", "Barcelona"));
	}
	public void add(Stadium stadium) {
		stadium.setStadiumKey(idCount);
		stadiums.put(idCount, stadium);
		idCount++;
	}
	
	public Stadium get(int stadiumKey) {
		Stadium result = stadiums.get(stadiumKey);
		if (result == null) {
			throw new NoSuchResourceException("Stadium", stadiumKey);
		}
		return result;
	}
	
	public void update(int stadiumKey, Stadium stadium) {
		stadiums.put(stadiumKey, stadium);
	}
	
	public void delete(int stadiumKey) {
		Stadium stadium = stadiums.remove(stadiumKey);
		if (stadium == null) {
			throw new NoSuchResourceException("Stadium", stadiumKey);
		}
	}
	
	public List<Stadium> getAll() {
		return new ArrayList<>(stadiums.values());
	}
}
