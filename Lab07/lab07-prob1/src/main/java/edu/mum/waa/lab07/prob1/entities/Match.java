package edu.mum.waa.lab07.prob1.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Match {
	private long matchKey;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date startTime;
	
	private int stadiumKey;
	private Stadium stadium;
	
	private int homeScore;
	private int visitorScore;
	
	private int visitorTeamKey;
	private Team visitorTeam;
	
	private int homeTeamKey;
	private Team homeTeam;
	
	public long getMatchKey() {
		return matchKey;
	}
	public void setMatchKey(long matchKey) {
		this.matchKey = matchKey;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Stadium getStadium() {
		return stadium;
	}
	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getVisitorScore() {
		return visitorScore;
	}
	public void setVisitorScore(int visitorScore) {
		this.visitorScore = visitorScore;
	}
	public Team getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public int getVisitorTeamKey() {
		return visitorTeamKey;
	}
	public void setVisitorTeamKey(int visitorTeamKey) {
		this.visitorTeamKey = visitorTeamKey;
	}
	public int getHomeTeamKey() {
		return homeTeamKey;
	}
	public void setHomeTeamKey(int homeTeamKey) {
		this.homeTeamKey = homeTeamKey;
	}
	public int getStadiumKey() {
		return stadiumKey;
	}
	public void setStadiumKey(int stadiumKey) {
		this.stadiumKey = stadiumKey;
	}
	@Override
	public String toString() {
		return "Match [matchKey=" + matchKey + ", date=" + date + ", startTime=" + startTime + ", stadiumKey="
				+ stadiumKey + ", stadium=" + stadium + ", homeScore=" + homeScore + ", visitorScore=" + visitorScore
				+ ", visitorTeamKey=" + visitorTeamKey + ", homeTeamKey=" + homeTeamKey + "]";
	}
	
}
