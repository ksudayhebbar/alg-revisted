package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructQueue {
	public static int[][] reconstructQueue(int[][] people) {
		if (people.length == 0 || people[0].length == 0)
			return people;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				return o2[0]-o1[0];
			}
		});
		for (int[] person : people) {
			pq.offer(person);
		}

		List<int[]> list = new ArrayList<>();
		while (!pq.isEmpty()) {

			int[] person = pq.poll();
			list.add(person[1], person);
		}
		return list.toArray(new int[people.length][people[0].length]);

	}

	public static void main(String[] args) {
		int[][] a = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		System.out.println(reconstructQueue(a));
	}

}
