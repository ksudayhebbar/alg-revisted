package com.alg.rev.matrix;

public class VaildateSudko {

	public static boolean vaildate(char[][] grid) {
		int rows[][] = new int[9][9];
		int cols[][] = new int[9][9];
		int cross[][] = new int[9][9];

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] != '.') {

					int num = grid[r][c] - '0' - 1;
					int k = r / 3 * 3 + c / 3;
					if (rows[r][num] >= 1 || cols[c][num] >= 1 || cross[k][num] >= 1) {
						return false;
					}
					rows[r][num] =  cols[c][num] = cross[k][num] = 1;
				}

			}
		}
		print(rows);
		System.out.println();
		print(cols);
		System.out.println();
		print(cross);
		System.out.println();
		return true;
	}

	public static void print(int[][] g) {

		for (int r = 0; r < g.length; r++) {
			for (int c = 0; c < g[0].length; c++) {
				System.out.print(g[r][c]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		{
			char[][] grid = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
					{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
					{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
					{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
					{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

			System.out.println(vaildate(grid));
		}

	}

}
