package com.xyz.booking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.booking.models.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Long> {

	public List<Theatre> findByTheatreName(String theatreName);
}