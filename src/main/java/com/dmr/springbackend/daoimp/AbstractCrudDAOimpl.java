package com.dmr.springbackend.daoimp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractCrudDAOimpl<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> clase;
    private final String entidad;

    protected AbstractCrudDAOimpl(SessionFactory sessionFactory, Class<T> clase, String entidad) {
        this.sessionFactory = sessionFactory;
        this.clase = clase;
        this.entidad = entidad;
    }
    public T save(T entity) {
    	Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(entity);
        tx.commit();
        return entity;
    }
    public void delete(T entity) {
    	Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(entity);
        tx.commit();
    }

    public T find(int id) {
    	Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
    	T entity = sessionFactory.getCurrentSession().find(clase, id);
    	tx.commit();
        return entity;
    }
    public List<T> list() {
    	Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(clase);
        query.select(query.from(clase));
        List<T> list = session.createQuery(query).getResultList();
        tx.commit();        
        return list;
    }
}
