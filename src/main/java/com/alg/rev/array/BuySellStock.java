package com.alg.rev.array;

public class BuySellStock {

	public int profit(int price[]) {

		int max = 0;
		int min = price[0];
		for (int i = 1; i < price.length; i++) {
			min = Math.min(min, price[i]);
			max = Math.max(max, price[i] - min);

		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
