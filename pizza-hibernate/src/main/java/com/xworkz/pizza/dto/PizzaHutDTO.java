package com.xworkz.pizza.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizza_table") 


public class PizzaHutDTO implements Serializable {
	
	@Override
	public String toString() {
		return "\n pizzaId=" + pizzaId + "\n  name=" + name + "\n location=" + location + "\n price=" + price
				+ "\n isAvailable=" + isAvailable + "\n size=" + size + "\n type=" + type + "\n" + "***********************";
	}

	@Column(name = "PIZZA_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pizzaId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "PRICE")
	private double price;
	

	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;
	
	@Column(name = "SIZE")
	private String size;
	
	@Column(name = "TYPE")
	private String type;

	public PizzaHutDTO(String name, String location, double price, boolean isAvailable, String size, String type) {
		super();
		System.out.println(this.getClass().getSimpleName() +"  Created");
		this.name = name;
		this.location = location;
		this.price = price;
		this.isAvailable = isAvailable;
		this.size = size;
		this.type = type;
	}
	
	

}
