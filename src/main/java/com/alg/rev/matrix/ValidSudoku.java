package com.alg.rev.matrix;

public class ValidSudoku {

	public static boolean isVaildSudoku(char[][] mat) {

		boolean[] m;
		for (int r = 0; r < 9; r++) {

			m = new boolean[9];

			for (int c = 0; c < 9; c++) {
				if (mat[r][c] != '.') {
					if (m[mat[c][r] - '1']) {
						return false;

					} else {
						m[mat[c][r] - '1'] = true;

					}
				}
			}
		}

		for (int r = 0; r < 9; r++) {

			m = new boolean[9];

			for (int c = 0; c < 9; c++) {
				if (mat[r][c] != '.') {
					if (m[mat[r][c] - '1']) {
						return false;

					} else {
						m[mat[c][r] - '1'] = true;

					}
				}
			}
		}

		// check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (mat[i][j] != '.') {
						if (m[(int) (mat[i][j] - '1')]) {
							return false;
						}
						m[(int) (mat[i][j] - '1')] = true;
					}
				}
			}
		}

		return true;

	}

	public static void main(String[] args) {
		char[][] m = { 
				{ '5', '3', '.', '7', '.', '.', '.', '.' }, 
				{ '5', '3', '.', '7', '.', '.', '.', '.' },
				{ '5', '3', '.', '7', '.', '.', '.', '.' }, 
				{ '5', '3', '.', '7', '.', '.', '.', '.' },
				{ '5', '3', '.', '7', '.', '.', '.', '.' }, 
				{ '5', '3', '.', '7', '.', '.', '.', '.' },
				{ '5', '3', '.', '7', '.', '.', '.', '.' }, 
				{ '5', '3', '.', '7', '.', '.', '.', '.' },
				{ '5', '3', '.', '7', '.', '.', '.', '.' } };

		System.out.println(isVaildSudoku(m));

	}

}
