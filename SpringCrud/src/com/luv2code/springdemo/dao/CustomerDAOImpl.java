package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create  query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute query
		List<Customer> customers = theQuery.getResultList();
		
		// return list of customers
		return customers;
	}

}
