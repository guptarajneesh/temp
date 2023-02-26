package com.xyz.booking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.booking.models.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show, Long> {

	public List<Show> findByShowName(String showName);
}