package com.bank.atm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpeningHourDto {

	private int dayOfWeek;
	
	@JsonProperty("hours")
	private List<HoursDto> hoursDto;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<HoursDto> getHoursDto() {
		return hoursDto;
	}

	public void setHoursDto(List<HoursDto> hoursDto) {
		this.hoursDto = hoursDto;
	}
	
	
}
