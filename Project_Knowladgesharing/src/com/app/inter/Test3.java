package com.app.inter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test3 {

	public static void voidfindDuplicateBySetAdd() {

		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
		Map map = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.print(map);
		
		String str = "I am a java developer and I am proud of it " ;
		Set<String> itemsa = new HashSet<>();
		Map map1 = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		//System.out.print(map1);
		
	}
	
	
	public static void voidfindDuplicateBySetAddString() {

		List<String> list = Arrays.asList("mango", "eango", "mango", "pango", "mango", "kango", "rango", "myango");
		list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).forEach((x, y) -> {
			
			System.out.println(x + " <::> " + y);
			
		});;

	}
	

	public static void main(String[] args) {
		
		
		voidfindDuplicateBySetAddString();

	}

}