package com.football.league.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.league.client.FootballRestClient;
import com.football.league.exception.FootballException;
import com.football.league.model.TeamStanding;

@Service
public class TeamServiceImpl implements ITeamService {

	private static Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);
	
	@Autowired
	FootballRestClient footballRestClient;

	public TeamStanding getTeamStandings(int leagueId, String teamName) throws FootballException {
		
		TeamStanding[] teams = footballRestClient.getTeamStandings(leagueId);
		TeamStanding teamStanding = findTeamStandingByTeamName(teams, teamName);
		logger.debug(" TeamStanding - " + teamStanding);
		
		return teamStanding;
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
