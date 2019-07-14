package com.alg.rev.array;

import java.util.Arrays;
import java.util.Comparator;

public class GenLargestNumber {

	public static String largestNumber(int nums[]) {

		if (nums == null || nums.length == 0)
			return "";

		String strNums[] = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {

			strNums[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(strNums, new Comparator<String>() {

			public int compare(String a, String b) {
				System.out.println("Compreing :" + b + a + " -->" + a + b);
				return (b + a).compareTo(a + b);
			}

		});

		StringBuffer result = new StringBuffer();

		for (String oneValue : strNums) {

			result.append(oneValue);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34 };
		System.out.println(GenLargestNumber.largestNumber(nums));

	}

}
