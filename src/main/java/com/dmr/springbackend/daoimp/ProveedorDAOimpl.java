package com.dmr.springbackend.daoimp;

import org.hibernate.SessionFactory;

import com.dmr.springbackend.dao.ProveedorDAO;
import com.dmr.springbackend.entity.Jugada;
import com.dmr.springbackend.entity.Proveedor;

public class ProveedorDAOimpl extends AbstractCrudDAOimpl<Proveedor> implements ProveedorDAO{

	public ProveedorDAOimpl(SessionFactory sessionFactory) {
		super(sessionFactory, Proveedor.class, "Proveedor");
	}

}
