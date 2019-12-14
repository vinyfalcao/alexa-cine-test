package br.com.boraprocine.alexacine.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CitiesAPIClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "https://api-content.ingresso.com/v0/states/city/name/";

	public Long getCityIdByName(String name) {
		return this.restTemplate.getForObject(URL + name, City.class).getId();
	}

}
