package com.xworkz.pizza.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.pizza.dto.PizzaHutDTO;

public class PizzaHutDAOImpl implements PizzaHutDAO {

	@Override
	public void savePizza(PizzaHutDTO dto) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction =  null;
		try {
			
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Successfully Added into  DB");
			transaction = session.beginTransaction();
//			session.save(dto);
			session.persist(dto);
			transaction.commit();
		}

		catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("Session Factory is Closed");
			} else {
				System.out.println("Session Factory is not Closed");
			}
		}
	}

	@Override
	public void fetchPizzaDetails() {

		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			PizzaHutDTO pizzaHutDTO = session.get(PizzaHutDTO.class, 5);
			System.out.println(pizzaHutDTO);
		}

		catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("Session Factory is Closed");
			} else {
				System.out.println("Session Factory is not Closed");
			}
		}

	}
}
