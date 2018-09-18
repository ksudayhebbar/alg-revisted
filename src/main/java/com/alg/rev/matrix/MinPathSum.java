package com.alg.rev.matrix;

public class MinPathSum {

	public static int minPathSum(int[][] mat, int row, int col) {

		if (row == mat.length - 1 && col == mat[0].length - 1) {
			return mat[row][col];
		}
		if (row < mat.length - 1 && col < mat[0].length - 1) {
			int rowValue = mat[row][col] + minPathSum(mat, row + 1, col);
			int colValue = mat[row][col] + minPathSum(mat, row, col + 1);
			return Math.min(rowValue, colValue);
		}

		if (row < mat.length - 1) {

			return mat[row][col] + minPathSum(mat, row + 1, col);
		}

		if (col < mat[0].length - 1) {

			return mat[row][col] + minPathSum(mat, row, col + 1);
		}
		return 0;
	}

	public static int minPathSumDP(int mat[][]) {

		int row = mat.length;
		int col = mat[0].length;
		int dp[][] = new int[row][col];
		dp[0][0] = mat[0][0];
		for (int r = 1; r < row; r++) {
			dp[r][0] = dp[r - 1][0] + mat[r][0];
		}

		for (int c = 1; c < col; c++) {
			dp[0][c] = dp[0][c - 1] + mat[0][c];
		}

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				if (dp[r - 1][c] > dp[r][c - 1]) {
					dp[r][c] = dp[r][c - 1] + mat[r][c];
				} else {
					dp[r][c] = dp[r - 1][c] + mat[r][c];
				}
			}

		}
		return dp[row - 1][col - 1];

	}

	public static void main(String[] args) {
		int m[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 }, { 60, 90, 91, 100 } };

		System.out.println(MinPathSum.minPathSum(m, 0, 0));

		int m2[][] = { { 1, 3, 5 }, { 10, 11, 16 }, { 23, 10, 34 } };
		System.out.println(minPathSumDP(m2));

	}

}
