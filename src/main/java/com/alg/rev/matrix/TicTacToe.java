package com.alg.rev.matrix;

public class TicTacToe {

	public int[][] board;
	public int brow;
	public int bcol;

	public TicTacToe(int row, int col) {
		// TODO Auto-generated constructor stub
		this.board = new int[row][col];
		this.brow = row;
		this.bcol = col;
	}

	public int move(int row, int col, int player) {
		boolean win = true;
		if (row < 0 || row > brow || col > bcol || col < 0) {

			throw new ArrayIndexOutOfBoundsException("Invaild boundray");
		}
		if (board[row][col] == -1) {
			board[row][col] = player;
		} else {
			return 0;

		}

		for (int c = 0; c < bcol; c++) {

			if (board[row][c] != player) {
				win = false;

			}

		}

		if (win)
			return player;

		for (int r = 0; r < brow; r++) {

			if (board[r][col] != player) {
				win = false;

			}

		}

		if (win)
			return player;

		for (int r = 0; r < brow; r++) {

			if (board[r][r] != player) {
				win = false;

			}

		}

		if (win)
			return player;

		for (int r = 0; r < brow; r++) {

			if (board[r][bcol - 1] != player) {
				win = false;

			}

		}

		if (win)
			return player;

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
