package com.xyz.booking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.booking.models.TheatreCompany;

@Repository
public interface TheatreCompanyRepo extends JpaRepository<TheatreCompany, Long> {

	public List<TheatreCompany> findByCompanyName(String theatreName);
}