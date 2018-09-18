package com.alg.rev.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class HeapSoultion {

	PriorityQueue<Integer> maxHeap;// lower half
	PriorityQueue<Integer> minHeap;// higher half

	public HeapSoultion() {
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int number) {

		maxHeap.add(number);

		minHeap.add(maxHeap.poll());

		if (maxHeap.size() < minHeap.size()) {

			maxHeap.add(minHeap.poll());
		}

	}

	public int findMedian() {

		if (maxHeap.size() == minHeap.size()) {
			return maxHeap.peek() + minHeap.peek() / 2;
		} else {
			return maxHeap.peek();
		}

	}

	public int mettingRooms(List<Interval> interval) {

		int roomCount = 0;

		PriorityQueue<Interval> q = new PriorityQueue<Interval>();

		q.add(interval.get(0));

		for (int i = 1; i < interval.size(); i++) {

			if (interval.get(i).getStart() < q.peek().getEnd()) {
				roomCount++;

			} else {
				q.poll();
			}
			q.add(interval.get(i));
		}

		return roomCount;

	}

	public static void main(String[] args) {

		Random random = new Random();
		HeapSoultion heapSoultion = new HeapSoultion();
		int i = 0;
		while (i < 10) {
			int t = random.nextInt(100);
			heapSoultion.addNum(t);

			System.out.println(heapSoultion.findMedian());
		}

	}

	public class Interval implements Comparable<Interval> {

		public int start;

		public int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int compareTo(Interval o) {

			return this.getStart() - o.getStart();
		}

	}

	

}
