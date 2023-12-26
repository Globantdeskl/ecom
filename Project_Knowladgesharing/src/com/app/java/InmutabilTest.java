package com.app.java;

public class InmutabilTest {

	public static void main(String[] args) {

		Address add = new Address("Box", "india", 123);
		Employee emp = new Employee("Sanjay", add);
		System.out.println("Testing of Object " + emp);
		add.setCity("Mirzapur");
		System.out.println("Now I am able to change city name" + emp);

	}
}
