package com.xyz.booking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.booking.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

	public List<Movie> findByTitle(String movieName);
}