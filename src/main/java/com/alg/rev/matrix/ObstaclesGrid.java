package com.alg.rev.matrix;

public class ObstaclesGrid {

	public static int path(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length - 1;
		int dp[][] = new int[row][col];
		dp[0][0] = 1;
		for (int c = 1; c < col; c++) {

			if (grid[0][c] == 1) {

				dp[0][c] = 0;
			} else {
				dp[0][c] = dp[0][c - 1];
			}

		}
		for (int r = 1; r < row; r++) {

			if (grid[r][0] == 1) {

				dp[r][0] = 0;
			} else {
				dp[r][0] = dp[r - 1][0];
			}

		}

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				if (grid[r][c] == 1) {
					dp[r][c] = 0;
				} else {
					dp[r][c] = dp[r ][c-1] + dp[r-1][c];
				}
			}
		}
		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int m[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, };
		System.out.println(path(m));
	}

}
