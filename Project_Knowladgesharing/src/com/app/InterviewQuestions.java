package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQuestions {

	public static void getString() {
		List<String> stringList = Arrays.asList("Hello", "Interview", "Questions", "Answers", "Ram", "for");
		long count = stringList.stream().filter(str -> str.length() > 3).count();
		System.out.println("String count with greater than 3 digit : " + count);

	}

	public static void main(String[] args) {

		getString();
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		System.out.println(integerList.stream().map(x -> x * 3).collect(Collectors.toList()));

		List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> integerList2 = Arrays.asList(5, 6, 7);
		Stream<Integer> concatStream = Stream.concat(integerList1.stream(), integerList2.stream());
		concatStream.forEach(System.out::print);

	}

}
