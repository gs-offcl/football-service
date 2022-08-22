package com.football.league.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.league.client.FootballRestClient;
import com.football.league.exception.FootballException;
import com.football.league.model.League;

@Service
public class LeagueServiceImpl implements ILeagueService {

	private static Logger logger = LoggerFactory.getLogger(LeagueServiceImpl.class);
	
	@Autowired
	FootballRestClient footballRestClient;

	public int getLeagues(int countryId, String leagueName) throws FootballException {
		int leagueId = 0;
		League[] leagues = footballRestClient.getLeagues(countryId);
		if(leagues != null) {
			logger.debug("Countries: " + Arrays.toString(leagues));
			leagueId = findLeagueIdByLeagueName(leagues, leagueName);
			logger.debug(" LeagueId - " + leagueId);
		}
		return leagueId;
	}
	private int findLeagueIdByLeagueName(League[] leagues, String leagueName) {
		Optional<League> optional = Stream.of(leagues)
				.filter(league -> leagueName.equals(league.getLeagueName())).findFirst();
		if (optional.isPresent()) {
			return optional.get().getLeagueId();
		}
		throw new FootballException("Invalid League Name");
	}
}
