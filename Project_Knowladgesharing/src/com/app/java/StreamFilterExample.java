package com.app.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamFilterExample {
	public static void main(String[] args) {
		// create a stream of strings
		Stream<String> myStream = Stream.of("Like", "and", "Share", "https://www.geeksforgeeks.org/");

		// only string starting with "http://" will be
		// considered for next API(forEach)
		myStream.filter(x -> x.startsWith("https://")).forEach(System.out::println);

		///////////////////////////

		// Converting String array to stream
		String[] arr = { "Geeks", "for", "Geeks" };

		// Using Arrays.stream to convert an
		// array into Stream
		Stream<String> stm = Arrays.stream(arr);

		// Displaying elements in Stream
		stm.forEach(str -> System.out.print(str + " "));

		// 2. Integer Stream with skip
		System.out.println("Integer Stream with skip : ");
		IntStream.range(0, 10).skip(5).forEach(x -> System.out.println(x));

		var unmodifiableList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

		System.out.println(unmodifiableList);

		// Operations like this will result in an exception
		unmodifiableList.add(12);

		// Creating List class object of integer type
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toUnmodifiableList()).forEach(System.out::print);
		
		String country = "Brazil";
		char firstChar = country.charAt(0);
		System.out.println(firstChar);
		

	}
}
