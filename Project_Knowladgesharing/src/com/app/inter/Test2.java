package com.app.inter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {

	static void reverse(int a[], int n) {

		int[] b = new int[n];
		int j = n;
		for (int i = 0; i < n; i++) {
			b[j - 1] = a[i];
			j = j - 1;
		}

		System.out.println("Reversed array is: \n");
		for (int k = 0; k < n; k++) {
			System.out.println(b[k]);
		}
	}

	static int getMin(int arr[], int n) {
		int res = arr[0];
		for (int i = 1; i < n; i++)
			res = Math.min(res, arr[i]);
		return res;
	}

	static int getMax(int arr[], int n) {
		int res = arr[0];
		for (int i = 1; i < n; i++)
			res = Integer.max(res, arr[i]);
		return res;
	}

	void selectionSort(int arr[], int n) {
		int i, j, min_idx;
		int temp = 0;
		for (i = 0; i < n - 1; i++) {
			// Find the minimum element in
			// unsorted array
			min_idx = i;
			for (j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// swap elements
			temp = arr[j - 1];
			arr[j - 1] = arr[j];
			arr[j] = temp;
		}
	}

	// Should be use Liner Search
	static int countOccurrences(int arr[], int x) {
		int res = 0;
		for (int i = 0; i < arr.length; i++)
			if (x == arr[i])
				res++;
		return res;
	}

	static int countOccurrencesString(String arr[], String x) {
		int res = 0;
		for (int i = 0; i < arr.length; i++)
			if (x == arr[i])
				res++;
		return res;
	}

	static int count(int[] nums, int mid) {
		// function to calculate number of elements less
		// than equal to mid
		int cnt = 0;

		for (int i = 0; i < nums.length; i++)
			if (nums[i] <= mid)
				cnt++;

		return cnt;
	}

	static int kthSmallest(int[] nums, int k) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			low = Math.min(low, nums[i]);
			high = Math.max(high, nums[i]);
		}

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (count(nums, mid) < k)
				low = mid + 1;

			else
				high = mid;
		}

		return low;
	}

	public static void main(String[] args) {
		
		
			int[] A = { 6, 8, 13, 5, 1, 9 };
		
			int max = Arrays.stream(A).max().getAsInt();
			 Arrays.stream(A).sorted().findFirst().getAsInt();
			 
			 Collections.reverse(Arrays.asList(A)); 
			 
			 
			System.out.println(">>--------> "+A);
		  String sentence = "alex brian charles alex charles david eric david";
		  List<String> wordsList =  Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
		  Map wordsMapWithCount = wordsList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//		  System.out.println(">>--------> "+wordsMapWithCount);
		
		int[] arr = { 10, 2, 30, 40, 10 };
		int n = arr.length;
		System.out.println("Minimum element of array: " + getMin(arr, n));
		System.out.println("Maximum element of array: " + getMax(arr, n));

		int v = Arrays.stream(arr).reduce(0, (x, y) -> Math.max(x, y));
		System.out.println(v);

		// Find Repeting String
		String as = "Maximum of element of array: ";

		// Arrays.stream(as.split(" ")).

		Map map = Arrays.stream(as.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		/*
		 * map.forEach((k, y) -> { System.out.println(k + " : " + y); });
		 */

		Map ma = Arrays.stream(as.split(" ")).filter(x -> new HashSet().add(x)).collect(Collectors.groupingBy(x -> x));
		ma.forEach((k, y) -> {
			System.out.println(k + " : " + y);
		});
		
	}

}
