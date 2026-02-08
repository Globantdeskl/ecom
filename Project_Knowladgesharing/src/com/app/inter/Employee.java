package com.app.inter;

import java.util.Comparator;

public class Employee implements Cloneable {

	private String name;
	private Integer age;
	private Double salary;
	private Long mobile;

	Employee(String name, Integer age, Double salary, Long mobile) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.mobile = mobile;
	}

	Comparator<Employee> byName = Comparator.comparing(Employee::getName).reversed();
	Comparator<Employee> byAge = Comparator.comparing(Employee::getAge);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee clone = null;
		try {
			clone = (Employee) super.clone();
			clone.setAge(this.getAge());
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		return clone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", mobile=" + mobile + ", getName()="
				+ getName() + ", getAge()=" + getAge() + ", getSalary()=" + getSalary() + ", getMobile()=" + getMobile()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
