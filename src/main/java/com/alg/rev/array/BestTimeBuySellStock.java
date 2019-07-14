package com.alg.rev.array;

public class BestTimeBuySellStock {
	public int profit(int price[]) {

		int max = 0;
		int min = price[0];
		for (int i = 1; i < price.length; i++) {
			min = Math.min(min, price[i]);
			max = Math.max(max, price[i] - min);

		}
		return max;

	}
	public int maxProfit(int[] prices, int fee) {
		int maxPr = 0;
		
		for (int i = 0, j = 1; j < prices.length; i++, j++) {

			if (prices[j] > prices[i]) {
				maxPr += prices[j] - prices[i] - fee;

			}

		}

		return maxPr;
	}

}
