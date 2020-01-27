package com.dmr.springbackend.daoimp;

import org.hibernate.SessionFactory;

import com.dmr.springbackend.dao.JuegoDAO;
import com.dmr.springbackend.dao.JugadaDAO;
import com.dmr.springbackend.entity.Juego;
import com.dmr.springbackend.entity.Jugada;

public class JugadaDAOimpl extends AbstractCrudDAOimpl<Jugada> implements JugadaDAO{

	public JugadaDAOimpl(SessionFactory sessionFactory) {
		super(sessionFactory, Jugada.class, "Jugada");
	}

}
