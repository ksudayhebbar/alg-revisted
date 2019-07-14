package com.alg.rev.string;

import java.util.HashMap;
import java.util.Map;

public class FraactionRecuring {
	public static String fractionToDecimal(int numerator, int denominator) {

		if (numerator == 0)
			return "0";

		StringBuffer fraction = new StringBuffer();
		if (numerator < 0 ^ denominator < 0) {
			fraction.append("-");
		}

		long dividend = Math.abs(Long.valueOf(numerator));
		long divisior = Math.abs(Long.valueOf(denominator));
		fraction.append(String.valueOf(dividend / divisior));
		long reminder = dividend % divisior;
		if (reminder == 0) {
			return fraction.toString();
		}
		fraction.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while (reminder != 0) {

			if (map.containsKey(reminder)) {
				fraction.insert(map.get(reminder), "(");
				fraction.append(")");
				break;
			}
			map.put(reminder, fraction.length());
			reminder *= 10;
			fraction.append(String.valueOf(reminder / divisior));
			reminder = reminder % divisior;
		}

		return fraction.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fractionToDecimal(2, 3);
	}

}
