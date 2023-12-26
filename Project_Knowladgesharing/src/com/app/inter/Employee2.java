package com.app.inter;

final public class Employee2 implements Cloneable {

	private final String name;
	private final Integer age;
	private final Double salary;
	private final Long mobile;

	public Employee2(String name, Integer age, Double salary, Long mobile) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.mobile = mobile;
		Employee clone = new Employee();
		clone.setAge(this.age);
		clone.setName(this.name);
		clone.setSalary(this.salary);
		clone.setMobile(this.mobile);
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Double getSalary() {
		return salary;
	}

	public Long getMobile() {
		return mobile;
	}

}
