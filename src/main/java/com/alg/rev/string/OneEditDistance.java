package com.alg.rev.string;

public class OneEditDistance {

	public int editDist(String one, String second) {

		int dp[][] = new int[one.length() + 1][second.length() + 1];

		for (int r = 0; r < one.length(); r++) {
			dp[r][0] = r;
		}
		for (int c = 0; c < second.length(); c++) {
			dp[0][c] = c;
		}

		for (int r = 0; r < one.length(); r++) {
			Character oc = one.charAt(r);
			for (int c = 0; c < second.length(); c++) {
				Character sc = second.charAt(c);
				if (oc.equals(sc)) {
					dp[r + 1][c + 1] = dp[r][c];
				} else {
					int replace = dp[r][c] + 1;
					int del = dp[r + 1][c] + 1;
					int ins = dp[r][c + 1] + 1;

					int min = replace > ins ? ins : replace;
					min = del > min ? min : del;
					dp[r + 1][c + 1] = min;
				}
			}

		}
		return dp[one.length()][second.length()];

	}

	public boolean oneEditDist(String s, String t) {

		int m = s.length();
		int n = t.length();

		if (Math.abs(m - n) > 1) {
			return false;
		}
		int charCount = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {

			if (s.charAt(i) == t.charAt(j)) {

				i++;
				j++;
			} else {

				if (charCount > 1) {
					return false;
				}

				if (m > n) {
					i++;
				} else {
					j++;
				}
				charCount++;

			}

		}
		if (i < m || j < n) {
			charCount++;
		}
		return charCount == 1;

	}

	public boolean isOneEditDistance(String s, String t) {
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one
												// char in s and t
					return s.substring(i + 1).equals(t.substring(i + 1));
				else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char
													// from t
					return s.substring(i).equals(t.substring(i + 1));
				else // s is longer than t, so the only possibility is deleting one char from s
					return t.substring(i).equals(s.substring(i + 1));
			}
		}
		// All previous chars are the same, the only possibility is deleting the end
		// char in the longer one of s and t
		return Math.abs(s.length() - t.length()) == 1;
	}

	public static void main(String[] args) {
		OneEditDistance o = new OneEditDistance();
		System.out.println(o.isOneEditDistance("ab", "ac"));

	}

}
