package com.dmr.springbackend.daoimp;

import org.hibernate.SessionFactory;

import com.dmr.springbackend.dao.JuegoDAO;
import com.dmr.springbackend.entity.Juego;;

public class JuegoDAOimpl extends AbstractCrudDAOimpl<Juego> implements JuegoDAO {

	public JuegoDAOimpl(SessionFactory sessionFactory) {
		super(sessionFactory, Juego.class, "Juego");
	}

			

}
