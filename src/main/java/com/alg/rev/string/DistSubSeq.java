package com.alg.rev.string;

public class DistSubSeq {

	public static int disSubSeq(String s, String t) {

		int dp[][] = new int[s.length() + 1][t.length() + 1];

		for (int r = 0; r < s.length(); r++) {
			dp[r][0] = 1;

		}

		for (int r = 1; r <= s.length(); r++) {

			for (int c = 1; c <= t.length(); c++) {

				if (s.charAt(r - 1) == t.charAt(c - 1)) {
					dp[r][c] += dp[r - 1][c] + dp[r - 1][c - 1];

				} else {
					dp[r][c] += dp[r - 1][c];
				}

			}
		}
		return dp[s.length()][t.length()];

	}

	public static void main(String[] args) {
		System.out.println(disSubSeq("rabbbit", "rabbit"));

	}

}
