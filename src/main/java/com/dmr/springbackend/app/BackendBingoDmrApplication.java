package com.dmr.springbackend.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmr.springbackend.clases.Jugador;
import com.dmr.springbackend.controllers.JuegoController;
import com.dmr.springbackend.controllers.JugadaController;
import com.dmr.springbackend.controllers.ProveedorController;
import com.dmr.springbackend.daoimp.JuegoDAOimpl;
import com.dmr.springbackend.daoimp.JugadaDAOimpl;
import com.dmr.springbackend.daoimp.ProveedorDAOimpl;
import com.dmr.springbackend.entity.Juego;
import com.dmr.springbackend.entity.Jugada;
import com.dmr.springbackend.entity.Proveedor;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//Implementación conceptual de backend de un casino. 
//Un proveedor nos dara un jugador, que hará apuestas hasta que se le acabe el tiempo o se quede sin dinero
//Usamos base de datos H2
@SpringBootApplication
public class BackendBingoDmrApplication {
	
	
	public static void main(String[] args) {	
		
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
        	//Definimos los daos que se usaran, en este caso con hibernate
            JuegoDAOimpl juegosDAO = new JuegoDAOimpl(sessionFactory);
            JugadaDAOimpl jugadasDAO = new JugadaDAOimpl(sessionFactory);
            ProveedorDAOimpl proveedorDAO = new ProveedorDAOimpl(sessionFactory);
            try (Session session = sessionFactory.getCurrentSession()) {
                
                //Creamos los juegos
                JuegoController controllerJuego = new JuegoController(session, juegosDAO);
                ProveedorController controllerProveedor = new ProveedorController(session, proveedorDAO);
                controllerJuego.guardarJuego(new Juego("VideoBingo", 4, 20, 20, 5));
                controllerJuego.guardarJuego(new Juego("Blackjack",1,45, 10, 2));
                controllerJuego.guardarJuego(new Juego("Slot", 6, 10, 3, 1));
                controllerJuego.guardarJuego(new Juego("Poker",2,20, 15, 5));
                controllerJuego.guardarJuego(new Juego("Ruleta",3,30, 5, 1));
                
                //Creamos los proveedores
        		Proveedor pokerStar = new Proveedor("PKST", "Poker Star");
        		controllerProveedor.guardarProveedor(pokerStar);
        		
                
                List<Juego> juegos = controllerJuego.verJuegos();                                
                
                
                Jugador jugador = pokerStar.proporcionarJugador();
                
                JugadaController controllerJugada = new JugadaController(session, jugadasDAO);
                
                //Apostar mientras el jugador tenga dinero o tiempo
                do {               	
                //Seleccionamos al azar el juego donde se va a apostar
                Juego juegoActivo = juegos.get((int) (Math.random()*juegos.size()));
                
                
                
                try {
                	int balance = controllerJuego.RealizarJugada(juegoActivo, jugador.realizarApuesta(juegoActivo));
                	
                	Jugada jugada = new Jugada(jugador.getId(), balance);
                	jugador.setBalance(jugador.getBalance()+jugada.getIncremento());
                	System.out.println("Usuario:"+jugador.getId()+"  Incremento: "+Integer.toString(balance)+" Juego: "+juegoActivo.getNombre());
                	// Guardamos jugada en base de datos
                	controllerJugada.guardarJugada(jugada);
                } catch (Exception ex) {
        			System.out.println("Apuesta fuera de los limites del juego");
                }
                jugador.setLimiteTiempo(jugador.getLimiteTiempo()-5);
                } while (jugador.getBalance()>0 && jugador.getLimiteTiempo()>0);
                
                     
            }
        }	
		
	}
}
