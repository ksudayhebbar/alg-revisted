package com.alg.rev.array;

import java.util.Arrays;
import java.util.Comparator;

public class BustBollon {
	public static int findMinArrowShots(int[][] points) {
		int count = 0;
		Arrays.sort(points, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		int arrow = Integer.MIN_VALUE;

		for (int i = 0; i < points.length; i++) {

			if (arrow != Integer.MIN_VALUE && points[i][0] <= arrow)
				continue;

			arrow = points[i][1];
			count++;

		}
		return count;

	}

	public static void main(String[] args) {
		int [][]a={{10,16}, {2,8}, {1,6}, {7,12}};
		findMinArrowShots(a);

	}

}
