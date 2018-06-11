package com.alg.rev.array;

public class PeekElement {

	public static int peekElement(int[] num) {

		int peekIndex = -1;
		if (num.length > 1) {

			for (int i = 1; i < num.length; i++) {
				if (num[i] > num[i - 1]) {
					peekIndex = i;
				}

			}
		} else if (num.length == 1) {
			return 1;
		}
		return peekIndex;

	}

	public static void main(String[] args) {

		int[] num = { 1, 2, 4, 3, 1 };
		// System.out.println(peekElement(num));

		int[] num1 = { 1, 2 };
		// System.out.println(peekElement(num1));

		int[] num2 = { 2 };
		System.out.println(peekElement(num2));
	}

}
