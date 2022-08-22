package com.football.league.service;

import com.football.league.exception.FootballException;

public interface ICountryService {

	public int getCountries(String countryName) throws FootballException;
}
