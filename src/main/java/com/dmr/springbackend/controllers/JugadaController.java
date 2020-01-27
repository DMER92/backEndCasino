package com.dmr.springbackend.controllers;

import org.hibernate.Session;

import com.dmr.springbackend.dao.JugadaDAO;
import com.dmr.springbackend.entity.Jugada;

public class JugadaController {
	
	private Session session;
	private JugadaDAO DAO;

	public JugadaController(Session session, JugadaDAO DAO) {
		this.session = session;
		this.DAO = DAO;
	}
	
	/**
	 * Guardar la jugada en base de datos
	 * @param jugada
	 */
	public void guardarJugada(Jugada jugada) {
		DAO.save(jugada);		
	}
}
