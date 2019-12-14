package br.com.boraprocine.alexacine.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TheatersAPIClient {

	@Autowired
	private RestTemplate restTemplate;

	private static final String URL = "https://api-content.ingresso.com/v0/theaters/city/";

	public List<Theater> getTheaterId(Long cityId) {
		Theater[] response = this.restTemplate.getForObject(URL + cityId, Theater[].class);
		return Arrays.stream(response).collect(Collectors.toList());
	}

}
