package com.football.league.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//@Data
public class League {

	@JsonProperty("country_id")
	private int countryId;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("league_id")
	private int leagueId;

	@JsonProperty("league_name")
	private String leagueName;

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

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	@Override
	public String toString() {
		return "League [countryId=" + countryId + ", countryName=" + countryName + ", leagueId=" + leagueId
				+ ", leagueName=" + leagueName + "]";
	}
}
