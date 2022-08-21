package com.football.league.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import lombok.Data;

//@Data
public class TeamStandingRequest {
	
	public TeamStandingRequest(@NotNull @NotBlank String countryName, @NotNull @NotBlank String leagueName,
			@NotNull @NotBlank String teamName) {
		super();
		this.countryName = countryName;
		this.leagueName = leagueName;
		this.teamName = teamName;
	}

	@NotNull
	@NotBlank
	private String countryName;
	
	@NotNull
	@NotBlank
	private String leagueName;
	
	@NotNull
	@NotBlank
	private String teamName;
	
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "TeamStandingRequest [countryName=" + countryName + ", leagueName=" + leagueName + ", teamName="
				+ teamName + "]";
	}

}
