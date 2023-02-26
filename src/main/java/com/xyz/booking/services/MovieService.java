package com.xyz.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.models.Movie;
import com.xyz.booking.repos.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;

	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovie() {
		return movieRepo.findAll();
	}

	public boolean removeMovie(Movie movie) {
		movieRepo.delete(movie);
		return true;
	}

}
