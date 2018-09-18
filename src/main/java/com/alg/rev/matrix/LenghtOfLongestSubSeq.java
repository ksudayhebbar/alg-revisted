package com.alg.rev.matrix;

import java.util.Arrays;

public class LenghtOfLongestSubSeq {

	public static int lenOFLongestSubSeq(int num[]) {

		int result = 0;
		int max[] = new int[num.length];

		Arrays.fill(max, 1);

		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					max[i] = Math.max(num[i], num[j] + 1);
				}

			}

			result = Math.max(result, num[i]);

		}
		return result;

	}

	public static void main(String[] args) {
		// System.out.println(lenOFLongestSubSeq(new int[] {10, 9, 2, 5, 3, 7, 101,
		// 18}));
		// System.out.println(lenOFLongestSubSeq(new int[] {10, 9, 2, 5, 3, 7, 101,
		// 18}));

	System.out.println((1<<1)&2);
	}

}
