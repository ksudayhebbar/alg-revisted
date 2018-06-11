package com.alg.rev.matrix;

public class ConectedCompontent {
	public static int countComponents(int n, int[][] edges) {

		int root[] = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}
		int count = n;
		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			int xRoot = getRoot(root, x);
			int yRoot = getRoot(root, y);
			if (xRoot != yRoot) {
				count--;
				root[xRoot] = yRoot;
			}

		}

		return count;
	}

	public static int getRoot(int[] arr, int i) {
		while (arr[i] != i) {
			arr[i] = arr[arr[i]];
			i = arr[i];
		}
		return i;
	}

	public static void main(String[] args) {
		int[][] e = { { 0, 1}, { 1, 2 }, { 3,4 } };

		System.out.println(countComponents(5, e));

	}

}
