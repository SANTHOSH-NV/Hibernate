package com.xworkz.sewingmachine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.sewingmachine.dto.SewingMachineDTO;

public class SewingMachineDAOImpl implements SewingMachineDAO {

	@Override
	public void saveSewingMachine(SewingMachineDTO dto) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
//			session.save(dto);
			session.persist(dto);
			session.getTransaction().commit();
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
		}
		if (sessionFactory != null) {
			sessionFactory.close();
			System.out.println("SessionFactory is Closed");

		} else {
			System.out.println("SessionFactory is not Closed");
		}

	}

	@Override
	public void fetchSewingMachineDetails() {

		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			SewingMachineDTO machineDTO = session.get(SewingMachineDTO.class, 7);
			System.out.println(machineDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is Closed");
			} else {
				System.out.println("Session is not Closed");
			}
		}
		if (sessionFactory != null) {
			sessionFactory.close();
			System.out.println("SessionFactory is Closed");

		} else {
			System.out.println("SessionFactory is not Closed");
		}
	}

}
