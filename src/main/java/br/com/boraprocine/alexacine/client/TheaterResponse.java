package br.com.boraprocine.alexacine.client;

import java.util.List;

public class TheaterResponse {

	private List<Movie> movies;

	public TheaterResponse() {
		super();
	}

	public TheaterResponse(List<Movie> movies) {
		super();
		this.movies = movies;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
