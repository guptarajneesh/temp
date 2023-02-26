package com.xyz.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.booking.models.Show;
import com.xyz.booking.services.ShowService;
import com.xyz.booking.services.TheatreService;

@RestController
public class ShowController {

	@Autowired
	private ShowService showService;

	@Autowired
	private TheatreService thSrvice;

	@PostMapping("/show")
	public ResponseEntity<Show> addShow(@RequestBody Show show) {
		return new ResponseEntity<Show> (showService.addShow(thSrvice.findByTheatreId(Long.valueOf(1)),show), HttpStatus.CREATED);
	}

	@GetMapping("/show")
	public ResponseEntity<List<Show>> getAllShow(Show movie) {
		return new ResponseEntity<List<Show>> (showService.findAllShow(), HttpStatus.OK);
	}

	public boolean removeMovie(Show movie) {
		showService.removeShow(movie);
		return true;
	}

}
