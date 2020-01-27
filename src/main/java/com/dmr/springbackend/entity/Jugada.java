package com.dmr.springbackend.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dmr.springbackend.clases.Jugador;

@Entity
@Table (name = "jugadas")
public class Jugada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="jugador")
	private String idJugador;
	
	@Column(name="incremento")
	private int incremento;

		
	public Jugada() {
	}

	public Jugada(String idJugador, int incremento) {
		this.idJugador = idJugador;
		this.incremento = incremento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}

	public int getIncremento() {
		return incremento;
	}

	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}
	

}
