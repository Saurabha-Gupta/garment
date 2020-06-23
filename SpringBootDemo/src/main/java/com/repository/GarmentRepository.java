package com.repository;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.UsrMain;

@Repository
public class GarmentRepository {

	//@Autowired
	public SessionFactory sessionFactory;
	
	public void saveObject(Object object) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(object);
		transaction.commit();
		session.close();
	}
	public Object getObject(long primaryKey,String entityName) {
		Session session = sessionFactory.openSession();
		return session.get(entityName, primaryKey);
	}
	
	public List<UsrMain> getAllUsers() {
		Session session  = sessionFactory.openSession();
		return session.createCriteria(UsrMain.class).list();
	}
	
	public Object getObjectByValue(String value,String entityName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(entityName);
		System.out.println(value+" - value");
		criteria.add(Restrictions.eq("userId", value));
		Object obj = criteria.list().get(0);
		//session.close();
		return obj;
	}
	
	public void delete(Object object) {
		Session session  = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}
	
}
