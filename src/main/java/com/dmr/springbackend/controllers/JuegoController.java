package com.dmr.springbackend.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmr.springbackend.dao.JuegoDAO;
import com.dmr.springbackend.entity.Juego;

public class JuegoController {

	private Session session;
	private JuegoDAO DAO;

	public JuegoController(Session session, JuegoDAO DAO) {
		this.session = session;
		this.DAO = DAO;
	}
	
	/**
	 * Guarda el juego en Base de datos
	 * @param juego a guardar
	 */
	public void guardarJuego(Juego juego) {
         DAO.save(juego);	
	}
	
	/**
	 * Ver todos los juegos en la base de datos
	 * @return List de los juegos
	 */
	public List<Juego> verJuegos() {
		return DAO.list();
	}
	
	/**
	 * Dado un juego y una apuesta, intentar apostar y devolver el premio
	 * @param juego en el que se hace la jugada
	 * @param apuesta 
	 * @return resultado de la jugada
	 * @throws Exception si no se ha podido hacer la apuesta
	 */
	public int RealizarJugada(Juego juego, int apuesta) throws Exception {
		int balance = 0;
		if (apuesta < juego.getApuestaMin() || apuesta > juego.getApuestaMax()) {
			throw new Exception();
		} else {
			if (juego.getProbabilidad() <= (int) (Math.random()*100)) {
				balance = apuesta*juego.getPremio();
			}
			else {
				balance = 0 - apuesta;
			}
		}		
		return balance;		
	}
}
