package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GroupOfShiftedString {
	public static List<List<String>> groupOfshiftedString(String[] str) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String oneString : str) {
			char[] charArray = oneString.toCharArray();

			if (charArray.length > 0) {
				int diff = charArray[0] - 'a';

				for (int i = 0; i < charArray.length; i++) {

					if (charArray[i] - diff > 'a') {

						charArray[i] = (char) (charArray[i] - diff + 26);
					} else {
						charArray[i] = (char) (charArray[i] - diff);
					}
				}

				String key = new String(charArray);
				if (map.containsKey(key)) {
					map.get(key).add(oneString);
				} else {
					ArrayList<String> al = new ArrayList<String>();
					al.add(oneString);
					map.put(key, al);
				}
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		result.addAll(map.values());

		return result;
	}

	public static List<String> grouphOfStringR(String str) {
		List<String> ret = new ArrayList<String>();
		if (str != null && (str.charAt(0) == 'x')) {

			ret.add(str);
			return ret;
		}

		char[] tempChar = new char[str.length()];
		int i = 0;

		for (Character c : str.toCharArray()) {

			if (c >= 'a' && c <= 'z') {
				tempChar[i++] = (char) (c + 1);
			} else {
				tempChar[i++] = c;
			}

		}
		ret = grouphOfStringR(new String(tempChar));
		ret.add(str);
		return ret;

	}

	public static List<String> grouphOfString(String str) {
		List<String> result = null;
		if (str != null) {
			str = str.toLowerCase();
			Stack<String> counter = new Stack<String>();
			counter.push(str);
			result = new ArrayList<String>();
			result.add(str);
			while (!counter.isEmpty()) {

				String tempStr = counter.pop();

				if (tempStr != null) {
					if (!(tempStr.charAt(0) == 'x')) {
						char[] charArray = new char[tempStr.length()];
						int i = 0;
						for (Character c : tempStr.toCharArray()) {

							int diff = c - 'a';

							if (diff > 'a' && diff < 'z') {

								charArray[i++] = c;
							} else {
								charArray[i++] = (char) (c + 1);
							}

						}
						counter.push(new String(charArray));
						result.add(counter.peek());
					}
				}

			}

		}
		return result;

	}

	public static void main(String[] args) {
		// String[] input = { "abc", "bcd", "xyz" };
		// System.out.println(groupOfshiftedString(input));

		// System.out.println(grouphOfString("abc"));
		// System.out.println(grouphOfString("ab"));
		// System.out.println(grouphOfString("xyz"));

		System.out.println(grouphOfStringR("ab"));
	}

}
