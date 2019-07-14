package com.alg.rev.array;

public class BlubSwitcher {

	public static int switcher(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int nswitch = helper(i);
			if (nswitch % 2 == 1) {
				count++;
			}

		}

		return count;
	}

	private static int helper(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {

			if (n % i == 0) {
				count++;
			}

		}
		return count;
	}

	public static int missNumber(int[] num, int n) {
		int miss = 1;
		int count = 0;
		int i = 0;
		while (miss < n) {
			if (i < num.length && num[i] <= miss) {
				miss = num[i] + miss;
				i++;

			} else {
				miss = miss + miss;
				count++;
			}

		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(missNumber(new int[] { 1, 4, 10 }, 50));

	}

}
