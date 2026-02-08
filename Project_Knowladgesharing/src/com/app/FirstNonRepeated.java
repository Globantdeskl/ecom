package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeated {

	private static Map<String, Employees> map1 = new HashMap<>();
	private static Map<String, Employees> map2 = new HashMap<>();

	public static char kthNonRepeatingChar(String str, int k) {
		int count = 0;
		char result = '\0';
		for (int i = 0; i < str.length(); i++) {
			boolean repeating = false;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					repeating = true;
					break;
				}
			}
			if (!repeating) {
				count++;
				if (count == k) {
					result = str.charAt(i);
					break;
				}
			}
		}
		return result;
	}

	// First nonrepitable char Done
	public static void getNonRepetable(String s) {
		for (Character ch : s.toCharArray()) {
			if (s.indexOf(ch) != s.lastIndexOf(ch)) {
				System.out.println("First non repeat character = " + ch);
				break;
			}
		}

	}

	/*
	 * Done
	 */
	public static void getNonRepetableDigitCount(String inputStr) {

		Map<String, Long> collects = Arrays.stream(inputStr.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Set<String> ss = new LinkedHashSet();

		Object[] y = Arrays.stream(inputStr.split("")).filter(x -> !ss.add(x)).toArray();

		System.out.println(" collects :: " + y.length);
	}



	public static void getrepitable(String s) {

		// int count = 0;
		char chh = 0;
		char[] ch = s.toCharArray();
		boolean visited[] = new boolean[ch.length];
		Arrays.fill(visited, false);

		for (int i = 0; i < ch.length; i++) {
			// Skip this element if already processed
			if (visited[i] == true)
				continue;

			// Count frequency
			int count = 1;

			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					visited[j] = true;
					count++;
				}
			}

			if (count == 1) {
				System.out.println("{Repetable} " + ch[i]);
			} else {
				System.out.println(" [Non Repitable] " + ch[i]);
			}
		}

	}

	public static void main(String args[]) {

		// getListCOnvertToString("Narendar");

		getrepitable("narendar");

		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		List<Hosting> list2 = new ArrayList<>();
		list2.add(new Hosting(1, "liquidweb", 80000));
		list2.add(new Hosting(2, "linode", 90000));
		list2.add(new Hosting(3, "digitalocean", 120000));
		list2.add(new Hosting(4, "aws.amazon", 200000));
		list2.add(new Hosting(5, "mkyong", 1));

		List<List<Hosting>> ljk = new ArrayList<>();
		ljk.add(list);
		ljk.add(list2);
		ljk.stream().flatMap(Collection::stream).collect(Collectors.toList());
		ljk.forEach(System.out::print);

		Hosting strs = list.stream().findAny().get();

		System.out.println("Hosting 1 : " + strs);

		Hosting str1 = list.stream().reduce((x, y) -> y).get();
		System.out.println("Reduce Max : " + str1);

		Hosting str2 = list.stream().reduce((x, y) -> x).get();
		System.out.println("Reduce Min : " + str2.getName());

		// key = id, value - websites
		Map<Integer, String> result1 = list.stream()
				.collect(Collectors.toMap(Hosting::getId, Hosting::getName, (oldValue, newValue) -> newValue));

		System.out.println("Result 1 : " + result1);

		Map result = map2.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		FirstNonRepeated.getNonRepetable("teeter");

		Employees employee1 = new Employees("1", "Henry", 1234, 23);
		map1.put("1", employee1);
		Employees employee2 = new Employees("1", "Naren", 1234, 23);
		map1.put("2", employee2);
		Employees employee3 = new Employees("1", "Suren", 1234, 23);
		map1.put("3", employee3);
		Employees employee4 = new Employees("1", "Mahen", 1234, 23);
		map2.put("4", employee4);
		Employees employee5 = new Employees("1", "Rahul", 1234, 23);
		map2.put("5", employee5);

		Stream combined = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());

		combined.forEach(System.out::print);

//
//		////////////////////////
//		Map<String, Employees> resultd = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> new Employees(value2.get, value1.getEmpName())));
//
//		// result.entrySet().forEach(System.out::println);
//
//		Map<String, Employees> map3 = Stream.of(map1, map2).flatMap(map -> map.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//						(value1, value2) -> new Employees(value2.getAge(), value1.getEmpName())));
//
//		map3.entrySet().forEach(System.out::println);
//
//		// find First entry in HashMap
//		Entry<String, Employees> firstEntry = map3.entrySet().stream().findFirst().get();
//
//		String str = firstEntry.getValue().getEmpName();
//
//		System.out.print(":::::::::::::::::: " + str);
//
//		/////////////////////
//
//		String input = "Java articles are Awesome";
//		String st = Stream.of(input.split("")).distinct().collect(Collectors.joining(""));
//		char p = st.charAt((st.length() - 1) / 2);
//		// System.out.println(p);
//
//		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//
//		// myList.stream().sorted().forEach(System.out::println);
//
//		List<Integer> integerList = Arrays.asList(3, 4, 5, 6, 7, 4, 2, 3);
//		// integerList.stream().map(i -> i * i * i).filter(i -> i >
//		// 50).forEach(System.out::println);
//
//		Set<Integer> lists = new HashSet<>();
//
//		List<Integer> ls = integerList.stream().filter(x -> lists.add(x)).collect(Collectors.toList());

		/*
		 * myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::
		 * println);
		 * 
		 * myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::
		 * println);
		 * 
		 * List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		 * integerList.stream().map(i -> i * i * i).filter(i -> i >
		 * 50).forEach(System.out::println);
		 * 
		 * int arr[] = { 99, 55, 203, 99, 4, 91 }; Arrays.parallelSort(arr); // Sorted
		 * the Array using parallelSort()
		 * 
		 * Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		 * 
		 * // List<String> nameLst = //
		 * names.stream().map(String::toUpperCase).collect(Collectors.toList()); //
		 * System.out.println(nameLst);
		 * 
		 * List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		 * 
		 * Map<String, Long> namesCount = names.stream()
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 * System.out.println(namesCount);
		 * 
		 * // Map<String, Long> namesCount = names.stream().filter(x ->
		 * Collections.frequency(names, x) > 1) //
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 * // System.out.println(namesCount);
		 * 
		 * Arrays.stream(arr).max().getAsInt(); String s =
		 * "string data to count each character"; Map<String, Long> map =
		 * Arrays.stream(s.split("")).map(String::toLowerCase)
		 * .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new,
		 * Collectors.counting()));
		 * 
		 */

	}
}