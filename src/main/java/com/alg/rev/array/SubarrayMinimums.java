package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SubarrayMinimums {
	int sum = 0;

	public int sumSubarrayMins(int[] A) {

		for (int i = 0; i < A.length; i++) {
			int min = A[i];
			for (int j = i; j < A.length; j++) {
				min = Math.min(min, A[j]);
			}
			System.out.print(min);
			sum += min;
		}
		System.err.println(sum);
		/*
		 * LinkedList<Integer> cur = new LinkedList<Integer>(); helper(A, 0, cur);
		 * System.err.println(sum);
		 */
		return sum;
	}

	public static void main(String[] args) {
		/*
		 * SubarrayMinimums s = new SubarrayMinimums(); s.sumSubarrayMins(new int[] { 3,
		 * 1, 2, 4 });
		 */

		System.out.println(intersect(new int[] { 1, 2, 3, 4, 5 }, new int[] { 0, 3, 4, 6 }));
	}

	public static List<Integer> intersect(int[] listA, int[] listB) {
		List<Integer> ans = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < listA.length;) {
			if (listA[i] != listB[j]) {
				ans.add(listA[i]);
				i++;

			} else if (listA[i] != listB[j]) {
				i++;
				j++;

			} else if (listA[i] > listB[j]) {
				j++;
			} else if (listA[i] < listB[j]) {
				i++;
			}

		}

		return ans;
	}
}
