package com.alg.rev.matrix;

import java.util.Stack;

public class LargestRectangle {

	public static int area(int[][] grid) {
		int row = grid.length;

		int col = grid[0].length;

		int height[][] = new int[row][col];

		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {
				if (grid[r][c] != 0) {
					height[r][c] = r == 0 ? 1 : height[r - 1][c] + 1;
				}
			}
		}

		print(height);
		int maxArea=0;
		for (int r= 0; r< row; r++) {
			int area = maxAreaInHist(height[r]);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;

	}
	

	private static int maxAreaInHist(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
	 
		int i = 0;
		int max = 0;
	 
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				max = Math.max(max, height[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
	 
		return max;
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
		int[][] m = {
				{ 0, 1, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 } };
		area(m);

	}

}
