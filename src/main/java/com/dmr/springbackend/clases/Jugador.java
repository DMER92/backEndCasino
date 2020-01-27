package com.dmr.springbackend.clases;

import com.dmr.springbackend.entity.Juego;
import com.dmr.springbackend.entity.Jugada;

public class Jugador {
		
	private String id;
	
	private int balance;
	
	private int limiteTiempo;
	
	private String proveedorId;
	
	public Jugador(String id, int balance, int limiteTiempo, String proveedorId) {
		this.id = id;
		this.balance = balance;
		this.limiteTiempo = limiteTiempo;
		this.proveedorId = proveedorId;
	}
	
	public int realizarApuesta(Juego juego) {
		int apuestaMaxima = juego.getApuestaMax();
		if (apuestaMaxima > balance) {
			apuestaMaxima = balance;
		}
		int apuesta = (int) (Math.random() * apuestaMaxima);
		return apuesta;
	}		
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getLimiteTiempo() {
		return limiteTiempo;
	}

	public void setLimiteTiempo(int limiteTiempo) {
		this.limiteTiempo = limiteTiempo;
	}

	public String getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(String proveedorId) {
		this.proveedorId = proveedorId;
	}
	
	
	
}
