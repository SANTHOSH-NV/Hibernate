package com.xworkz.pizza.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.pizza.dto.PizzaHutDTO;
import com.xworkz.sessionfactory.SingleFactory;

public class PizzaHutDAOImpl implements PizzaHutDAO {

	@Override
	public void savePizza(PizzaHutDTO dto) {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
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
			SingleFactory.closeSessionFactory();
		}
	}

	@Override
	public void fetchPizzaDetails() {

		Session session = null;
		try {
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
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
			SingleFactory.closeSessionFactory();

		}

	}

	@Override
	public void updatePizzaDetails() {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
			session = sessionFactory.openSession();
			PizzaHutDTO pizzaHutDTO = session.get(PizzaHutDTO.class, 3);
			pizzaHutDTO.setLocation("Peenya");
			pizzaHutDTO.setPrice(300);
			transaction = session.beginTransaction();
			session.update(pizzaHutDTO);
//			session.merge(pizzaHutDTO);
			transaction.commit();
			System.out.println("Update is Done");
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
			SingleFactory.closeSessionFactory();

		}

	}

	@Override
	public void deletePizzaDetails() {

		Session session = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
			session = sessionFactory.openSession();
			PizzaHutDTO pizzaHutDTO = session.get(PizzaHutDTO.class, 9);
			transaction = session.beginTransaction();
			session.delete(pizzaHutDTO);
			transaction.commit();
			System.out.println("Delete is Done");
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
//			if (sessionFactory != null) {
//				sessionFactory.close();
//				System.out.println("Session Factory is Closed");
//			} else {
//				System.out.println("Session Factory is not Closed");
//			}
			SingleFactory.closeSessionFactory();

		}
	}

	@Override
	public void loadAllPizzaRecords() {

		System.out.println("Invoked loadAllPizzaRecords()");
		Session session = null;
		try {
			SessionFactory factory = SingleFactory.getSessionFactory();
			session = factory.openSession();
			String hql = "from com.xworkz.pizza.dto.PizzaHutDTO";
			Query createQuery = session.createQuery(hql);
			List<PizzaHutDTO> list = createQuery.list();
			for (PizzaHutDTO pizzaHutDTO : list) {
				System.out.println(pizzaHutDTO);

			}
			System.out.println("Fetching All Details");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}

			SingleFactory.closeSessionFactory();

		}
	}

	@Override
	public void fetchLocationUsingPizzaId() {

		System.out.println("Invoked fetchLocationUsingPizzaId()");
		Session session = null;
		try {
			SessionFactory factory = SingleFactory.getSessionFactory();
			session = factory.openSession();
			String hql = "select location from PizzaHutDTO as pizza where pizzaId=10";
			Query createQuery = session.createQuery(hql);
			List list = createQuery.list();
			System.out.println(list);

			System.out.println("Fetching Location");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}

			SingleFactory.closeSessionFactory();

		}
	}

	@Override
	public void fetchNameUsingPizzaId() {
		
		System.out.println("Invoked fetchNameAndTypeUsingPizzaId()");
		Session session = null;
		try {
			SessionFactory factory = SingleFactory.getSessionFactory();
			session = factory.openSession();
			String hql = "select name from PizzaHutDTO As pizza where pizzaId=6";
			Query createQuery = session.createQuery(hql);
			List list = createQuery.list();
			System.out.println(list);
			

			System.out.println("Fetching Name And Type");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}

			SingleFactory.closeSessionFactory();

		}
		
	}
}
