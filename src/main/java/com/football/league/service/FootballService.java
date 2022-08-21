package com.football.league.service;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.league.client.FootballRestClient;
import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;
import com.football.league.model.Country;
import com.football.league.model.League;
import com.football.league.model.TeamStanding;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class FootballService {

	private static Logger logger = LoggerFactory.getLogger(FootballService.class);
	
	@Autowired
	FootballRestClient footballRestClient;

	public TeamStandingResponse getTeamStandings(TeamStandingRequest request) throws FootballException{

		logger.debug(" Start - Inside getTeamStandings");
		
		Country[] countries = footballRestClient.getCountries();
		int countryId = findCountryIdByName(countries, request.getCountryName());
		logger.debug(" CountryId - "+countryId);

		League[] leagues = footballRestClient.getLeagues(countryId);
		int leagueId = findLeagueIdByLeagueName(leagues, request.getLeagueName());
		logger.debug(" LeageId - "+leagueId);
		
		TeamStanding[] teamsStandings = footballRestClient.getTeamStandings(leagueId);
		TeamStanding teamsStanding = findTeamStandingByTeamName(teamsStandings, request.getTeamName());
		teamsStanding.setCountryId(countryId);

		logger.debug(" End - Inside getTeamStandings");
		
		return TeamStandingResponse.objectMapper(teamsStanding);
	}

	private int findCountryIdByName(Country[] countries, String countryName) {
		
		logger.debug("countries-" + Arrays.toString(countries));
		logger.debug("countryName-" + countryName);
		
		Optional<Country> optional = Stream.of(countries)
				.filter(c -> countryName.equals(c.getCountryName())).findFirst();
		logger.debug("optional.isPresent()-" + optional.isPresent());
		if (optional.isPresent()) {
			return optional.get().getCountryId();
		}
		throw new FootballException("Invalid Country Name");
	}

	private int findLeagueIdByLeagueName(League[] leagues, String leagueName) {
		Optional<League> optional = Stream.of(leagues)
				.filter(league -> leagueName.equals(league.getLeagueName())).findFirst();
		if (optional.isPresent()) {
			return optional.get().getLeagueId();
		}
		throw new FootballException("Invalid League Name");
	}

	private TeamStanding findTeamStandingByTeamName(TeamStanding[] teams, String teamName) {
		Optional<TeamStanding> optional = Stream.of(teams)
				.filter(teamsStanding -> teamName.equals(teamsStanding.getTeamName())).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new FootballException("Invalid Team Name");
	}
}
