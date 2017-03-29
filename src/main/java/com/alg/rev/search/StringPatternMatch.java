package com.alg.rev.search;

public class StringPatternMatch {

	public int KMP(String input, String pattern) {
		if ((input != null && input.length() > 0)
				&& (pattern != null && pattern.length() > 0)
				&& (input.length() > pattern.length())) {

			int inputSize = input.length();
			int patternSize = pattern.length();
			Character[] inputArray = constructPatternArray(input, inputSize);

			Character[] constructPatternArray = constructPatternArray(pattern,
					inputSize);

			int i = 0, j = 0;

			while (i < inputSize) {
				if (inputArray[i] == constructPatternArray[j]) {
					
					
					if (j == patternSize-1 ) {
						return i - j;

					} else {
						i++;
						j++;

					}
				} else if (j > 0) {
					j = j - 1;

				} else {
					i++;
				}

			}

		}

		return -1;

	}

	private Character[] constructPatternArray(String pattern, int inputSize) {
		Character[] patternArray = new Character[inputSize];
		int count = 0;
		while (count < pattern.length()) {
			patternArray[count] = pattern.charAt(count);
			count++;
		}

		return patternArray;

	}

	public static void main(String[] args) {
		StringPatternMatch match = new StringPatternMatch();

		System.out.println(match.KMP("213212121213131", "1212131"));
	}

}
