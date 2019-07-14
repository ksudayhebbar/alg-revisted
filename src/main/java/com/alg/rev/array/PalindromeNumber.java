package com.alg.rev.array;

public class PalindromeNumber {

	public static int reverse(int num) {

		int result = 0;
		while (num > 0) {
			result = result * 10 + num % 10;
			num /= 10;
		}

		return result;

	}

	public static boolean palindromeNumber(int num) {

		return num == reverse(num);
	}

	public static void main(String[] args) {
		System.out.println(palindromeNumber(11211));
	}

}
