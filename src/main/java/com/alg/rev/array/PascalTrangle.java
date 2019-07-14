package com.alg.rev.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTrangle {

	public static List<Integer> getPascalTrangleRow(int row) {

		List<Integer> result = new ArrayList<Integer>();

		result.add(1);
		for (int i = 1; i <= row; i++) {

			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));

			}
			result.add(1);
		}

		return result;

	}

	public static List<List<Integer>> createPascalTrangle(int num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> pre = new ArrayList<Integer>();

		pre.add(1);

		result.add(pre);

		for (int i = 0; i < num; i++) {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for (int j = 0; j < pre.size() - 1; j++) {

				cur.add(pre.get(j) + pre.get(j + 1));

			}
			cur.add(1);
			result.add(cur);
			pre = cur;
		}

		return result;

	}

	public static void main(String[] args) {
		// List<List<Integer>> createPascalTrangle =
		// PascalTrangle.createPascalTrangle(5);
		// System.out.println(createPascalTrangle);

		List<List<Integer>> pascalTrangleRow = PascalTrangle.createPascalTrangle(3);

		System.out.println(getRow(3));

	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++) {
			result.add(1);
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j - 1) + result.get(j));
			}

		}

		return result;

	}
}
