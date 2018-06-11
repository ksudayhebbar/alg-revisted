package com.alg.rev.matrix;

public class UniquePath {

	public static void path(int row, int col) {

		int[][] dp = new int[row][col];

		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {

				dp[r][c] = -1;
			}

		}

		path(dp, row - 1, col - 1);

		print(dp);

	}

	public static int path2(int r, int c, int row, int col) {

		if (r == row || col == c) {

			return 1;

		}
		if (r < row && c < col) {
			return path2(r + 1, c, row, col) + path2(r, c + 1, row, col);

		}

		if (r < row) {
			return path2(r + 1, c, row, col);

		}
		if (c < col) {
			return path2(r, c + 1, row, col);
		}
		return 0;

	}

	public static void print(int[][] mat) {
		for (int row = 0; row < mat[0].length; row++) {

			for (int col = 0; col < mat[0].length; col++) {

				System.out.print(" " + mat[row][col]);
			}
			System.out.println();
		}

	}

	private static int path(int[][] dp, int row, int col) {
		if (row == 0 || col == 0) {
			dp[row][col] = 1;
			return 1;
		}

		if (dp[row][col] != -1) {

			return dp[row][col];
		}
		dp[row][col] = path(dp, row - 1, col) + path(dp, row, col - 1);

		return dp[row][col];
	}

	public static void main(String[] args) {
		path(5, 5);

		System.out.println(path2(0, 0, 5, 5));

	}

}
