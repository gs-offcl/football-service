package com.football.league.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//@Data
public class TeamStanding {

	@JsonProperty("country_id")
	private int countryId;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("league_name")
	private String leagueName;

	@JsonProperty("league_id")
	private int leagueId;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("team_id")
	private int teamId;

	@JsonProperty("overall_league_position")
	private int overallPosition;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getOverallPosition() {
		return overallPosition;
	}

	public void setOverallPosition(int overallPosition) {
		this.overallPosition = overallPosition;
	}

	@Override
	public String toString() {
		return "TeamStanding [countryId=" + countryId + ", countryName=" + countryName + ", leagueName=" + leagueName
				+ ", leagueId=" + leagueId + ", teamName=" + teamName + ", teamId=" + teamId + ", overallPosition="
				+ overallPosition + "]";
	}
}
