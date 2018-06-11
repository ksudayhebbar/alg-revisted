package com.alg.rev.matrix;

public class SerachMartrix {

	public static boolean serach(int m[][], int targaet) {
		boolean bresult = false;
		int row = m.length;
		int col = m[0].length;

		int start = 0;
		int end = row * col - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / row;
			int midY = mid % row;

			if (m[midX][midY] == targaet)
				return true;

			if (m[midX][midY] < targaet) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return bresult;

	}

	public static void main(String[] args) {
		int m[][] = { 
				{ 1, 3, 5, 7 }, 
				{ 10, 11, 16, 20 }, 
				{ 23, 30, 34, 50 },
				{ 60, 90, 91, 100 } };

		 System.out.println(serach(m,100));

	}

}
