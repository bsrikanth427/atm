package com.bank.atm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmDto {

	private int distance;
	private String functionality;
	private String type;
	
	@JsonProperty("address")
	private AddressDto addressDto;
	
	@JsonProperty("openingHours")
	private List<OpeningHourDto> openingHoursDto;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public List<OpeningHourDto> getOpeningHoursDto() {
		return openingHoursDto;
	}

	public void setOpeningHoursDto(List<OpeningHourDto> openingHoursDto) {
		this.openingHoursDto = openingHoursDto;
	}
	
	
}
