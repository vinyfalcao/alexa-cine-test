package br.com.boraprocine.alexacine.model;

import java.util.List;

public class Sessao {

	private List<String> hora;
	private String cinema;

	public Sessao(List<String> hora, String cinema) {
		super();
		this.hora = hora;
		this.cinema = cinema;
	}

	public List<String> getHora() {
		return hora;
	}

	public void setHora(List<String> hora) {
		this.hora = hora;
	}

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

}
