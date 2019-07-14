package com.alg.rev.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallest {
	public static int kthSmallest(int[][] matrix, int k) {

		Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {

				return o1 - o2;
			}

		});
		int row = matrix.length;
		int col = matrix[0].length;

		for (int r = 0; r < col; r++) {
			for (int c = 0; c < col; c++) {

				pq.offer(matrix[r][c]);
			}

		}
		int ret = -1;
		while (k > 0) {
			ret = pq.poll();
			k--;
		}

		return ret;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));
	}

}
