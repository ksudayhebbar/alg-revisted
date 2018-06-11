package com.alg.rev.matrix;

public class SurroundedRegion {

	public static void surroundedRegion(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length - 1;
		int[][] visted = new int[grid.length][grid[0].length];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				visted[r][c] = -1;

			}

		}

		surroundedRegion(grid, visted, 0, 0);
		print(grid);
	}

	public static void surroundedRegion(char[][] grid, int[][] visted, int row, int col) {
		if (row >= 0 || row < grid.length - 1 || col >= 0 || col < grid[0].length - 1) {

			if (row > grid.length - 1 || col > grid[0].length - 1 || row < 0 || col < 0) {
				return;
			}
			if (visted[row][col] != -1) {
				if ((col >= 1 && col <= grid[0].length - 2) && (row >= 1 && row <= grid.length - 2)) {
					grid[row][col] = 'X';
					return;
				} else {
					return;
				}
			} else {
				visted[row][col] = 1;

			}

		}

		surroundedRegion(grid, visted, row + 1, col);

		surroundedRegion(grid, visted, row - 1, col);

		surroundedRegion(grid, visted, row, col + 1);

		surroundedRegion(grid, visted, row, col - 1);

	}

	public static void print(char[][] mat) {
		for (int row = 0; row < mat.length; row++) {

			for (int col = 0; col < mat[0].length; col++) {

				System.out.print(" " + mat[row][col]);
			}
			System.out.println();
		}

	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		// merge O's on left & right boarder
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				
				board[i][0]='#';
			}

			if (board[i][n - 1] == 'O') {
				
				board[i][n-1]='#';
			}
		}

		// merge O's on top & bottom boarder
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				//merge(board, 0, j);
				board[0][j] ='#';
			}

			if (board[m - 1][j] == 'O') {
				//merge(board, m - 1, j);
				board[m - 1][j] ='#';
			}
		}

		// process the board
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
		
		print(board);
	}

	public static void merge(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;

		if (board[i][j] != 'O')
			return;

		board[i][j] = '#';

		merge(board, i - 1, j);
		merge(board, i + 1, j);
		merge(board, i, j - 1);
		merge(board, i, j + 1);
	}

	public static void main(String[] args) {
		char[][] m = { { 'O', 'O', 'O', 'O',  }, { 'O', 'O', 'O', 'O',  }, { 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O',  }, { 'O', 'O', 'O', 'O',  } };

		int row = m.length - 1;

		int col = m[0].length - 1;

		/*for (int r = 1; r <= row - 1; r++) {
			for (int c = 1; c <= col - 1; c++) {

				if (m[r][c] == 'O') {
					m[r][c] = 'X';
				}

			}

		}*/

		
		solve(m);
		//print(m);
		// surroundedRegion(m);
		// print(m);
	}

}
