package com.app.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Subject implements Cloneable {
	
	private Set<String> subjects;

	public Subject() {
		subjects = new HashSet<>(Arrays.asList("Maths", "Science", "English", "History"));
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// call `super.clone()` to obtain the cloned object reference
		return super.clone();
	}

	@Override
	public String toString() {
		return subjects.toString();
	}

	public Set<String> getSubjects() {
		return subjects;
	}
}