package com.football.league.service;

import com.football.league.exception.FootballException;

public interface ILeagueService {

	public int getLeagues(int countryId, String leagueName) throws FootballException;
}
