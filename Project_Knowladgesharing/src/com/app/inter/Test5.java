package com.app.inter;

import java.util.HashSet;

public class Test5 {

	public static void findCommon(int a[], int b[], int c[], int n1, int n2, int n3) {
		// three sets to maintain frequency of elements
		HashSet<Integer> uset = new HashSet<>();
		HashSet<Integer> uset2 = new HashSet<>();
		HashSet<Integer> uset3 = new HashSet<>();
		
		for (int i = 0; i < n1; i++) {
			uset.add(a[i]);
		}
		
		for (int i = 0; i < n2; i++) {
			uset2.add(b[i]);
		}
		
		// checking if elements of 3rd array are present in
		// first 2 sets
		for (int i = 0; i < n3; i++) {
			if (uset.contains(c[i]) && uset2.contains(c[i])) {
				// using a 3rd set to prevent duplicates
				if (uset3.contains(c[i]) == false)
					System.out.print(c[i] + " ");
				uset3.add(c[i]);
			}
		}
	}

	
	
	public 
	
	
	
	
	public static void main(String[] args) {

	}

}
