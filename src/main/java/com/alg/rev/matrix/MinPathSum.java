package com.alg.rev.matrix;

public class MinPathSum {

	public static int minPathSum(int[][] mat, int row, int col) {

		if (row == mat.length-1 && col == mat[0].length - 1) {
			return mat[row][col];
		}
		if (row < mat.length-1 && col < mat[0].length - 1) {
			int rowValue = mat[row][col] + minPathSum(mat, row + 1, col);
			int colValue = mat[row][col] + minPathSum(mat, row, col + 1);
			return Math.min(rowValue, colValue);
		}

		if (row < mat.length-1) {

			return mat[row][col] + minPathSum(mat, row + 1, col);
		}

		if (col < mat[0].length - 1) {

			return mat[row][col] + minPathSum(mat, row, col + 1);
		}
		return 0;
	}

	public static void main(String[] args) {
		int m[][] = { 
				{ 1, 3, 5, 7 }, 
				{ 10, 11, 16, 20 },
				{ 23, 30, 34, 50 }, 
				{ 60, 90, 91, 100 } 
				};
		
		
		System.out.println(MinPathSum.minPathSum(m, 0, 0));

	}

}
