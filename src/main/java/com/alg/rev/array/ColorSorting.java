package com.alg.rev.array;

import java.util.HashMap;
import java.util.Map;

public class ColorSorting {
	public static void sortColors(int[] nums) {

		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		for (int n : nums) {

			counter.put(n, counter.getOrDefault(n, 0) + 1);

		}

		int count = 0;

		for (int i = 0; i < nums.length;) {

			if (counter.get(count) != null) {

				int color = counter.get(count);
				while (color > 0) {
					nums[i++] = count;
					color--;
				}
			}
			count++;

		}

	}

	public static void main(String[] args) {

		sortColors(new int[] { 2, 0, 2, 1, 0, 1 });

	}

}
