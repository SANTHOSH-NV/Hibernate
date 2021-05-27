package com.xworkz.pizza;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.pizza.dao.PizzaHutDAO;
import com.xworkz.pizza.dao.PizzaHutDAOImpl;
import com.xworkz.pizza.dto.PizzaHutDTO;
import com.xworkz.pizza.service.PizzaHutService;
import com.xworkz.pizza.service.PizzaHutServiceImpl;

public class MainApp {

	public static void main(String[] args) {
//		PizzaHutService serviceImpl = new PizzaHutServiceImpl();

//		PizzaHutDTO dto = new PizzaHutDTO("Spicy Chicken", "KR Puram", 200, false, "Medium", "Non-Veg");

//		serviceImpl.validatePizzaHutDTO(dto);
//		serviceImpl.validateFetchPizzaDetails();

	
//		serviceImpl.validateUpdatePizzaDetails();
		
//		serviceImpl.validateDeletePizzaDetails();
		
		
		PizzaHutDAO impl = new PizzaHutDAOImpl();
		impl.loadAllPizzaRecords();
//		impl.fetchLocationUsingPizzaId();
		
//		impl.fetchNameUsingPizzaId();
		
	}

}
