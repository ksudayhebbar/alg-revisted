package com.alg.rev.matrix;

import java.util.Arrays;

public class LenghtOfLongestSubSeq {

	public static int lenOFLongestSubSeq(int num[]) {

		int result = 0;
		int max[] = new int[num.length];

		Arrays.fill(max, 0);
		max[0] = 1;
		for (int i = 1; i < num.length; i++) {

			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					max[i] = Math.max(max[i], max[j]);
				}

			}
			max[i] = max[i] + 1;
			result = Math.max(result, max[i]);

		}
		return result;

	}

	public static void main(String[] args) {
		//System.out.println(findNumberOfLIS(new int[] { 1,3,5,4,7 }));
		System.out.println(lenOFLongestSubSeq(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));

		// System.out.println((1<<1)&2);
		
		
	}

	public static int findNumberOfLIS(int[] nums) {
		int N = nums.length;
		if (N <= 1)
			return N;
		int[] lengths = new int[N]; // lengths[i] = length of longest ending in nums[i]
		int[] counts = new int[N]; // count[i] = number of longest ending in nums[i]
		Arrays.fill(counts, 1);

		for (int j = 1; j < N; ++j) {
			for (int i = 0; i < j; ++i)
				if (nums[i] < nums[j]) {
					if (lengths[i] >= lengths[j]) {
						lengths[j] = lengths[i] + 1;
						counts[j] = counts[i];
					} else if (lengths[i] + 1 == lengths[j]) {
						counts[j] += counts[i];
					}
				}
		}

		int longest = 0, ans = 0;
		for (int length : lengths) {
			longest = Math.max(longest, length);
		}
		for (int i = 0; i < N; ++i) {
			if (lengths[i] == longest) {
				ans += counts[i];
			}
		}
		return ans;
	}
}
