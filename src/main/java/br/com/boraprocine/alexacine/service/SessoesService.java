package br.com.boraprocine.alexacine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boraprocine.alexacine.client.CitiesAPIClient;
import br.com.boraprocine.alexacine.client.SessionAPIClient;
import br.com.boraprocine.alexacine.client.Theater;
import br.com.boraprocine.alexacine.client.TheatersAPIClient;
import br.com.boraprocine.alexacine.model.Sessao;

@Service
public class SessoesService {

	@Autowired
	private CitiesAPIClient citiesClient;

	@Autowired
	private TheatersAPIClient theatersAPIClient;

	@Autowired
	private SessionAPIClient sessionsAPIClient;

	public List<Sessao> findByCityAndMovie(String city, String movie) {
		Long cityId = citiesClient.getCityIdByName(city);
		List<Theater> theaters = theatersAPIClient.getTheaterId(cityId);
		return sessionsAPIClient.getSessions(cityId, movie, theaters);
	}

}
