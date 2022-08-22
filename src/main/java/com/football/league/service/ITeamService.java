package com.football.league.service;

import com.football.league.exception.FootballException;
import com.football.league.model.TeamStanding;

public interface ITeamService {

	public TeamStanding getTeamStandings(int leagueId, String teamName) throws FootballException;
}
