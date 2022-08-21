package com.football.league.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.league.client.FootballRestClient;
import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;
import com.football.league.service.FootballService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class FootballController {

	private static Logger logger = LoggerFactory.getLogger(FootballRestClient.class);

	@Autowired
	FootballService footballService;

	@GetMapping(path = "/teams/standing")
	public TeamStandingResponse  getTeamStandings(@Valid TeamStandingRequest teamRequest) throws FootballException {
		logger.debug(" TeamStandingRequest : {}", teamRequest.toString());
		TeamStandingResponse teamResponse = footballService.getTeamStandings(teamRequest);
		logger.debug(" TeamStandingResponse : {}", teamResponse.toString());
		return teamResponse;
	}
}
