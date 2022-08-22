package com.football.league.facade;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;
import com.football.league.model.TeamStanding;
import com.football.league.service.ICountryService;
import com.football.league.service.ILeagueService;
import com.football.league.service.ITeamService;

@Component
@Slf4j
public class FootballFacade {

	private static Logger logger = LoggerFactory.getLogger(FootballFacade.class);
	
	@Autowired
	ICountryService countryService;
	
	@Autowired
	ILeagueService leagueService;
	
	@Autowired
	ITeamService teamService;
	
	public TeamStandingResponse getTeamStandings(TeamStandingRequest request) throws FootballException{

		logger.debug(" Start - Inside getTeamStandings");
		
		int countryId = countryService.getCountries(request.getCountryName());
		int leagueId = leagueService.getLeagues(countryId, request.getLeagueName());
		TeamStanding teamsStanding = teamService.getTeamStandings(leagueId, request.getTeamName());
		teamsStanding.setCountryId(countryId);

		logger.debug(" End - Inside getTeamStandings");
		
		return TeamStandingResponse.objectMapper(teamsStanding);
	}
}
