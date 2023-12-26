package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

final class Employee {

	private final String empName;
	private final int age;
	private final Address address;

	public Employee(String name, int age, Address address) {
		this.empName = name;
		this.age = age;
		this.address = address;
	}

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", age=" + age + ", address=" + address + "]";
	}

}

class Address implements Cloneable {

	public String addressType;
	public String address;
	public String city;

	public Address(String addressType, String address, String city) {
		super();
		this.addressType = addressType;
		this.address = address;
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Address Type - " + addressType + ", address - " + address + ", city - " + city;
	}
}

public class AA {

	public static void main(String[] args) throws Exception {

		List<Employee> emp1 = new ArrayList<>();
		emp1.add(new Employee("Narendar", 34, new Address("Home", "Kernatak", "Hyderabad")));
		emp1.add(new Employee("Narendar", 34, new Address("Home", "Kernatak", "Hyderabad")));
		emp1.add(new Employee("Adithya", 34, new Address("Home", "Raj", "Jaipur")));
		emp1.add(new Employee("Anamika", 34, new Address("Home", "Raj", "Jodhpur")));
		emp1.add(new Employee("ManSingh", 34, new Address("Home", "MP", "Jabalpur")));

//		Map<Employee, Long> result = emp1.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		System.out.println(result);

		Map<String, Long> counting = emp1.stream()
				.collect(Collectors.groupingBy(Employee::getEmpName, Collectors.counting()));
		
		System.out.println(counting);
		
		Map<String, Integer> sum = emp1.stream().collect(
                Collectors.groupingBy(Employee::getEmpName, Collectors.summingInt(Employee::getAge)));

        System.out.println(sum);
		

		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);

	}

}
