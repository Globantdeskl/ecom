package com.app.java.designpattern;

public class Employee {

	private static volatile Employee emp = null;

	private Employee() {

	}

	public static Employee getMethod() {

		if (!emp.equals(null)) {

			synchronized (emp) {

				if (!emp.equals(null)) {

					emp = new Employee();
				}

			}

		}

		return emp;

	}

}
