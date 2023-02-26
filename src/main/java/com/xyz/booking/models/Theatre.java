package com.xyz.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "th_comp_id", referencedColumnName = "id")
	@JsonProperty("theatre_company")
	private TheatreCompany theatreCompany;

	@JsonProperty("theatre_name")
	@Column(name = "theatre_name")
	private String theatreName;
	
	@JsonProperty("theatre_city")
	@Column(name = "theatre_city")
	private String theatreCity;

	public Theatre() {
		super();
	}

	public Theatre(TheatreCompany theatreCompany, String theatreName) {
		this.theatreCompany = theatreCompany;
		this.theatreName = theatreName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TheatreCompany getTheatreCompany() {
		return theatreCompany;
	}

	public void setTheatreCompany(TheatreCompany theatreCompany) {
		this.theatreCompany = theatreCompany;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String name) {
		this.theatreName = name;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	
}