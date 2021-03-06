package com.alg.rev.matrix;

public class NumberOfIsLand {

	public static int isLand(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length - 1;
		int count = 0;
		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {

				if (grid[r][c] == 1) {
					count++;
					search(grid, r, c);
				}
				//
			}

		}
		return count;

	}

	private static int search(int[][] grid, int r, int c) {

		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length - 1 || grid[r][c] == 0 || grid[r][c] == 'X') {
			return 0;
		}
		grid[r][c] = 'X';

		search(grid, r + 1, c);
		search(grid, r - 1, c);
		search(grid, r, c + 1);
		search(grid, r, c + 1);
		return 0;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }

		};
		// System.out.println(isLand(m));
		int m2[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(m2));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid.length-1;
		int max = 0;
		for (int r = 0; r < rows; r++) {

			for (int c = 0; c < cols; c++) {

				if (grid[r][c] == 1) {

					int shapeCount = searchTwo(grid, r, c);

					max = Math.max(max, shapeCount);

				}
			}
		}

		return max;
	}

	public static int searchTwo(int[][] grid, int r, int c) {

		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length - 1 || grid[r][c] == -1 || grid[r][c] == 0) {
			return 0;
		}

		grid[r][c] = -1;

		return searchTwo(grid, r + 1, c) + searchTwo(grid, r - 1, c) + searchTwo(grid, r, c + 1)
				+ searchTwo(grid, r, c - 1) + 1;

	}

}
