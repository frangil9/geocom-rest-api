package com.group.system.model;

public class IngredientQuery {

	public double total;
	public String name;
	
	public IngredientQuery(double total, String name) {
		super();
		this.total = total;
		this.name = name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
