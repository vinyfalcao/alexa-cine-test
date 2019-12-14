package br.com.boraprocine.alexacine.client;

import java.util.List;

public class Room {

	private String name;
	private List<Session> sessions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
