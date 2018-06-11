package com.alg.rev.matrix;

public class MaxSquareInMartrix {

	public static int maxSquare(int[][] m) {

		int row = m.length;
		int col = m[0].length;

		int t[][] = new int[row][col];

		for (int c = 0; c < col; c++) {
			t[0][c] = m[0][c];

		}

		for (int r = 0; r < row; r++) {
			t[r][0] = m[r][0];

		}

		print(m);
		System.out.println();
		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				if (m[r][c] == 1) {
					int min = Math.min(t[r - 1][c], t[r - 1][c - 1]);
					min = Math.min(min, t[r][c - 1]);
					t[r][c] = min + 1;

				} else {
					t[r][c] = 0;
				}

			}
		}
		
		print(t);

		int max = 0;
		// get maximal length
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (t[i][j] > max) {
					max = t[i][j];
				}
			}
		}

		return max * max;

	}
	
	public static void print(int[][] mat) {
		for (int row = 0; row < mat.length; row++) {

			for (int col = 0; col < mat[0].length; col++) {

				System.out.print(" " + mat[row][col]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
		
		System.out.println(maxSquare(m));
	}

}
