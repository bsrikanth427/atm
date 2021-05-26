package com.bank.atm.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.atm.dto.AtmDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AtmService {

	private static final Logger log = LoggerFactory.getLogger(AtmService.class);
	
	@Autowired RestTemplate restTemplate;
	@Autowired Environment env;
	
	private List<AtmDto> atms = null;
	
	@Value("${atm.base.url}")
	private String url;
	
	@PostConstruct
	public void init() throws JsonMappingException, JsonProcessingException {
		log.info("Collecting atms from base endpoint: {} ", url);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,null,String.class);
		log.info("status: {}", responseEntity.getStatusCodeValue());
		if(responseEntity.hasBody()) {
			String response = responseEntity.getBody();
			response = response.replace(")]}',", "");
			ObjectMapper mapper = new ObjectMapper();
			atms = mapper.readValue(response, new TypeReference<List<AtmDto>>() {});
			if(atms != null)
			log.info("atms size: {}", atms.size());
		}
		
	}
	
	public List<AtmDto>  collectAtms() {
		return atms;
	}
	
	public List<AtmDto> fiterAtmsByCity(String city) {
		return atms
				.stream()
				.filter(atm -> atm.getAddressDto().getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
	}
}
