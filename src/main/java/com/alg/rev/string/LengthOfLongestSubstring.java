package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring2(String str) {
		if (str == null)
			return -1;
		boolean[] flags = new boolean[256];

		int logestSubString = 0;
		int CharCount = 0;
		int start = 0;

		for (Character c : str.toCharArray()) {

			if (flags[c - '0'] == true) {

				logestSubString = Math.max(logestSubString, CharCount - start);

				start = CharCount;
				flags = new boolean[256];

			} else {

				flags[c - '0'] = true;
				CharCount++;
			}

		}
		return Math.max(logestSubString, CharCount - start);

	}

	public static String lengthOfLongestSubstringWithUniqueChar(String str, int num) {
		if (str == null)
			return "";
		boolean[] flags = new boolean[256];

		int logestSubString = 0;
		int CharCount = 0;
		int start = 0;
		int uniqueCharCount = 0;
		int endindex = 0;
		int startindex = 0;
		for (Character c : str.toCharArray()) {

			if (flags[c - '0'] == false && uniqueCharCount < num) {
				flags[c - '0'] = true;
				uniqueCharCount++;
				CharCount++;

			} else if (flags[c - '0'] == true && uniqueCharCount <= num) {
				CharCount++;
			} else {
				CharCount++;
				int end = CharCount - start;
				if (Math.max(logestSubString, end) > logestSubString) {
					logestSubString = Math.max(logestSubString, end);
					startindex = start;
					endindex=CharCount-1;
					start = CharCount;
					uniqueCharCount = 0;					
					flags = new boolean[256];
				}

				
			}

		}
		return str.substring(startindex, endindex<=0 ? CharCount-1:endindex);

	}

	public static int lengthOfLongestSubstring(String str) {
		if (str == null)
			return -1;
		boolean[] flags = new boolean[256];
		int i = 0;
		int j = 0;
		int logestSubString = 0;
		while (j < str.length()) {
			char cur = str.charAt(j);

			if (flags[cur]) {

				logestSubString = Math.max(logestSubString, j - i);
				for (int k = i; k < str.length(); k++) {
					if (str.charAt(k) == cur) {
						i = k + 1;
						break;
					}
					flags[str.charAt(k)] = false;
				}

			} else {

				flags[cur] = true;

			}
			j++;

		}

		return logestSubString = Math.max(logestSubString, j - i);

	}

	public static void main(String[] args) {
		// System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
		// System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("b"));

		// System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring2("abcabcbb"));
		// System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring2("b"));
		System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstringWithUniqueChar("abcbbbbcccbdddadacb", 4));
		// String[] words = { "foo", "bar" };
		// LengthOfLongestSubstring.findSubstring("barfoothefoobarman", words);

	}

	public static List<Integer> findSubstring(String s, String[] words) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		// frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			if (map.containsKey(w)) {
				map.put(w, map.get(w) + 1);
			} else {
				map.put(w, 1);
			}
		}

		int len = words[0].length();

		for (int j = 0; j < len; j++) {
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;// start index of start
			int count = 0;// count totoal qualified words so far

			for (int i = j; i <= s.length() - len; i = i + len) {
				String sub = s.substring(i, i + len);
				if (map.containsKey(sub)) {
					// set frequency in current map
					if (currentMap.containsKey(sub)) {
						currentMap.put(sub, currentMap.get(sub) + 1);
					} else {
						currentMap.put(sub, 1);
					}

					count++;

					while (currentMap.get(sub) > map.get(sub)) {
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start = start + len;
					}

					if (count == words.length) {
						result.add(start); // add to result

						// shift right and reset currentMap, count & start point
						String left = s.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}
				} else {
					currentMap.clear();
					start = i + len;
					count = 0;
				}
			}
		}

		return result;
	}
}
