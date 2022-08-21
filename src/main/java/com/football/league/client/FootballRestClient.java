package com.football.league.client;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.football.league.exception.FootballException;
import com.football.league.model.Country;
import com.football.league.model.League;
import com.football.league.model.TeamStanding;

import io.github.resilience4j.retry.annotation.Retry;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class FootballRestClient {

	private static Logger logger = LoggerFactory.getLogger(FootballRestClient.class);

	private static final String APIKEY = "APIkey";
	private static final String ACTION = "action";
	private static final String COUNTRY_ID = "country_id";
	private static final String LEAGUE_ID = "league_id";

	@Value("${football.api.url}")
	private String apiUrl;

	@Value("${football.api.key}")
	private String apiKey;

	@Value("#{${football.api.action}}")
	private Map<String, String> actionMap;

	@Autowired
	RestTemplate restTemplate;

	@Retry(name = "football-rest-client")
	public Country[] getCountries() throws FootballException {
		logger.debug(" Start - Inside getCountries()");

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put(ACTION, actionMap.get("getCountry"));
		queryParams.put(APIKEY, apiKey);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
		queryParams.forEach(builder::queryParam);
		Country[] countries = restTemplate.getForEntity(builder.toUriString(), Country[].class).getBody();

		logger.debug(" End - Inside getCountries()");
		return countries;
	}

	@Retry(name = "football-rest-client")
	public League[] getLeagues(int countryId) throws FootballException {

		logger.debug(" Start - Inside getLeagues()");

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put(ACTION, actionMap.get("getLeagues"));
		queryParams.put(COUNTRY_ID, String.valueOf(countryId));
		queryParams.put(APIKEY, apiKey);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
		queryParams.forEach(builder::queryParam);
		League[] leagues = restTemplate.getForEntity(builder.toUriString(), League[].class).getBody();

		logger.debug(" End - Inside getLeagues()");

		return leagues;
	}

	@Retry(name = "football-rest-client")
	public TeamStanding[] getTeamStandings(int leagueId) throws FootballException {
		logger.debug(" Start - Inside getTeamStandings()");

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put(ACTION, actionMap.get("getStanding"));
		queryParams.put(LEAGUE_ID, String.valueOf(leagueId));
		queryParams.put(APIKEY, apiKey);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
		queryParams.forEach(builder::queryParam);
		TeamStanding[] teamsStandings = restTemplate.getForEntity(builder.toUriString(), TeamStanding[].class)
				.getBody();
		logger.debug(" End - Inside getTeamStandings()");

		return teamsStandings;
	}
}
