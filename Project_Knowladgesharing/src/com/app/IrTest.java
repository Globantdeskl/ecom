package com.app;

import java.util.HashMap;
import java.util.Map;

public class IrTest {

	private static void printEmployeeName(Map<String, Employees> empMap, String string) {
		// Print all employee's name whose age is greater than ageLimit(second parameter of this method)
		empMap.entrySet().stream().filter(x -> x.getValue().age > Integer.valueOf(string)).forEach(System.out::print);
	}

	public static void main(String[] strings) {
		
		// Created 4 Employees Objects
		Employees e1 = new Employees("e1", "Amar", (int) 1000, 25);// Change to double
		Employees e2 = new Employees("e2", "Akbar", (int) 4.8, 27);
		Employees e3 = new Employees("e3", "Anthony", (int) 23.22, 23);
		Employees e4 = new Employees("e4", "Geeta", (int) 222.222, 26);

		// Populate employee Object in map.
		Map<String, Employees> empMap = new HashMap<String, Employees>();
		empMap.put("e1", e1);
		empMap.put("e2", e2);
		empMap.put("e3", e3);
		empMap.put("e4", e4);

		printEmployeeName(empMap, "25");

	}

}
