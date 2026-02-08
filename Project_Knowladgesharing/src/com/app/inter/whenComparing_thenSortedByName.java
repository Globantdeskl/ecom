package com.app.inter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class whenComparing_thenSortedByName {

	public static int LongestSubsequence(int a[], int n) {
		int ans = 0;
		// Traverse every element to check if any
		// increasing subsequence starts from this index
		for (int i = 0; i < n; i++) {
			// Initialize cnt variable as 1, which defines
			// the current length of the increasing subsequence
			int cnt = 1;
			for (int j = i + 1; j < n; j++)
				if (a[j] == (a[i] + cnt))
					cnt++;
			// Update the answer if the current length is
			// greater than already found length
			if (cnt > ans)
				ans = cnt;
		}

		return ans;
	}
	
	
	 for (int index = 0; index < n; index++) {
         if (outofplace >= 0) {
             // find the item which must be moved into
             // the out-of-place entry if out-of-place
             // entry is positive and current entry is
             // negative OR if out-of-place entry is
             // negative and current entry is negative
             // then right rotate
             //
             // [...-3, -4, -5, 6...] -->   [...6, -3,
             // -4, -5...]
             //      ^                          ^
             //      |                          |
             //     outofplace      -->      outofplace
             //
             if (((arr[index] >= 0)
                  && (arr[outofplace] < 0))
                 || ((arr[index] < 0)
                     && (arr[outofplace] >= 0))) {
                 rightrotate(arr, n, outofplace, index);

                 // the new out-of-place entry is now 2
                 // steps ahead
                 if (index - outofplace >= 2)
                     outofplace = outofplace + 2;
                 else
                     outofplace = -1;
             }
         }

         // if no entry has been flagged out-of-place
         if (outofplace == -1) {
             // check if current entry is out-of-place
             if (((arr[index] >= 0)
                  && ((index & 0x01) == 0))
                 || ((arr[index] < 0)
                     && (index & 0x01) == 1))
                 outofplace = index;
         }
     }
 }

	public static Boolean areDistinct(String str, int i, int j) {

// Note : Default values in visited are false
		boolean[] visited = new boolean[256];

		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k)] == true)
				return false;

			visited[str.charAt(k)] = true;
		}
		return true;
	}

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Narendar", 23, 78.9, 8));
		list.add(new Employee("Sindamika", 25, 73.9, 12));
		list.add(new Employee("Anamika Singh Shekhawat", 26, 73.9, 13));

		Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);

		Comparator<Employee> employeeNameComparaotor = Comparator.comparing(Employee::getName, (s1, s2) -> {
			return s2.compareTo(s1);
		});

		int[] a = { 3, 10, 3, 11, 4, 5, 6, 7, 8, 12 };
		int n = a.length;
		System.out.println(LongestSubsequence(a, n));

	}

}
