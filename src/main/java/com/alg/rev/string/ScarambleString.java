package com.alg.rev.string;

import java.util.Arrays;

public class ScarambleString {

	public static boolean isScarmable(String one, String two) {

		if (one != null || two != null) {

			if (one.length() != two.length()) {

				return false;

			}
			if (one.length() == 0 || one.equals(two)) {
				return true;
			}

			char[] tempOne = one.toCharArray();
			char[] tempTwo = two.toCharArray();
			Arrays.sort(tempOne);
			Arrays.sort(tempTwo);
			if (new String(tempOne).equals(new String(tempTwo))) {
				return true;
			}

			for (int i = 0; i < one.length(); i++) {

				String fristOneFristHalf = one.substring(0, i);
				String fristOneSecondHalf = one.substring(i, one.length());

				String secondOneFristHalf = two.substring(0, i);
				String secondOneSecondHalf = two.substring(i, two.length());

				String secondOneFristHalf1 = two.substring(0, two.length() - i);
				String secondOneSecondHalf1 = two.substring(two.length() - i, two.length());

				if (isScarmable(fristOneFristHalf, secondOneSecondHalf)
						|| isScarmable(fristOneSecondHalf, secondOneFristHalf)) {
					return true;
				}

				if (isScarmable(fristOneFristHalf, secondOneSecondHalf1)
						|| isScarmable(fristOneSecondHalf, secondOneFristHalf1)) {
					return true;
				}
			}

		}

		return false;

	}

	public static void main(String[] args) {
		System.out.println(isScarmable("eat", "ate"));

	}

}
