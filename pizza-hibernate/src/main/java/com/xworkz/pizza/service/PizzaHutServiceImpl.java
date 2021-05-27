package com.xworkz.pizza.service;

import com.xworkz.pizza.dao.PizzaHutDAO;
import com.xworkz.pizza.dao.PizzaHutDAOImpl;
import com.xworkz.pizza.dto.PizzaHutDTO;

public class PizzaHutServiceImpl implements PizzaHutService {

	PizzaHutDAO impl = new PizzaHutDAOImpl();

	@Override
	public void validatePizzaHutDTO(PizzaHutDTO dto) {

		Boolean flag = true;
		if (dto.getName() == null || dto.getName().length() < 4) {
			System.out.println("Invalid Pizza Name");
			flag = false;
		}

		if (dto.getLocation() == null || dto.getLocation().length() < 4) {
			System.out.println("Invalid Pizza Location");
			flag = false;
		}

		if (dto.getPrice() == 0 || dto.getPrice() < 90) {
			System.out.println("Invalid Pizza Price");
			flag = false;
		}

		if (dto.getSize() == null || dto.getSize().length() < 4) {
			System.out.println("Invalid Pizza size");
			flag = false;
		}

		if (dto.getType() == null || dto.getType().length() > 8) {
			System.out.println("Invalid  Pizza  type");
			flag = false;
		}

		if (flag) {
			impl.savePizza(dto);
			System.out.println("Added Successfully");
		}

	}

	@Override
	public void validateFetchPizzaDetails() {
		
		impl.fetchPizzaDetails();
		System.out.println("Fetched Details Successfully");
		
	}

	@Override
	public void validateUpdatePizzaDetails() {
		
		impl.updatePizzaDetails();
		System.out.println("Updated Details");
	}

	@Override
	public void validateDeletePizzaDetails() {
		
		impl.deletePizzaDetails();
		System.out.println("Deleted  Details");
	}

}
