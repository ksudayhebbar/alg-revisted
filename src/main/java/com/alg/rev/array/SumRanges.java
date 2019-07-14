package com.alg.rev.array;

public class SumRanges {
	private int[] num;
	private int sum[];

	public SumRanges(int[] num) {
		super();
		sum=new int [num.length+1];
		for (int i = 0; i < num.length; i++) {
			sum[i +1] += sum[i]+num[i];

		}
		this.num = num;
	}

	public int ranges(int i, int j) {
		
		return sum[j+1]-sum[i];

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		SumRanges s = new SumRanges(a);
		System.out.println(s.ranges(0, 0));

	}

}
