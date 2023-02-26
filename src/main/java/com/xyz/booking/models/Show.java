package com.xyz.booking.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "show")
@JsonIgnoreProperties
public class Show implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("show_name")
	private String showName;

	@JsonProperty("start_time")
	private String startTime; // example: 6:30PM

	@JsonProperty("duration")
	private int durationInMin;
	
	@JsonProperty("playing_at") 
	private String playingAt;

	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	@JsonProperty("movie")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "booking_id", referencedColumnName = "id")
	@JsonProperty("booking")
	private Booking booking;

	public Show() {
		super();
	}

	public Show(String startTime, String showName, String playingAt, Movie movie) {
		this.startTime = startTime;
		this.showName = showName;
		this.playingAt = playingAt;
		this.movie = movie;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}
	
	public String getPlayingAt() {
		return playingAt;
	}

	public void setPlayingAt(String playingAt) {
		this.playingAt = playingAt;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}