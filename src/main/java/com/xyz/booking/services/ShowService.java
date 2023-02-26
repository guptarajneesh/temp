package com.xyz.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.booking.models.Show;
import com.xyz.booking.models.Theatre;
import com.xyz.booking.repos.ShowRepo;

@Service
public class ShowService {

	@Autowired
	private ShowRepo showRepo;
	
	public Show addShow(Theatre theatre, Show show) {
		return showRepo.save(show);
	}
	
	public List<Show> findAllShow() {
		return showRepo.findAll();
	}

	public boolean removeShow(Show show) {
		showRepo.delete(show);
		return true;
	}

}
