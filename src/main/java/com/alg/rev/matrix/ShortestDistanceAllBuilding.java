package com.alg.rev.matrix;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ShortestDistanceAllBuilding {

	private static int[][] distance;

	private static int[][] numReached;

	public static int shortestDistance(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length ;

		distance = new int[row][col];
		numReached = new int[row][col];
		int numBuilding = 0;
		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {

				if (grid[r][c] == 1) {
					boolean[][] visted = new boolean[row][col];
					Queue<Integer> q = new LinkedBlockingQueue<Integer>();
					bfs(grid, r, c, r, c, 0, visted, q);
					numBuilding++;
				}

			}

		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0 && numReached[i][j] >=1) {
					result = Math.min(result, distance[i][j]);

				}
			}
		}

		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static void bfs(int[][] grid, int r, int c, int r2, int c2, int distanceSoFar, boolean[][] visted,
			Queue<Integer> q) {
		vist(grid, r, c, r2, c2, distanceSoFar, visted, q);
		int n = grid[0].length;
		while (!q.isEmpty()) {

			int size = q.size();
			distanceSoFar++;
			for (int k = 0; k < size; k++) {
				int top = q.poll();
				r2 = top / n;
				c2 = top % n;
				bfs(grid, r, c, r2 -1 , c2, distanceSoFar, visted, q);
				bfs(grid, r, c, r2 +1 , c2, distanceSoFar, visted, q);
				bfs(grid, r, c, r2, c2 -1, distanceSoFar, visted, q);
				bfs(grid, r, c, r2, c2 + 1, distanceSoFar, visted, q);
			}

		}

	}

	private static void vist(int[][] grid, int r, int c, int r2, int c2, int distanceSoFar, boolean[][] visted,
			Queue<Integer> q) {
		int m = grid.length-1;
		int n = grid[0].length;

		if (r2 < 0 || c2 < 0 || r2 >= m || c2 >=n || visted[r2][c2])
			return;

		if ((r != r2 || c != c2) && grid[r2][c2] != 0) {
			return;
		}

		visted[r2][c2] = true;
		numReached[r2][c2]++;
		distance[r2][c2] += distanceSoFar;
		q.offer(r2 * n + c2);

	}

	public static void main(String[] args) {
		int[][] m = { { 1, 0, 2, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, };
		System.out.println(shortestDistance(m));
	}

}
