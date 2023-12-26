package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReversetheString {

	public static String reverse(String string) {
		return Stream.of(string).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
	}

	public static String rotation(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return "String is not rotational";
		}

		Arrays.sort(s1.toCharArray());
		Arrays.sort(s2.toCharArray());

		if (s1.equals(s2)) {

			return "String is  rotational";
		}

		return "String is not rotational";
	}

	public static Boolean isAnagram(String word1, String word2) {
		List<String> listWord1 = new ArrayList<>(Arrays.asList(word1.split("")));
		List<String> listWord2 = new ArrayList<>(Arrays.asList(word2.split("")));

		Collections.sort(listWord1);
		Collections.sort(listWord2);

		word1 = String.join("", listWord1);
		word2 = String.join("", listWord2);

		System.out.println("word1 : " + word1);

		System.out.println("word2 : " + word2);

		// return listWord1.equals(listWord2);
		return word1.equals(word2);
		// return word1 == word2 ; // not working because == tests for reference
		// equality
	}

	public static void main(String[] args) {

		System.out.println(isAnagram("face", "cafe"));
		System.out.println(isAnagram("face", "caffe"));

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

		int summ = Arrays.stream(numbers).reduce(0, Integer::sum);

		int max1 = Arrays.stream(numbers).reduce(0, Integer::max);

		int min1 = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);

		System.out.println("sum : " + sum); // 55

		System.out.println("sum : " + summ); // 55

		System.out.println("max1 : " + max1); // 55

		System.out.println("min1 : " + min1); // 55

		int mmm = Arrays.stream(numbers).reduce(0, Integer::min);

		System.out.println("System.out.println(\"min1 : \" + min1); // 55 : " + mmm); // 55

		///////////////////////////////////////

		String[] ip = { "kjkj", "dssd", "pop" };

		List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 1. find Smallest number in List using min(Integer::compare).get()
		int min11 = numberss.stream().min(Integer::compare).get();

		// 3. find Smallest number in an Arrays using reduce((x, y) -> x < y ? x :
		// y).getAsInt()
		int min3 = Arrays.stream(numbers).reduce((x, y) -> x < y ? x : y).getAsInt();
		System.out.println("\nSmallest number using " + "reduce((x, y) -> x < y ? x : y).getAsInt() is = " + min3);

		String ss = "Narendar";

		String valueIs = Stream.of(ss.split("")).distinct().collect(Collectors.joining());

		System.out.println(valueIs);

		System.out.println(valueIs.charAt(1));

		// System.out.println(Stream.of(ss.split("")).count());

		Set<String> set = new HashSet<>();

		StringBuilder ds = new StringBuilder();

		String reversed = new StringBuilder(ss).reverse().toString();

		String rev1 = Stream.of(ss).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));

		System.out.println(reverse(ss));

	//	System.out.print(rotation("NANC", "NANB"));

		// String is rotational

	}

}
