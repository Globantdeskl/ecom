package com.app.java;


public final class Employee {
	
	private final String name;
	private final Address address;

	public Employee(String name, Address address) {
		this.name = name;
		Address add = new Address();
		add.setCity(address.getCity());
		add.setCode(address.getCode());
		add.setCountry(address.getCountry());
		this.address = add;
		
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}
	
}
