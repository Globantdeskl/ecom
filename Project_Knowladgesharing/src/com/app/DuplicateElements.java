package com.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {
	public static void main(String args[]) {

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		Set<Integer> set = new HashSet<>();

		List<Integer> lh = myList.stream().filter(n -> !set.add(n)).collect(Collectors.toList());

		System.out.println(lh.get(1));

		int max = myList.stream().max(Integer::compare).get();

		int dd = myList.stream().reduce(0, (x, y) -> (x + y));

		System.out.println(dd);

		List<String> myLists = Arrays.asList("Narendar", "Narendar", "Rahul");

		Set<String> ss = new HashSet<>();

		myLists.stream().filter(x -> ss.add(x))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		myLists.forEach(x -> {
			System.out.print(x);
		});

	}
}
