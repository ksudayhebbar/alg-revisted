package com.alg.rev.matrix;

public class SerachMartrix {

	public static boolean serach(int m[][], int targaet) {
		boolean bresult = false;
		int row = m.length;
		int col = m[0].length;

		int start = 0;
		int end = row * col - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			int midX = mid / row;
			int midY = mid % row;
			if (midX > 0 && midY > 0 && midX < row && midY < col) {
				if (m[midX][midY] == targaet)
					return true;

				if (m[midX][midY] < targaet) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				start++;
				end--;
			}
		}

		return bresult;

	}

	public static void main(String[] args) {
		/*
		 * int m[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 }, { 60,
		 * 90, 91, 100 } };
		 */
		int m[][] = { { 1 ,1} };
		System.out.println(searchMatrix(m, 2));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		if (matrix == null | matrix.length == 0)
			return false;
		int lookUp = Math.min(matrix.length, matrix[0].length);

		for (int i = 0; i < lookUp; i++) {

			boolean v = search(matrix, true, i, target);
			boolean h = search(matrix, false, i, target);
			if (v || h) {

				return true;
			}
		}

		return false;
	}

	public static boolean search(int[][] matrix, boolean vertical, int i, int target) {
		int left = i;
		int right = vertical ? matrix[0].length - 1 : matrix.length-1;

		while (left <right) {
			int mid = (right + left) / 2;
			if (vertical) {
				if (matrix[left][mid] == target) {
					return true;
				}

				if (matrix[left][mid] < target) {
					left = mid + 1;
				} else {

					right = mid - 1;
				}

			} else {
				if (matrix[mid][left] == target) {
					return true;
				}

				if (matrix[mid][left] < target) {
					left = mid + 1;
				} else {

					right = mid - 1;
				}
			}

		}

		return false;

	}

}
