package com.app.inter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test implements Cloneable {

	public static void main(String[] args) {

		String sentences = "Narendar";
		List<String> wordsListt = Arrays.stream(sentences.split("")).collect(Collectors.toList());
		Map<String, Integer> wordsMapWithCounts = wordsListt.stream()
				.collect(Collectors.toMap(Function.identity(), word -> 1, Math::addExact));

		int maxValueInMap = (Collections.max(wordsMapWithCounts.values()));

		System.out.println(maxValueInMap);

		List<String> hh = wordsMapWithCounts.entrySet().stream().filter(e -> e.getValue() == maxValueInMap)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		hh.forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
		int max1 = numbers.stream().max(Integer::compare).get();
		System.out.println("\nLargest number using " + "max(Integer::compare).get() is = " + max1);

		int[] A = { 6, 8, 3, 5, 1, 9 };

		int max = Arrays.stream(A).max().getAsInt();

		/*
		 * 
		 * List<Employee> hondaColors = new ArrayList<>(); hondaColors.add(new
		 * Employee("Naren", 23, 22.3, 1)); hondaColors.add(new Employee("charen", 29,
		 * 22.3, 2)); hondaColors.add(new Employee("charen", 20, 22.3, 8));
		 * 
		 * List<Employee> emp = new ArrayList<>();
		 * 
		 * // Deep Cloning Collections.copy(hondaColors, emp);
		 * 
		 * // Modify the list item in cloned list - it should affect the original list
		 * item
		 * 
		 * // After Changes emp.add(new Employee("Ramcharen", 23, 22.3, 19)); //
		 * hondaColors.forEach(x -> System.out.println(" old :: " + x)); //
		 * emp.forEach(x -> System.out.println(" new :: " + x));
		 * 
		 * Set<String> ss = new HashSet<>(); Stream<Employee> st =
		 * hondaColors.stream().filter(x -> ss.add(x.getName())); // Employee h =
		 * st.findAny().get(); // System.out.println(" Firsrt name :: " + h.name); //
		 * st.forEach(x -> System.out.println(" Employee name :: " + x)); st.reduce((x,
		 * y) -> y);
		 * 
		 * List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
		 * 
		 * int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
		 * 
		 * // System.out.println(max);
		 * 
		 * /* numbers.stream().sorted(Comparator.reverseOrder()).limit(4).collect(
		 * Collectors.toList()) .forEach(x -> System.out.println(" new :: " + x));
		 */

		numbers.stream().sorted().limit(4).collect(Collectors.toList())
				.forEach(x -> System.out.println(" new :: " + x));

		Employee str = hondaColors.stream().max(Comparator.comparing(Employee::getName)).orElseThrow();

		List<Employee> list = hondaColors.stream().collect(Collectors.groupingBy(Employee::getAge, TreeMap::new, Collectors.toList())).lastEntry().getValue();
		list.forEach(x -> System.out.println(" nnmnm :: " + x));

		Employee age = hondaColors.stream().max(Comparator.comparing(Employee::getAge)).orElseThrow();

		System.out.println(" nnmnm :: " + age.getAge());

		Employee agemin = hondaColors.stream().min(Comparator.comparing(Employee::getAge)).orElseThrow();

		System.out.println(" nnmnm :: " + agemin.getAge());

		List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");

		String citiesCommaSeparated = String.join("#", cities);

		System.out.println(citiesCommaSeparated);

		String s = "Welcome! to Geeksforgeeks Planet";

		char ch = s.charAt(3);
		System.out.println(ch);

	}

}
