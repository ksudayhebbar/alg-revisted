package com.alg.rev.array;

public class HouseRober {

	public static int rober(int house[]) {

		int dp[] = new int[house.length];

		dp[0] = house[0];
		dp[1] = Math.max(house[0], house[1]);

		for (int i = 2; i < house.length; i++) {
			dp[i] = Math.max(dp[i - 2] + house[i], dp[i - 1]);
		}
		return dp[house.length - 1];
	}

	public static int rober(int house[], int start, int end) {

		int dp[] = new int[house.length];

		dp[0] = house[start];
		dp[1] = Math.max(house[start], house[start + 1]);

		for (int i = start + 2; i < end; i++) {
			dp[i] = Math.max(dp[i - 2] + house[i], dp[i - 1]);
		}
		return dp[end - 1];

	}

	public static void main(String[] args) {

		System.out.println(rober(new int[] { 2, 3, 2, 1, 6 }));
		int[] r = { 2, 3, 2, 1, 6 };
		System.out.println(Math.max(rober(r, 0, r.length - 2), rober(r, 1, r.length - 1)));
	}

}
