package com.alg.rev.array;

public class SumRanges {
	private int[] num;

	public SumRanges(int[] num) {
		super();

		for (int i = 1; i < num.length; i++) {
			num[i - 1] += num[i];

		}
		this.num = num;
	}

	public int ranges(int i, int j) {
		int res = -1;
		if (i >= 0 && j <= num.length-1) {

			res = num[i] + num[j];

		}
		return res;

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		SumRanges s = new SumRanges(a);
		System.out.println(s.ranges(0, 4));

	}

}
