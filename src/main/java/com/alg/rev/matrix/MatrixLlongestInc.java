package com.alg.rev.matrix;

public class MatrixLlongestInc {
	public static int longestIncreasingPath(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;
		int max = 0;
		int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				max = Math.max(max, dfs(matrix, i, j, dir));
			}
		}
		return max;
	}

	public static int dfs(int[][] matrix, int r, int c, int dir[][]) {
		int count = 0;

		for (int[] d : dir) {

			int x = r + d[0];
			int y = c + d[1];

			if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length && matrix[x][y] > matrix[r][c]) {
				count = Math.max(count, dfs(matrix, x, y, dir));

			}

		}
		return ++count;
	}

	public static void main(String[] args) {
		int a[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(longestIncreasingPath(a));

	}

}
