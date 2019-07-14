package com.alg.rev.array;

import java.util.Stack;

public class BasicCalculator {

	
	public static void main(String[] args) {
			
		System.out.println(calculate("3+2*2 "));
	}

	public static int calculate(String s) {
		int num = 0;
		s=s.trim();
		Character sing='+';
		Stack<Integer> st = new Stack<Integer>();
		for (int i=0 ; i<s.length();i++) {
			
			if (Character.isWhitespace(s.charAt(i))) {
				continue;
			}

			if (Character.isDigit(s.charAt(i))) {

				num = num * 10 + s.charAt(i) - '0';
			} 
			if(!Character.isDigit(s.charAt(i)) || i==s.length()-1){

				if (sing.equals('-')) {

					num = num * -1;
					st.push(num);

				} else if (sing.equals('+')) {

					st.push(num);

				} else if (sing.equals('*')) {

					st.push(st.pop() * num);
				} else if (sing.equals('/')) {

					st.push(st.pop() / num);
				}
				sing=s.charAt(i);
				num = 0;

			}

		}
		int result = 0;
		while (!st.isEmpty()) {

			result += st.pop();
		}

		return result;
	}

}
