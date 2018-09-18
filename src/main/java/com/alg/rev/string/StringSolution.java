package com.alg.rev.string;

import java.util.ArrayList;
import java.util.List;

public class StringSolution {

	public String multiplie(String first, String second) {

		StringBuffer result = new StringBuffer(first.length() + second.length());

		int[] pos = new int[first.length() + second.length()];

		for (int i = second.length() - 1; i >= 0; i--) {
			int carry = 0;
			for (int j = first.length() - 1; j >= 0; j--) {

				int mul = (first.charAt(j) - '0') * (second.charAt(i) - '0');

				mul += pos[i + j + 1];

				int value = mul / 10;
				carry = mul % 10;
				pos[i + j] = value;
				pos[i + j + 1] = carry;
			}
		}

		for (int value : pos) {
			result.append(value);

		}
		return result.toString();

	}

	public void palindromePartion(String input, int start) {
		
		if(start==input.length()) {
			return;
		}
		
		for(int s=start;s<input.length()-1;s++) {
			
			String temp=input.substring(start,s );
			System.out.println(temp);
			palindromePartion(input, s+1);
			
			
		}
		
		
		

	}

	public boolean isPalindrome(String input) {

		for (int left = 0, right = input.length() - 1; left < right; left++, right--) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
		}

		return true;
	}

	private void run() {
		// System.out.println(multiplie("123", "55"));

	palindromePartion("aab", 0);

	}

	public static void main(String[] args) {
		new StringSolution().run();

	}

}
