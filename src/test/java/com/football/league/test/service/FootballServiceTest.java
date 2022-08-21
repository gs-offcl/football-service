package com.football.league.test.service;

import org.junit.Test;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.service.FootballService;

import static org.junit.Assert.*;

public class FootballServiceTest {

	TeamStandingRequest request;

	@Autowired
	FootballService footballService;

	@Before
	public void before() throws Exception {
		request = new TeamStandingRequest("England", "Non League Premier", "Aveley");
	}

	@Test
	public void testGetTeamStandings() throws Exception {
		TeamStandingResponse response = footballService.getTeamStandings(request);
		assertNotNull(response);
	}
}
