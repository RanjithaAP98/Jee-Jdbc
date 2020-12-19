package com.xworkz.jdbcconnectivity.crudoperations;

public class Salesman {
	
	private int id;
	private String name;
	private String city;
	private String commission;
	
	public Salesman(int id, String name, String city, String commission) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.commission = commission;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "Salesman [id=" + id + ", name=" + name + ", city=" + city + ", commission=" + commission + "]";
	}
}
