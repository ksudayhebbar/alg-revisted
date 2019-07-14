package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCommbination {
	public static List<String> letterCombinations(String digits) {

		Map<Integer, String> dial = new HashMap<Integer, String>();

		dial.put(2, "abc");
		dial.put(3, "def");
		dial.put(4, "ghi");
		dial.put(5, "jkl");
		dial.put(6, "mno");
		dial.put(7, "pqrs");
		dial.put(8, "tuv");
		dial.put(9, "wxyz");
		Queue<String> q = new LinkedList<String>();
		q.add("");
		for (int i = 0; i < digits.length(); i++) {

			String button = dial.get(Integer.valueOf(digits.charAt(i) + ""));
			while (q.peek().length() == i) {
				String temp = q.remove();

				for (Character b : button.toCharArray()) {
					StringBuffer sb = new StringBuffer(temp + b);
					q.add(sb.toString().trim());
				}

			}

		}

		return new ArrayList<String>(q);
	}

	public static void main(String[] args) {
		letterCombinations("23");

	}

	
}
