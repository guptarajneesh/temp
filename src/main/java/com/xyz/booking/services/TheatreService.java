package com.xyz.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.models.Theatre;
import com.xyz.booking.repos.TheatreCompanyRepo;
import com.xyz.booking.repos.TheatreRepo;

@Service
public class TheatreService {

	@Autowired
	private TheatreRepo theatreRepo;

	@Autowired
	private TheatreCompanyRepo tcRepo;

	public Theatre addTheater(Theatre theatre) {
		tcRepo.save(theatre.getTheatreCompany());
		return theatreRepo.save(theatre);
	}

	public List<Theatre> getAllTheater() {
		return theatreRepo.findAll();
	}

	public Theatre findByTheatreId(Long id) {
		return theatreRepo.findById(id).get();
	}

	public void shutdownTheater(Theatre theater) {
		theatreRepo.delete(theater);
	}

}
