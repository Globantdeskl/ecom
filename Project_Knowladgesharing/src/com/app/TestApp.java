package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestApp {

	static class Employee {

		public Employee(String empId, String empName, int salary, int age) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
			this.age = age;
		}

		public String empId;
		public String empName;
		public int salary;
		public int age;

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", age=" + age + "]";
		}

	}

	public static void printEmployeeName(Map<String, Employee> empMap, String ageLimit) {
		// Print all employee's name whose age is greater than ageLimit(second parameter
		empMap.entrySet().stream().filter(x -> x.getValue().age > Integer.valueOf(ageLimit)).forEach(System.out::print);
	}

	public static void printEmployeeName(List<Employee> employeeList) {

		Optional<Employee> emp = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.skip(2).findFirst();

//		System.out.println(emp.get());

		List<Employee> ls = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.collect(Collectors.toList());

		Optional<com.app.TestApp.Employee> rt = ls.stream().skip(2).findFirst();
//		System.out.println(rt.get());

		Optional<com.app.TestApp.Employee> rtt = ls.stream().skip(2).findFirst();

		List lss = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		Optional<com.app.TestApp.Employee> rtyt = ls.stream().skip(2).findFirst();
//		 System.out.println(rtyt.get());



		
		
		// System.out.println(rrtt.get());

		List<com.app.TestApp.Employee> lm = employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName))
				.collect(Collectors.toList());

		IntSummaryStatistics ol = lm.stream().collect(Collectors.summarizingInt(Employee::getSalary));
		// System.out.println(ol.getMin());

		employeeList.stream().filter(x -> !x.getEmpName().isEmpty()).collect(Collectors.toList());

		Map<String, String> replacements = Map.of("agent", "manager", "manager", "agent");
		List<String> cs = Arrays.asList("agent", "manager", "admin");

		List<String> replace = cs.stream().map(p -> replacements.getOrDefault(p, p)).collect(Collectors.toList());
		replace.forEach(x -> {
			// System.out.print(" "+ x);
		});

		// Replace the Tring
		List<String> replaces = cs.stream().collect(Collectors.toList());
		replaces.replaceAll(s -> {
			if (s.equals("manager")) {
				return "agent";
			}
			if (s.equals("agent")) {
				return "manager";
			}
			return s;
		});

		System.out.print(" " + replaces);

		List<String> replacement = cs.stream()
				.map(p -> p.equals("agent") ? "manager" : p.equals("manager") ? "agent" : p)
				.collect(Collectors.toList());

		cs.replaceAll(s -> s.replaceAll("agent|manager", replace(s)));

	}

	static String replace(String s) {
		return s.equals("manager") ? "agent" : s.equals("agent") ? "manager" : s;
	}
	
	
	
	
	
	

	public static void main(String... strings) {

		// Created 4 Employee Objects
		Employee e1 = new Employee("e1", "Amar", 10000, 25);
		Employee e2 = new Employee("e2", "Akbar", 1050, 27);
		Employee e3 = new Employee("e3", "Anthony", 11000, 23);
		Employee e4 = new Employee("e4", "Geeta", 12000, 26);

		// Populate employee Object in map.
		Map<String, Employee> empMap = new HashMap<String, Employee>();
		empMap.put("e1", Employee("e1", "Amar", 1000.0, 25));
		empMap.put("e2", Employee("e2", "Akbar", 1050.0, 27));
		empMap.put("e3", Employee("e3", "Anthony", 1100.0, 23));
		empMap.put("e4", Employee("e4", "Geeta", 1200.0, 26));

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		printEmployeeName(list);
	}

	private static Employee Employee(String string, String string2, double d, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}