package com.app.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {

	private String name; // immutable field
	private int age; // primitive field

	private Subject subjects;
	private Map<String, Integer> map;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;

		map = new HashMap<String, Integer>() {
			{
				put(name, age);
			}
		};

		subjects = new Subject();
	}

	@Override
	public String toString() {
		return Arrays.asList(name, String.valueOf(age), subjects.toString()).toString();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Set<String> getSubjects() {
		return subjects.getSubjects();
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	// include remaining getters and setters
}
