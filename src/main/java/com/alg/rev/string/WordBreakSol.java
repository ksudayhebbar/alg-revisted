package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakSol {

	public static boolean wordBreak(String words, List<String> wordDict) {
		return word_Break(words, new HashSet(wordDict), 0, new Boolean[words.length()]);

	}

	public static boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
		System.out.println("Start"+ start);
		if (start == s.length()) {
			return true;
		}
		if (memo[start] != null) {
			return memo[start];
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
				return memo[start] = true;
			}
		}
		return memo[start] = false;
	}

	public static void main(String[] args) {
		List<String> dic = new ArrayList<String>();
		dic.add("aaaa");
		dic.add("aaa");

		System.err.println(wordBreak("aaaaaaa", dic));

	}

}
