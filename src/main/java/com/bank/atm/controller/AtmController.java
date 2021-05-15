package com.bank.atm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.atm.dto.AtmDto;
import com.bank.atm.service.AtmService;

@RestController
@RequestMapping("/api")
public class AtmController {

	private static final Logger log = LoggerFactory.getLogger(AtmController.class);
	
	@Autowired AtmService atmService;
	
	@GetMapping("/atms")
	public ResponseEntity<List<AtmDto>> collectAtms() {
		log.info("Getting atms info");
		return ResponseEntity.ok(atmService.collectAtms());
	}
	
	@GetMapping("/atms/{city}")
	public ResponseEntity<List<AtmDto>> filterAtmsByCity(@PathVariable("city") String city) {
		log.info("filtering atms info by city:{} ", city);
		return ResponseEntity.ok(atmService.fiterAtmsByCity(city));
	}
}
