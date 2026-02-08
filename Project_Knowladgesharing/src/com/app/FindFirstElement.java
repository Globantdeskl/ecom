package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindFirstElement {

	public static void getNonRepetable(String inputStr) {

		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First repeating character is: " + i);
				break;
			}
		}

	}

	public static void getNonRepetable(Integer inputStr) {

		for (char i : ("" + inputStr).toCharArray()) {

			if (String.valueOf(inputStr).indexOf(i) != String.valueOf(inputStr).lastIndexOf(i)) {
				System.out.println("First repeating character is: " + i);
				break;
			}

		}

	}

	public static void getData() {

		// Map<String, Employees> list = new HashMap<>();

		List<Employees> list = new ArrayList<>();
		Employees employee1 = new Employees("1", "Henry", 1234, 23);
		list.add(employee1);
		Employees employee2 = new Employees("2", "Naren", 1237, 28);
		list.add(employee2);
		Employees employee3 = new Employees("3", "Suren", 1230, 26);
		list.add(employee3);
		Employees employee4 = new Employees("4", "Mahen", 1235, 22);
		list.add(employee4);

		List<String> employeeNames = list.stream()
				.collect(Collectors.mapping(Employees::getEmpName, Collectors.toList()));
		System.out.println("List of employee names:" + employeeNames);

	}

	static int multiply() {
		int pro = 1;
		Integer arr[] = { 11, 54, 23, 32, 15, 24, 31, 12, 11 };
		for (int i = 0; i < arr.length; i++)
			pro = pro * arr[i];
		return pro;
	}

	public static void main(String args[]) {

		// getNonRepetable(12314);
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		Integer arr[] = { 11, 54, 23, 32, 15, 24, 31, 12, 11 };

		for (int i = 0; i < arr.length; i++) {
			int value = arr[i] * arr[i];
			System.out.println("Original Array: [    " + value);
		}

		System.out.print("Original Array: [");

		Arrays.sort(arr);
		Optional<Integer> h = Arrays.stream(arr).skip(2).limit(3).findFirst();
		System.out.print("Original Array: [A" + h.get());

		int ys = Arrays.stream(arr).reduce(0, (x, y) -> Integer.max(x, y));

		System.out.print("  Original Array: [B " + ys);

	}

}
