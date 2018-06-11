package com.alg.rev.matrix;

public class SetZero {

	public static void setzero(int[][] mat) {

		for (int row = 0; row < mat[0].length; row++) {
			checkSet(row, 0, mat);
		}

		print(mat);

	}

	private static boolean checkSet(int row, int col, int[][] mat) {
		boolean checkSet = false;
		if (col < mat[0].length && mat[row][col] == 0) {
			for (int c = 0; c < mat[0].length; c++) {

				mat[row][c] = 0;
				mat[c][row] = 0;
			}
			return true;
		} else if (col < mat[0].length) {
			col = col + 1;

			return checkSet(row, col, mat);
		}
		return checkSet;

	}

	public static void print(int[][] mat) {
		for (int row = 0; row < mat[0].length; row++) {

			for (int col = 0; col < mat[0].length; col++) {

				System.out.print(mat[row][col]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[][] mat = {
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 0 }, 
				{ 1, 1, 0, 0 }, 
				{ 1, 0, 0, 0 } 
				};
		setzero(mat);
	}

}
