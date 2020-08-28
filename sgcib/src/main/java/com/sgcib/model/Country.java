package com.sgcib.model;

import java.util.List;

public class Country {
	
	private String name;
    private List<String> cities;
    
    
	public Country(String name) {
		super();
		this.name = name;
	}
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
    
}
