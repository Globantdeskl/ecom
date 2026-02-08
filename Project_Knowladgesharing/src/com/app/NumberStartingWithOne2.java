package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberStartingWithOne2 {
	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
            myList.stream()
                  .map(s -> String.valueOf(s)) // Convert integer to String
                  .filter(s -> s.startsWith("1"))
                  .forEach(System.out::println);


	}
}
