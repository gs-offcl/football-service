package com.football.league.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.football.league.client.FootballRestClient;
import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;
import com.football.league.facade.FootballFacade;

import javax.validation.Valid;

@Slf4j
@RestController
public class FootballController implements IFootball {

	private static Logger logger = LoggerFactory.getLogger(FootballRestClient.class);

	@Autowired
	FootballFacade footballFacade;

	public TeamStandingResponse  getTeamStandings(@Valid TeamStandingRequest teamRequest) throws FootballException {
		logger.debug(" TeamStandingRequest : {}", teamRequest.toString());
		TeamStandingResponse teamResponse = footballFacade.getTeamStandings(teamRequest);
		logger.debug(" TeamStandingResponse : {}", teamResponse.toString());
		return teamResponse;
	}
}
