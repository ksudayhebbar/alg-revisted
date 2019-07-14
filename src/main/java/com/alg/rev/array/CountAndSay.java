package com.alg.rev.array;

public class CountAndSay {

	public static String countSay(int n) {

		if (n < 0)
			return "";

		String result = "1";

		int i = 1;

		while (i < n) {

			StringBuffer sb = new StringBuffer();
			int count = 1;

			for (int j = i; j < result.length(); j++) {

				if (result.charAt(j) == result.charAt(j - 1)) {

					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}

			}

			sb.append(count);

			sb.append(result.charAt(result.length() - 1));

			result += sb.toString();

			i++;
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(countSay(5));

	}

}
