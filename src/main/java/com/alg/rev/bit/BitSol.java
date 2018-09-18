package com.alg.rev.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class BitSol {

	public static int maxGap(int num) {
		int max = 0;
		int count = -1;
		int r = 0;
		while (num > 0) {

			r = num & 1;
			num = num >> 1;
			if (0 == r && count >= 0) {

				count++;
			}
			if (1 == r) {
				max = count > max ? count : max;
				count = 0;

			}

		}
		return max;

	}

	public static int singleDuplicateNum(int[] num) {

		int one = 0;
		int two = 0;
		int three = 0;
		for (int i : num) {
			two |= one & i;
			one = one ^ i;
			three = one & two;
			one &= ~three;
			two &= ~three;
		}

		return one;

	}

	public static int getNumerOFBits(int n) {
		int count = 0;
		System.out.println(Integer.bitCount(n));
		for (int i = 1; i < 33; i++) {
			if (getBit(n, i) == true) {
				count++;
			}

		}
		return count;

	}

	public static Map<Integer, List<String>> repeatedDNA(String sq) {

		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();

		int len = 0;

		int hashCode = 0;

		for (int i = 0; i < sq.length(); i++) {

			if (len < 9) {

				hashCode = hashCode * 10 + sq.charAt(i) - 'A';
				len++;
			} else {

				if (res.get(hashCode) != null) {
					res.get(hashCode).add(sq.substring(i - 9, i + 1));

					hashCode = 0;
					;
					len = 0;
				} else {
					List<String> tempList = new ArrayList<String>();
					tempList.add(sq.substring(i - 9, i + 1));

					hashCode = 0;

					len = 0;
				}

			}

		}
		return res;

	}

	public static int addTwoNumber(int a, int b) {

		while (b != 0) {

			int t = a & b;

			a = a ^ b;
			b = t << 1;

		}

		return a;

	}

	private static boolean getBit(int n, int i) {
		// TODO Auto-generated method stub
		return (n & (i << 1)) != 0;
	}

	public static List<Integer> grayCode(int n) {

		if (n == 0) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;

		}

		List<Integer> result = grayCode(n - 1);

		int numberToAdd = (1 << n - 1);

		for (int i = result.size() - 1; i >= 0; i--) {

			result.add(numberToAdd + result.get(i));

		}
		return result;

	}

	public static int[] countBits(int n) {

		int count[] = new int[n + 1];
		while (n > 0) {

			int tempn = n;
			int tempCount = 0;
			while (tempn > 0) {

				if (tempn % 2 == 1) {
					tempCount++;
				}

				tempn = tempn / 2;
			}
			count[n] = tempCount;
			n--;

		}
		return count;

	}

	public static void main(String[] args) {

		// System.out.println(singleDuplicateNum(new int[] { 2, 2, 2, 3, 3, 3, 1, 1, 1,
		// 4, 4, 4, 5 }));

		// System.err.println(maxGap(4));

		// System.err.println(getNumerOFBits(11));

		// String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTCAAAAAGGGT";
		// System.out.println(repeatedDNA(s));

		// System.err.println(addTwoNumber(2, 5));

		//System.out.println(grayCode(2));
		
		System.out.println(countBits(5));

	}

}
