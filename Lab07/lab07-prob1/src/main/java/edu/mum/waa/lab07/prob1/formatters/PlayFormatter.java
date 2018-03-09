package edu.mum.waa.lab07.prob1.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import edu.mum.waa.lab07.prob1.entities.Player;

public class PlayFormatter implements Formatter<Player>{

	@Override
	public String print(Player player, Locale locale) {
		return player.getNum() + " - " + player.getName();
	}

	@Override
	public Player parse(String playerStr, Locale locale) throws ParseException {
		String[] split = playerStr.split("-");
		Player player = new Player();
		player.setName(split[1]);
		player.setNum(Integer.parseInt(split[0]));
		return player;
	}

}
