package com.dmr.springbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dmr.springbackend.clases.Jugador;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;
    
    @Transient
    private int contadorId;    
    
    public Proveedor(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		contadorId = 0;
	}
    
    /**
     * Nos devuelve un jugador, construye su id a partir de la propia
     * @return Jugador
     */
	public Jugador proporcionarJugador() {
    	String nuevaId = id + Integer.toString(contadorId);
    	Jugador jugador = new Jugador(nuevaId, (int) Math.random()*300+200, (int) Math.random()*400+200, id);
    	contadorId++;
    	return jugador;
    }
}
