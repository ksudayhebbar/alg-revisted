package com.alg.rev.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreakSol {

	public static boolean wordBreak1(String words, Set<String> dic) {

		int start = 0;
		int len = 0;
		for (int i = 1; i <= words.length(); i++) {

			String subWord = words.substring(start, i);
			if (dic.contains(subWord)) {
				start = i;
				len =i;
			}

		}

		return words.length() == len;

	}

	public static void main(String[] args) {
		Set<String> dic = new HashSet<String>();
		dic.add("leet");
		dic.add("code");
		System.err.println(wordBreak1("leetcode", dic));

	}

}
