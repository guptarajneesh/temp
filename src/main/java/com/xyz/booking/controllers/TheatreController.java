package com.xyz.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xyz.booking.models.Theatre;
import com.xyz.booking.services.TheatreService;

@RestController
public class TheatreController {

	@Autowired
	private TheatreService theatreService;

	@PostMapping("/theatre")
	public ResponseEntity<Theatre> addTheater(@RequestBody Theatre  theatre) throws JsonProcessingException {
		return new ResponseEntity<Theatre>(theatreService.addTheater(theatre), HttpStatus.CREATED);
	}

	@GetMapping("/theatre")
	public ResponseEntity<List<Theatre>> getAllTheater() {
		return new ResponseEntity<List<Theatre>>(theatreService.getAllTheater(), HttpStatus.OK);
	}
	
	@DeleteMapping("/theatre")
	public ResponseEntity<Void> shutdownTheater(Theatre theater) {
		theatreService.shutdownTheater(theater);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
