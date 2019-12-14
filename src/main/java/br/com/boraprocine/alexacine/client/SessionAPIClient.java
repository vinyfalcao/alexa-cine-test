package br.com.boraprocine.alexacine.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.boraprocine.alexacine.model.Sessao;

@Component
public class SessionAPIClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "https://api-content.ingresso.com/v0/sessions/city/%d/theater/%d";

	public List<Sessao> getSessions(final Long cityId, String movieName, List<Theater> theaters) {

		List<SessionResponse> responses = theaters.parallelStream().map((theater) -> {
			TheaterResponse[] theaterResponse = this.restTemplate
					.getForObject(String.format(URL, cityId, theater.getId()), TheaterResponse[].class);
			SessionResponse response = new SessionResponse();
			response.setMovies(theaterResponse[0].getMovies());
			response.setTheaterName(theater.getName());
			return response;
		}).collect(Collectors.toList());
		return responses.stream()
				.map(response -> new Sessao(
						response.getMovies().stream()
								.filter(movie -> movie.getTitle().toUpperCase().contains(movieName.toUpperCase()))
								.flatMap(movie -> movie.getRooms().stream())
								.flatMap(room -> room.getSessions().stream())
								.map(room -> room. getDate().getHour()).collect(Collectors.toList()),
						response.getTheaterName()))
				.collect(Collectors.toList());

	}

}
