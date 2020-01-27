package com.dmr.springbackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface CrudDAO<T> {
    
    
    public T save(T entity);
    
    public void delete(T entity);

    public T find(int id); 
    
    public List<T> list();
}
