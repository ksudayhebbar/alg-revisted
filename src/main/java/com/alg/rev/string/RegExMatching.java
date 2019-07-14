package com.alg.rev.string;

public class RegExMatching {
	public static boolean isMatch(String s, String p) {
		System.out.println(" S " + s + " P " + p);
		if (p.isEmpty())
			return s.isEmpty();

		if (p.length() >= 2 && '*' == p.charAt(1)) {
			return isMatch(s, p.substring(2))
					|| !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0)) && isMatch(s.substring(1), p);
		} else {
			return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0))
					&& isMatch(s.substring(1), p.substring(1));
		}

	}

	public static boolean isMatch2(String s, String p) {
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

		for (int r = s.length() -1; r >=0; r--) {
			for (int c = p.length()-1; c >= 0; c--) {

				boolean first = (r < s.length() && c< p.length()&& s.charAt(r) == p.charAt(c) || '.' == p.charAt(c));

				if (c + 1 < p.length() && p.charAt(c + 1) == '*') {
					dp[r][c] = dp[r][c + 2] || first && dp[r][c + 1];
				} else {
					dp[r][c] = first && dp[r + 1][c + 1];
				}

			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		System.out.println(isMatch2("aa", "a"));
	}

}
