package com.dmr.springbackend.controllers;

import org.hibernate.Session;

import com.dmr.springbackend.dao.ProveedorDAO;
import com.dmr.springbackend.entity.Proveedor;


public class ProveedorController {
	private Session session;
	private ProveedorDAO DAO;
	
	public ProveedorController(Session session, ProveedorDAO DAO) {
		this.session = session;
		this.DAO = DAO;
	}
	
	/**
	 * Guardar 
	 * @param proveedor
	 */
	public void guardarProveedor(Proveedor proveedor) {
		DAO.save(proveedor);		
	}
}
