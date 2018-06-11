package com.alg.rev.array;

public class ReverseInteger {

	public static int reverseInt(int number) {

		int result = 0;

		while (number != 0) {

			int tail = number % 10;

			result = result * 10 + tail;

			number = number / 10;

		}

		return result;

	}

	public static void main(String[] args) {
		System.err.println(ReverseInteger.reverseInt(123));

	}

}
