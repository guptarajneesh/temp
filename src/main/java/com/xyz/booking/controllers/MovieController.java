package com.xyz.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.booking.models.Movie;
import com.xyz.booking.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/movie")
	public Movie addMovie(Movie movie) {
		return movieService.addMovie(movie);
	}

	@GetMapping("/movie")
	public List<Movie> getAllMovie() {
		return movieService.getAllMovie();
	}
	
	public boolean removeMovie(Movie movie) {
		movieService.removeMovie(movie);
		return true;
	}

}
