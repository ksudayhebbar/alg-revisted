package com.alg.rev.matrix;

public class RotateMatrix {

	public static void rotate(int[][] matrix) {

		int col = matrix[0].length - 1;

		for (int r = 0; r < col / 2; r++) {

			for (int c = r; c < col - r; c++) {

				int temp = matrix[r][c];

				matrix[r][c] = matrix[c][col - r];
				matrix[c][col - r] = matrix[col - r][col - c];
				matrix[col - r][col - c] = matrix[col - c][r];
				matrix[col - c][r] = temp;

			}

		}

	}

	public static void print(int[][] mat) {
		for (int row = 0; row < mat[0].length; row++) {

			for (int col = 0; col < mat[0].length; col++) {

				System.out.print(" " + mat[row][col]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int m[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 }, { 60, 90, 91, 100 } };

		rotate(m);

		print(m);

		/*
		 * rotate(m);
		 * 
		 * print(m);
		 * 
		 * rotate(m);
		 * 
		 * print(m);
		 * 
		 * rotate(m);
		 * 
		 * print(m);
		 */
	}

}
