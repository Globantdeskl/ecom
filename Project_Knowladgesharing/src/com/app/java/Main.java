package com.app.java;

public class Main {

	public static void compare(Object ob1, Object ob2) 
	{
		
		if (ob1 == ob2) 
		{
			System.out.println("Shallow Copy!");
		} 
		else 
		{
			System.out.println("Deep Copy!");
		}
		
	}

	public static void main(String[] args) {

		Student clone = null;

		Student student = new Student("Jon Snow", 22);

		try {

			clone = (Student) student.clone();
			System.out.println("Cloned Object: " + clone + '\n');

		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}

//		compare(student.getSubjects(), clone.getSubjects());
//		compare(student.getMap(), clone.getMap());
//
//		// any change made to the clone's map will reflect on the student's map
//		clone.getMap().put("John Cena", 40);
//		System.out.println(student.getMap());
	}

}
