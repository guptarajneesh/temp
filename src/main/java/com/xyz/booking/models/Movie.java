package com.xyz.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	private int durationInMins;
	private String language;
	private long releaseDate;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name = "th_admin_id", referencedColumnName = "id")
	@JsonBackReference
	private TheatreAdministrator movieAddedBy;
	
	@ManyToOne
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	//@JsonBackReference
	private Show shows; // = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "theatre_id", referencedColumnName = "id")
	//@JsonBackReference
	private Theatre playingAt;

	public Movie() {
		super();
	}

	public Movie(String title, int durationInMins, String language, Theatre playingAt) {
		super();
		this.title = title;
		this.durationInMins = durationInMins;
		this.language = language;
		this.playingAt = playingAt;
	}

	public Movie(String title, String description, int durationInMins, String language, long releaseDate, String genre,
			TheatreAdministrator movieAddedBy) {

		this.title = title;
		this.description = description;
		this.durationInMins = durationInMins;
		this.language = language;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.movieAddedBy = movieAddedBy;
	}

	public String getTitle() {
		return title;
	}

	public void updateTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void updateDescription(String description) {
		this.description = description;
	}

	public int getDurationInMins() {
		return durationInMins;
	}

	public void updateDurationInMins(int durationInMins) {
		this.durationInMins = durationInMins;
	}

	public String getLanguage() {
		return language;
	}

	public void updateLanguage(String language) {
		this.language = language;
	}

	public long getReleaseDate() {
		return releaseDate;
	}

	public void updateReleaseDate(long releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void updateGenre(String genre) {
		this.genre = genre;
	}

	public TheatreAdministrator getMovieAddedBy() {
		return movieAddedBy;
	}

	public void updateMovieAddedBy(TheatreAdministrator movieAddedBy) {
		this.movieAddedBy = movieAddedBy;
	}

	public Show getShows() {
		return shows;
	}

	public void adShow(Show show) {
		this.shows = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Theatre getPlayingAt() {
		return playingAt;
	}

	public void setPlayingAt(Theatre playingAt) {
		this.playingAt = playingAt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDurationInMins(int durationInMins) {
		this.durationInMins = durationInMins;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setReleaseDate(long releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setMovieAddedBy(TheatreAdministrator movieAddedBy) {
		this.movieAddedBy = movieAddedBy;
	}

	public void setShows(Show shows) {
		this.shows = shows;
	}

}