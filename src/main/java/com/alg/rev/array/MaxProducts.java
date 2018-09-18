package com.alg.rev.array;

public class MaxProducts {

	public static int maxProducts(int num[]) {

		int[] max = new int[num.length];
		int[] min = new int[num.length];
		max[0] = min[0] = num[0];
		int result = 0;

		for (int i = 1; i < num.length; i++) {

			if (num[i] > 0) {
				max[i] = Math.max(num[i], num[i] * max[i - 1]);
				min[i] = Math.min(num[i], num[i] * min[i - 1]);

			} else {
				max[i] = Math.max(num[i], num[i] * min[i - 1]);
				min[i] = Math.min(num[i], num[i] * max[i - 1]);
			}

			result = Math.max(result, max[i]);

		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(maxProducts(new int[] { 2, 3, -2, 4 }));
	}
}
