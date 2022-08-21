package com.football.league.test.controller;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.football.league.controller.FootballController;
import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class FootballControllerTest {

	TeamStandingRequest requestValid;
	TeamStandingRequest requestInvalidCountry;
	TeamStandingRequest requestInvalidLeague;
	TeamStandingRequest requestInvalidTeam;
	TeamStandingRequest validationFailRequest;

	@Autowired
	FootballController footballController;

	@Before
	public void before() throws Exception {
		requestValid = new TeamStandingRequest("England", "Non League Premier", "Aveley");
		requestInvalidCountry = new TeamStandingRequest("England1", "Non League Premier", "Aveley");
		requestInvalidLeague = new TeamStandingRequest("England", "Non League Premier1", "Aveley");
		requestInvalidTeam = new TeamStandingRequest("England", "Non League Premier", "Aveley1");
		validationFailRequest = new TeamStandingRequest("", "Non League Premier", "Aveley");
	}

	@Test
	public void testGetTeamStandings() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestValid);
		assertNotNull(response);
	}

	@Test(expected = FootballException.class)
	public void testGetTeamStandingsInvalidCountry() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidCountry);
		assertNotNull(response);
	}

	@Test(expected = FootballException.class)
	public void testGetTeamStandingsInvalidLeague() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidLeague);
		assertNotNull(response);
	}

	@Test(expected = FootballException.class)
	public void testGetTeamStandingsInvalidTeam() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidTeam);
		assertNotNull(response);
	}

	@Test(expected = FootballException.class)
	public void testGetTeamStandingsMethodArgumentNotValidException() throws Exception {
		TeamStandingResponse response = footballController.getTeamStandings(requestInvalidTeam);
		assertNotNull(response);
	}
}
