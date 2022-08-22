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
import com.football.league.model.Country;

@Service
public class CountryServiceImpl implements ICountryService {

	private static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Autowired
	FootballRestClient footballRestClient;

	public int getCountries(String countryName) throws FootballException {
		int countryId = 0;
		Country[] countries = footballRestClient.getCountries();
		if(countries != null) {
			logger.debug("Countries: " + Arrays.toString(countries));
			logger.debug("Country Name: " + countryName);
			countryId = findCountryIdByName(countries, countryName);
			logger.debug("Country Id: " + countryId);
		}
		return countryId;
	}

	private int findCountryIdByName(Country[] countries, String countryName) {
		Optional<Country> optional = Stream.of(countries).filter(c -> countryName.equals(c.getCountryName()))
				.findFirst();
		if (optional.isPresent()) {
			return optional.get().getCountryId();
		}
		throw new FootballException("Invalid Country Name");
	}
}
