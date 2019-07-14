package com.alg.rev.string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

	public String minWindowSubString(String org, String traget) {

		if (org == null || traget == null)
			return null;

		int minLen = org.length();

		Map<Character, Integer> targetCounter = new HashMap<Character, Integer>();

		for (Character sChar : traget.toCharArray()) {

			if (targetCounter.get(sChar) != null) {

				targetCounter.put(sChar, targetCounter.get(sChar) + 1);

			} else {
				targetCounter.put(sChar, 1);
			}
		}
		int counter = 0;
		int left = 0;
		String result = "";
		HashMap<Character, Integer> tempCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < org.length(); i++) {

			Character sChar = org.charAt(i);

			if (targetCounter.containsKey(sChar)) {

				if (tempCounter.containsKey(sChar)) {
					if (tempCounter.get(sChar) < targetCounter.get(sChar)) {
						tempCounter.put(sChar, tempCounter.get(sChar) + 1);
						counter++;
					}
				} else {
					tempCounter.put(sChar, 1);
					counter++;
				}
				if (counter == traget.length()) {
					char sc = org.charAt(left);
					while (!tempCounter.containsKey(sc) || tempCounter.get(sc) > targetCounter.get(sc)) {
						if (tempCounter.containsKey(sc) && tempCounter.get(sc) > targetCounter.get(sc))
							tempCounter.put(sc, tempCounter.get(sc) - 1);
						left++;
						sc = org.charAt(left);
					}

					if (i - left + 1 < minLen) {
						result = org.substring(left, i + 1);
						minLen = i - left + 1;
						left = i + 1;
						counter = 0;
						tempCounter = new HashMap<Character, Integer>();
					}
				}

			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ADOBECODEBANC";
		String T = "ABC";
		minWindow(S, T);
		System.out.println(new MinWindowSubString().minWindowSubString(S, T));

	}

	public static String minWindow(String s, String t) {
		if (s == null || t == null)
			return "";
		Map<Character, Integer> hashT = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {

			hashT.put(t.charAt(i), hashT.getOrDefault(t.charAt(i), 0) + 1);
		}
		int j = 0;
		int start = Integer.MAX_VALUE;
		int send = 0;
		int sstart = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (hashT.get(s.charAt(i)) != null && hashT.get(s.charAt(i)) > 0) {
				if (start == Integer.MAX_VALUE) {
					start = i;
				}
				hashT.put(s.charAt(i), hashT.get(s.charAt(i)) - 1);
				j++;
			}
			if (j == t.length()) {
				if (i - start < min) {
					sstart = start;
					send = i + 1;
					min = i - start + 1;
					System.out.println(s.substring(sstart, send));
				}
				for (int k = 0; k < t.length(); k++) {

					hashT.put(t.charAt(k), hashT.getOrDefault(t.charAt(k), 0) + 1);
				}
				start = Integer.MAX_VALUE;
				j = 0;
			}
		}
		return s.substring(sstart, send);
	}

}
