package com.alg.rev.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PerfactSquare {

	public static int perfactSquare(int n) {

		int[] dp = new int[n + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < Math.sqrt(n); j++) {

				if (j * j == i) {

					dp[i] = 1;

				} else if (i > (j * j)) {

					dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
				}
			}

		}

		return dp[n];

	}

	public static void main(String[] args) {
		System.out.println(perfactSquare(13));

	}

}
