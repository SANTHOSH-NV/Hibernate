package com.xworkz.pizza.dao;

import com.xworkz.pizza.dto.PizzaHutDTO;

public interface PizzaHutDAO {
	
	public void savePizza(PizzaHutDTO dto);
	
	public void fetchPizzaDetails();

}
