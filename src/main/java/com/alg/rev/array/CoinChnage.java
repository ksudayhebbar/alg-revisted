package com.alg.rev.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChnage {

	public static int coinChange(int[] coin, int ammount) {

		int dp[] = new int[ammount+1];

		for (int i = 1; i <= ammount; i++) {

			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= ammount; i++) {

			for (int c : coin) {

				if (i + c <= ammount) {

					if (dp[i] == Integer.MAX_VALUE) {
						dp[i + c] = i+c;

					} else {

						dp[i + c] = Math.max(dp[i] + 1, i + c);
					}
				}

			}
		}
		if (dp[ammount] == Integer.MAX_VALUE) {
			return -1;
		}

		return dp[ammount];

	}

	public static int coinBfs(int[] coin, int amount) {

		Queue<Integer> amountQ = new LinkedList<Integer>();

		Queue<Integer> setps = new LinkedList<Integer>();
		amountQ.offer(0);
		setps.offer(0);

		while (!amountQ.isEmpty()) {
			Integer a = amountQ.poll();
			Integer step = setps.poll();

			if (a == amount) {

				return a;

			}

			for (Integer c : coin) {

				if ((a + c) > amount) {
					continue;
				} else {

					amountQ.offer(a + c);
					setps.offer(step++);
				}

			}

		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {1,2,2,5,10,15}, 25));
		System.out.println(coinBfs(new int[] {1,2,2,5,10,15}, 25));

	}

}
