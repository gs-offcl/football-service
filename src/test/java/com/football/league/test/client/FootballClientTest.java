package com.football.league.test.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.football.league.client.FootballRestClient;
import com.football.league.model.Country;
import com.football.league.model.League;
import com.football.league.model.TeamStanding;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class FootballClientTest {

	@Autowired
	FootballRestClient footballRestClient;

	@Value("${football.league.countryId}")
	int countryId;

	@Value("${football.league.leagueId}")
	int leagueId;

	@Test
	public void testGetCountriesDetails() throws Exception {
		Country[] countries = footballRestClient.getCountries();
		assertNotNull(countries);
	}

	@Test
	public void testGetLeagueDetails() throws Exception {
		League[] leagues = footballRestClient.getLeagues(countryId);
		assertNotNull(leagues);
	}

	@Test
	public void testGetTeamsStanding() throws Exception {
		TeamStanding[] teamsStandings = footballRestClient.getTeamStandings(leagueId);
		assertNotNull(teamsStandings);
	}

}
