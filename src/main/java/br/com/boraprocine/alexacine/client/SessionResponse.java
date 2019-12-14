package br.com.boraprocine.alexacine.client;

import java.util.List;

public class SessionResponse {

	private List<Movie> movies;
	private String theaterName;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

}
