package com.alg.rev.string;

import java.util.Stack;

public class BasicCalcluator2 {

	public static int cal(String str) {
		Stack<Integer> st = new Stack<Integer>();
		int result = 0;
		int sign = 1;
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				number = 10 * number + (int) (c - '0');
			} else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				st.push(result);
				st.push(sign);
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result *= st.pop();
				result += st.pop();

			}

		}
		if (number != 0)
			result += sign * number;
		return result;

	}

	public static void main(String[] args) {
		System.out.println(cal("(1+(1+2+3)+(1+1))"));
	}

}
