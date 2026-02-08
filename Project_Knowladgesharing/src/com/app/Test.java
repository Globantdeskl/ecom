package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Test {

	/**
	 * Input: array[]= {5, 10, 20, 15} Output: 20 Explanation: The element 20 has
	 * neighbors 10 and 15, both of them are less than 20.
	 */

	static int findPeak(int arr[], int n) {
		// First or last element is peak element
		if (n == 1)
			return 0;
		if (arr[0] >= arr[1])
			return 0;
		if (arr[n - 1] >= arr[n - 2])
			return n - 1;
		// Check for every other element
		for (int i = 1; i < n - 1; i++) {
			// Check if the neighbors are smaller
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
				return i;
		}
		return 0;
	}

	// Function to return K'th smallest
	// element in a given array
	// Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
	// Output: 7
	public static int kthSmallest(Integer[] arr, int K) {
		// Sort the given array
		Arrays.sort(arr);
		// Return K'th element in
		// the sorted array
		return arr[K - 1];
	}


	public static ArrayList<Integer> Unionarray(int arr1[], int arr2[]) {

		TreeSet<Integer> set = new TreeSet<>();

		// Remove the duplicates from arr1[]
		for (int i : arr1)
			set.add(i);

		// Remove duplicates from arr2[]
		for (int i : arr2)
			set.add(i);

		// Loading set to array list
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : set)
			list.add(i);

		return list;
	}

	/*
	 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33 Output: Sum found between
	 * indexes 2 and 4 Explanation: Sum of elements between indices 2 and 4 is 20 +
	 * 3 + 10 = 33
	 * 
	 */

	void subArraySum(int arr[], int n, int sum) {
		// Pick a starting point
		for (int i = 0; i < n; i++) {
			int currentSum = arr[i];

			if (currentSum == sum) {
				System.out.println("Sum found at indexe " + i);
				return;
			} else {
				// Try all subarrays starting with 'i'
				for (int j = i + 1; j < n; j++) {
					currentSum += arr[j];

					if (currentSum == sum) {
						System.out.println("Sum found between indexes " + i + " and " + j);
						return;
					}
				}
			}
		}
		System.out.println("No subarray found");
		return;
	}

	// Largest Sum
	// Contiguous Subarray (Kadane’s Algorithm)

	static void maxSubArraySum(int a[], int size) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
	}

	// Mover negative no in one side DONE

	public static void move(Integer[] arr) {

		Arrays.sort(arr);

		// Sorting as 1 to 3 only

		Arrays.sort(arr, 1, 2);

		Arrays.sort(arr, Collections.reverseOrder());
		System.out.print(Arrays.toString(arr));
	}

	/**
	 * 
	 * @param arr1
	 * @param arr2
	 * @param arr3
	 */
	public static void commonElements(int arr1[], int arr2[], int arr3[]) {

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				for (int k = 0; k < arr3.length; k++) {

					if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
						System.out.println(arr1[i]);
					}
				}
			}
		}
	}
	/*
	 * Input: {4, 2, -3, 1, 6} Output: true Explanation: There is a subarray with
	 * zero sum from index 1 to 3.
	 * 
	 */

	public static boolean subArrayExists(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int sum = arr[i];
			if (sum == 0)
				return true;
			for (int j = i + 1; j < n; j++) {
				sum += arr[j];
				if (sum == 0)
					return true;
			}
		}
		return false;
	}

	//Global logic interview
	public static void getValues() {
		int arr[] = { 1, 3, 4, 7, 10 }, x = 15;
		int arrr[] = {};
		int r = 0;
		for (int i = 1; i < arr.length; i++) { // if i 1 as row
			for (int j = 1; j < arr.length; j++) { // i is iterating with j and adding (i, j)
				r = i + j;
				arrr[i] = r;
				Arrays.sort(arrr);
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 20, 4, 1, 0 };
		int n = arr.length;
		System.out.print("Index of a peak point is " + findPeak(arr, n));

		Integer arrr[] = new Integer[] { 12, 3, 5, 7, 19 };
		int K = 2;

		// Function call
		System.out.print("K'th smallest element is " + kthSmallest(arrr, K));

		//
		Integer arrd[] = new Integer[] { 12, -3, 5, 7, -19 };
		move(arrd);

		// Common element
		int arr1[] = { 1, 5, 10, 20, 40, 80 };
		int arr2[] = { 6, 7, 20, 80, 100 };
		int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		commonElements(arr1, arr2, arr3);
		
		
		
		

	}

}
