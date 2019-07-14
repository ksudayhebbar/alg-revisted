package com.alg.rev.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
	public static int shortestDistance(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int distance[][] = new int[row][col];
		int reach[][] = new int[row][col];
		int buildingNum = 0;

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int level = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					buildingNum++;
					q.add(new int[] { i, j });
					level = 1;
					boolean[][] visted = new boolean[row][col];
					while (!q.isEmpty()) {

						for (int k = 0; k < q.size(); k++) {
							int[] start = q.remove();
							for (int[] d : dirs) {
								int x = start[0] + d[0];
								int y = start[1] + d[1];
								if (x >= 0 && y >= 0 && x < row && y < col && !visted[x][y] && grid[x][y] == 0) {
									q.add(new int[] { x, y });
									visted[x][y] = true;
									distance[x][y] += level;
									reach[x][y]++;
								}

							}
								
						}
						level++;
					}

				}
			}
		}

		int shotest = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0 && reach[i][j] == buildingNum) {

					shotest= Math.min(shotest, distance[i][j]);
				}
			}
		}

		return shotest == Integer.MAX_VALUE ? -1 : shotest;
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		shortestDistance(a);
	}

}
