package com.alg.rev.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate {
	public static void wallsAndGates(int[][] rooms) {
		int rows = rooms.length;
		int cols = rooms[0].length;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {

				if (rooms[r][c] == 0) {
					int[] cell = new int[2];
					cell[0] = r;
					cell[1] = c;
					q.add(cell);
				}

			}
		}

		int x[] = { 1, 0, -1, 0 };
		int y[] = { 0, -1, 0, 1 };
		while (!q.isEmpty()) {

			int[] cell = q.remove();

			for (int d = 0; d < 4; d++) {

				int r = cell[0] + x[d];
				int c = cell[1] + y[d];

				if (r >= 0 && c >= 0 && r < rows && c < cols) {

					if (rooms[r][c] == Integer.MAX_VALUE) {

						rooms[r][c] = rooms[cell[0]][cell[1]] + 1;
						int newCell[] = new int[2];
						newCell[0] = r;
						newCell[1] = c;
						q.add(newCell);
					}

				}

			}

		}

	}

	public static void main(String[] args) {
		int INF = Integer.MAX_VALUE;
		int[][] r = { { INF, -1, 0, INF }, 
				{ INF, INF, INF, -1 }, 
				{ INF, -1, INF, -1 }, 
				{ 0, -1, INF, INF }

		};
		wallsAndGates(r);
	}

}
