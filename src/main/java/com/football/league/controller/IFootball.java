package com.football.league.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.football.league.dto.TeamStandingRequest;
import com.football.league.dto.TeamStandingResponse;
import com.football.league.exception.FootballException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "football", description = "The Football League API")
@RequestMapping("/api/v1")
public interface IFootball {

	@Operation(summary = "Get football standings", description = "Returns football standings", tags = { "football" })  
	@GetMapping(path = "/teams/standing")
	public TeamStandingResponse getTeamStandings(@Valid TeamStandingRequest teamRequest) throws FootballException;
}
