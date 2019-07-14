package com.alg.rev.string;

public class LonestPaldrome2 {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			int len1 = longestPalindrome(s, i, i);
			int len2 = longestPalindrome(s, i, i + 1);
			int maxlen = Math.max(len1, len2);

			if (maxlen > end - start) {

				start = i - (maxlen - 1) / 2;
				end = i + maxlen / 2;

			}

		}

		return s.substring(start, end + 1);

	}

	public static int longestPalindrome(String str, int left, int right) {
		int L = left;
		int R = right;
		while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
			L--;
			R++;
		}
		System.out.println((R - L));
		return R - L - 1;

	}

	public static void main(String[] args) {
		
		longestPalindrome("aba");
	}

}
