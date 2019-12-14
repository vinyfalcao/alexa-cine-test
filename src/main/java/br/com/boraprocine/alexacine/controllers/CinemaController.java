package br.com.boraprocine.alexacine.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.boraprocine.alexacine.model.Sessao;
import br.com.boraprocine.alexacine.service.SessoesService;

@RestController
@RequestMapping("/sessoes")
public class CinemaController {

	@Autowired
	private SessoesService service;

	@GetMapping
	public ResponseEntity<List<Sessao>> findAllSessoes(@RequestParam("city") String city,
			@RequestParam("movie") String movie) {
		return ResponseEntity.ok(service.findByCityAndMovie(city, movie));
	}

}
