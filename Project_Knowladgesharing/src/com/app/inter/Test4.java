package com.app.inter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class A {
	protected A() {
		System.out.println("In m1 A");
	}
}

class B extends A {

	public B() throws IndexOutOfBoundsException {
		m2();
		System.out.println("In m1 B");

	}

	void m2() throws IndexOutOfBoundsException {
		System.out.println("In m2 B");
	}
}

public class Test4 {

	static List<Employee> list = new ArrayList<>();

	public static void method(Object o) {
		System.out.println("Object method");
	}

	public static void method(String s) {
		System.out.println("String method");
	}

	public static void method(Integer s) {
		System.out.println("Integer method");
	}

//	public static void getDataA() {
//		list.add(new Employee("Naren", 23, 21.3, 1));
//		list.add(new Employee("charen", 29, 22.3, 2));
//		list.add(new Employee("charen", 20, 23.3, 8));
//
//		Optional<Employee> maxSalaryEmployee = list.stream()
//				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
//
//	}

	public static void getDataB() {
		list.add(new Employee("Naren", 23, 21.1, 1l));
		list.add(new Employee("charen", 29, 22.9, 2l));
		list.add(new Employee("charen", 20, 23.7, 8l));

		Set<Employee> maxSalaryEmployee = list.stream().sorted(Comparator.comparing(Employee::getAge))
				.collect(Collectors.toSet());
		maxSalaryEmployee.forEach(System.out::println);
	}

	public static void getDataA() {

		// random numbers
		int[] numbers = { 5, 9, 11, 2, 8, 21, 1 };

		// print to console
		System.out.println("Numbers in an Arrays : " + Arrays.toString(numbers));

		// sort in descending-order and get 2nd largest element
		int secondLargestNumber = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).limit(3).skip(2)
				.findFirst().get();
		
		System.out.println("Numbers in an Arrays : " +secondLargestNumber);
	}

	public static LinkedList<String> reverseLinkedList(LinkedList<String> llist) {

		LinkedList<String> revLinkedList = new LinkedList<String>();
		for (int i = llist.size() - 1; i >= 0; i--) {

			// Append the elements in reverse order
			revLinkedList.add(llist.get(i));
		}
		// Return the reversed arraylist
		return revLinkedList;
	}

	// Recursive function to reverse
	// the digits of number
	static int recursive_func(int n, int rev) {
		if (n < 10) {
			return rev * 10 + n;
		} else {
			int last_digit = n % 10;
			rev = rev * 10 + last_digit;
			return recursive_func(n / 10, rev);
		}
	}

	public long factorialUsingRecursion(int n) {
		if (n <= 2) {
			return n;
		}
		return n * factorialUsingRecursion(n - 1);
	}

	public long factorialUsingStreams(int n) {
		return LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
	}

	public static void recursive_funcreplace() {

		List<Integer> intList = Arrays.asList(1, 2, 3);
		String result = intList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("-", "{", "}"));

		System.out.println(result);

	}

	public static void reverseTheString() {

		Integer[] arr = { 1, 2, 3 };

		List<Integer> intList = Arrays.asList(arr);
		String result = intList.stream().map(n -> String.valueOf(n)).sorted(Comparator.reverseOrder())
				.collect(Collectors.joining(" "));

		System.out.println(result);
	}

	public static void reverseTheStringB() {

		// String[] arr = { "1", "2", "3" };
		String arr = "NAN";
		String str = "PANP";

		List<String> intList = Arrays.asList(arr);
		String result = intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));

		if (str.length() == result.length()) {

			if (str.contains(result)) {

				System.out.println("String is rotational");

			}

		}

		System.out.println(result);
	}

	public static int reverseTheInteger(int number) {

		int  reverse = 0;

		while (number != 0) {
			int last_digit = number % 10;
			reverse = reverse * 10 + last_digit;
			number = number / 10;
		}
		System.out.println("The reverse of the given number is: " + reverse);
		return reverse;
	}


	public static void main(String[] args) {

		// B bb = new B();
		int number = 987654;
		//System.out.println(reverseTheInteger(number));
		//recursive_funcreplace();
		getDataA();
	}

}
