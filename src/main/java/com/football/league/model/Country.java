package com.football.league.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//@Data
public class Country {

	@JsonProperty("country_id")
	private int countryId;

	@JsonProperty("country_name")
	private String countryName;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", getCountryId()=" + getCountryId()
				+ ", getCountryName()=" + getCountryName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
