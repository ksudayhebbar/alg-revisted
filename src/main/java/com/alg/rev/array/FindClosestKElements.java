package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindClosestKElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> ret = new ArrayList<Integer>();
		List<Integer> nums = new ArrayList<Integer>();
		for (int n : arr) {

			nums.add(n);
		}

		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer f, Integer s) {
				return Math.abs(f - x) - Math.abs(s - x);
			}
		});

		for (int i = 0; i < k; i++) {
			ret.add(nums.get(i));

		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
