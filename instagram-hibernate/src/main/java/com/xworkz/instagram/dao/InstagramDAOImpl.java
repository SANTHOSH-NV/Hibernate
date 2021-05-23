package com.xworkz.instagram.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.instagram.dto.InstagramDTO;

public class InstagramDAOImpl implements InstagramDAO {

	@Override
	public void saveInstagramDTO(InstagramDTO dto) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			session.save(dto);
			session.persist(dto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {

			if (session != null) {
				session.close();
				System.out.println("Session is Closed");

			} else {
				System.out.println("Session is Not Closed");
			}

			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("SessionFactory is Closed");
			} else {
				System.out.println("SessionFactory is Not Closed");
			}
		}
	}

	@Override
	public void fetchInstagramDetails() {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			InstagramDTO instagramDTO = session.get(InstagramDTO.class, 7);
			System.out.println(instagramDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
				System.out.println("Session is Closed");

			} else {
				System.out.println("Session is Not Closed");
			}

			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("SessionFactory is Closed");
			} else {
				System.out.println("SessionFactory is Not Closed");
			}
		}		
	}

}
