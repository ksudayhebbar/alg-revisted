package com.alg.rev.array;

import java.util.Stack;

public class InvalParentheses {

	public static String removeInvaildParantheses(String input) {
		StringBuffer res = new StringBuffer("");
		Stack<Character> st = new Stack<Character>();

		for (Character c : input.toCharArray()) {

			if (c.equals('(') || Character.isDigit(c) || Character.isAlphabetic(c)) {
				st.push(c);
			} else {

				if (!st.isEmpty()) {
					while (!st.isEmpty()&&st.peek().equals('(')) {

						res.append(st.pop());
					}
					res.append(c);
				}
			}

		}

		return res.toString();

	}

	public static void main(String[] args) {
	System.out.println(removeInvaildParantheses("()())()"));	
	}

}
