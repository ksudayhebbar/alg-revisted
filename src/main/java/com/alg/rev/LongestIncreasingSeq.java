package com.alg.rev;

public class LongestIncreasingSeq {

	public static int[] dx = { -1, 0, 1, 0 };;
	public static int[] dy = { 0, 1, 0, -1 };

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] mem = new int[matrix.length][matrix[0].length];
		int longest = 0;

		/*
		 * for (int i = 0; i < matrix.length; i++) { for (int j = 0; j <
		 * matrix[0].length-1; j++) { mem[i][j]=-1; } }
		 */

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length - 1; j++) {
				longest = Math.max(longest, dfs(matrix, i, j, mem));
			}
		}

		return longest;
	}

	public static int dfs(int[][] matrix, int i, int j, int[][] mem) {
		if (mem[i][j] != 0)
			return mem[i][j];

		for (int m = 0; m < 4; m++) {
			int x = i + dx[m];
			int y = j + dy[m];

			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length - 1 && matrix[x][y] > matrix[i][j]) {
				mem[i][j] = Math.max(mem[i][j], dfs(matrix, x, y, mem));
			}
		}

		return ++mem[i][j];
	}

	public static int longestIncreasingPath(int[][] matrix,boolean sceond) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[] max = new int[1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length-1; j++) {
				dfs(matrix, i, j, max, 1);
			}
		}

		return max[0];
	}

	public static void dfs(int[][] matrix, int i, int j, int[] max, int len) {

		max[0] = Math.max(max[0], len);

		int m = matrix.length;
		int n = matrix[0].length-1;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				dfs(matrix, x, y, max, len + 1);
			}
		}
	}

	public static void main(String[] args) {

		int m[][] = { { 3, 3, 4, 5 }, 
					  { 9, 7, 8,10 }, 
					  { 2, 5, 7, 1 } };

		//System.out.println(longestIncreasingPath(m));
		
		System.out.println(longestIncreasingPath(m,true));
		
		

	}

}
