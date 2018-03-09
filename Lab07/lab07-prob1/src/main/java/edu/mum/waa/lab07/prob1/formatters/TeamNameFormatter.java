package edu.mum.waa.lab07.prob1.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TeamNameFormatter implements Formatter<String>{

	@Override
	public String print(String text, Locale locale) {
		return "Welcome, " + text;
	}

	@Override
	public String parse(String text, Locale locale) throws ParseException {
		return text.replaceAll("Welcome, ", "");
	}

}
