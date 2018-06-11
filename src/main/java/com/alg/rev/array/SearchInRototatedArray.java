package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SearchInRototatedArray {

	public int search(int a[], int target, int left, int right) {

		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;

		if (a[mid] == target) {
			return a[mid];

		}
		if (a[left] == target) {
			return a[left];

		}
		if (a[right] == target) {
			return a[right];

		}

		if (a[left] <= a[mid]) {

			if (a[left] <= target && a[mid] < target) {
				return search(a, target, left, mid - 1);
			} else {

				return search(a, target, mid + 1, right);
			}

		} else {
			if (a[right] <= target && a[mid] < target) {
				return search(a, target, mid + 1, right);
			} else {
				return search(a, target, left, mid - 1);
			}

		}

	}

	public int searchInRotatedArray(int a[], int traget) {

		return search(a, traget, 0, a.length - 1);

	}

	public static void main(String[] args) {

		Random random = new Random();
		List<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int nextInt = random.nextInt(10);
			num.add(nextInt);
		}

		System.out.println("Number generated " + num);

		Collections.sort(num);

		System.out.println("Sorted " + num);

		Collections.rotate(num, 1);

		System.out.println("Rotated " + num);
		int[] arr = new int[num.size()];

		for (int i = 0; i < 10; i++) {
			arr[i] = num.get(i);
		}
		System.out.println(new SearchInRototatedArray().searchInRotatedArray(arr, 5));

	}

}
