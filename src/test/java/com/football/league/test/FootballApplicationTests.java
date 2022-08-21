package com.football.league.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.football.league.client.FootballRestClient;
import com.football.league.controller.FootballController;
import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.model.Country;
import com.football.league.model.League;
import com.football.league.model.TeamStanding;
import com.football.league.service.FootballService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class FootballApplicationTests {

	@Test
	void contextLoads() {}

	TeamStandingRequest requestValid = new TeamStandingRequest("England", "Non League Premier", "Aveley");;
	
//	TeamStandingRequest requestInvalidCountry = new TeamStandingRequest("England1", "Non League Premier", "Aveley");
//	TeamStandingRequest requestInvalidLeague = new TeamStandingRequest("England", "Non League Premier1", "Aveley");
//	TeamStandingRequest requestInvalidTeam = new TeamStandingRequest("England", "Non League Premier", "Aveley1");
//	TeamStandingRequest validationFailRequest = new TeamStandingRequest("", "Non League Premier", "Aveley");

	@Autowired
	FootballController footballController;

	@Autowired
	FootballService footballService;

	@Autowired
	FootballRestClient footballRestClient;

	@Value("${football.league.countryId}")
	int countryId;

	@Value("${football.league.leagueId}")
	int leagueId;

	// football rest-client test cases
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

	// football controller test cases
	@Test
	public void testGetTeamsStanding() throws Exception {
		TeamStanding[] teamsStandings = footballRestClient.getTeamStandings(leagueId);
		assertNotNull(teamsStandings);
	}

	@Test
	public void testGetTeamStandings() throws Exception {
		
		TeamStandingResponse response1 = footballController.getTeamStandings(requestValid);
		assertNotNull(response1);
		
		TeamStandingResponse response2 = footballService.getTeamStandings(requestValid);
		assertNotNull(response2);
	}

	/**
	@Test
	public void testGetTeamStandingsInvalidCountry() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidCountry);
		assertNotNull(response);
	}
	
	@Test
	public void testGetTeamStandingsInvalidLeague() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidLeague);
		assertNotNull(response);
	}
	
	@Test
	public void testGetTeamStandingsInvalidTeam() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidTeam);
		assertNotNull(response);
	}

	@Test
	public void testGetTeamStandingsMethodArgumentNotValidException() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidTeam);
		assertNotNull(response);
	}
	**/
}
