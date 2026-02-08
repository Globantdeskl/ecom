package com.app.java.designpattern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void getDuplicateData() {

		// How to find duplicate numbers in an array if it contains a duplicate?
		// If we input an array with elements 1, 2, 2, 3, 4, 5 it would print the result
		// as 1,2,3,4,5.

		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5);
		Set<Integer> ss = new HashSet<>();
		Set st = list.stream().filter(x -> ss.add(x)).collect(Collectors.toSet());
		st.forEach(System.out::print);
	}

	public static void isOdd() {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5);
		list.stream().map(x -> x % 2 != 0).collect(Collectors.toList());
		list.forEach(System.out::print);
	}

	public static void main(String[] args) {

//		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//	    .filter(i -> i % 2 == 0)
//	    .skip(4)
//	    .forEach(i -> System.out.print(i + " "));
//		
//		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//	    .filter(i -> i % 2 == 0)
//	    .limit(2)
//	    .forEach(i -> System.out.print(i + " "));

		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		long count = strList.stream().filter(x -> x.isEmpty()).count();

		// Get count, min, max, sum, and average for numbers
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
		System.out.println("getCount of all prime numbers : " + stats.getCount());

		Integer min = Stream.of(1, 2, 3, 14, 5, 6, 7).max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("The Minimum number is: " + min);

		List<String> strdList = Arrays.asList("abc", "bcd", "defg", "jk");
		List<String> minn = Stream.of(strdList).max(Comparator.comparing(String::valueOf)).get();
		minn.forEach(i -> System.out.print(i + " @@@@@@@@@  "));

		List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> integerList2 = Arrays.asList(5, 6, 7);
		Stream<Integer> concatStream = Stream.concat(integerList1.stream(), integerList2.stream());
		concatStream.forEach(System.out::print);

	}

}

/*
 * implement a singleton class and to make it threadsafe
 * 
 * 
 * 
 * 
 * 
 * Remove unwanted chars Given an array [“123f”, “1dsa12”, “1212ds”, “65fd”,
 * “sadfa”, “asdasd”] Each item can contain 0-9, a-z, A-Z where a-z, A-Z
 * characters are unwanted Sum of all the numbers after removing all the
 * unwanted characters 123+112+1212+65
 * 
 */