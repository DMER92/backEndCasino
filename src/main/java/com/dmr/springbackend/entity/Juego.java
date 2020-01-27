package com.dmr.springbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "juego")
public class Juego {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "premio")
	    private int premio;

	    @Column(name = "probabilidad_premio")
	    private int probabilidad;
	    
	    @Column(name = "apuesta_max")
	    private int apuestaMax;
	    
	    @Column(name = "apuesta_min")
	    private int apuestaMin;
	    
	    

	    public Juego() {			
		}
	    
		public Juego(String nombre, int premio, int probabilidad, int apuestaMax, int apuestaMin) {
			this.nombre = nombre;
			this.premio = premio;
			this.probabilidad = probabilidad;
			this.apuestaMax = apuestaMax;
			this.apuestaMin = apuestaMin;
		}		
		
		
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public int getPremio() {
			return premio;
		}



		public void setPremio(int premio) {
			this.premio = premio;
		}



		public int getProbabilidad() {
			return probabilidad;
		}



		public void setProbabilidad(int probabilidad) {
			this.probabilidad = probabilidad;
		}

		public int getApuestaMax() {
			return apuestaMax;
		}

		public void setApuestaMax(int apuestaMax) {
			this.apuestaMax = apuestaMax;
		}

		public int getApuestaMin() {
			return apuestaMin;
		}

		public void setApuestaMin(int apuestaMin) {
			this.apuestaMin = apuestaMin;
		}	
		
		
	  
}
