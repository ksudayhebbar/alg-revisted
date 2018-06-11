package com.alg.rev.matrix;

import java.util.ArrayList;

public class SpiralMatrix {

	public static ArrayList<Integer> spiral(int[][] matrix) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int row = matrix[0].length;
		int col = matrix.length;
		int r = 0;
		int c = 0;
		while (row > 0 && col > 0) {

			if (row == 1) {
				for (int tr = 0; tr < row; tr++) {

					result.add(matrix[r][c++]);
				}
			}
			if (col == 1) {

				for (int tr = 0; tr < col; tr++) {

					result.add(matrix[r--][c]);
				}
			}

			for (int tr = 0; tr <row - 1; tr++) {

				result.add(matrix[r][c++]);
			}

			for (int tr = 0; tr < col - 1; tr++) {

				result.add(matrix[r++][c]);
			}

			for (int tr = 0; tr <col - 1; tr++) {

				result.add(matrix[r][c--]);
			}

			for (int tr = 0; tr <row - 1; tr++) {

				result.add(matrix[r--][c]);
			}

			r++;
			c++;
			row = row - 2;
			col = col - 2;

		}

		return result;
	}

	public static void main(String[] args) {
		int m[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };

		System.out.println(spiral(m));
	}

}
