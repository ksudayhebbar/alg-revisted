package com.alg.rev.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		/*
		 * int i = 0; while (i < 10) { int t = random.nextInt(100);
		 * heapSoultion.addNum(t);
		 * 
		 * System.out.println(heapSoultion.findMedian()); }
		 */
		heapSoultion.topKFrequentWords(
				new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
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

	public List<String> topKFrequentWords(String[] words, int k) {

		List<String> retList = new ArrayList<String>();
		Map<String, Integer> counter = new HashMap<String, Integer>();

		for (String S : words) {
			counter.put(S, counter.getOrDefault(S, 1) + 1);
		}

		PriorityQueue<String> heap = new PriorityQueue<String>(new ValueCompare(counter));

		for (String s : counter.keySet()) {
			heap.offer(s);

		}
		
		while (k > 0) {

			retList.add(heap.poll());
			k--;

		}
		return retList;

	}

	public class ValueCompare implements Comparator<String> {
		private Map<String, Integer> sorter = new HashMap<String, Integer>();

		public ValueCompare(Map<String, Integer> counter) {
			sorter.putAll(counter);
		}

		public int compare(String o1, String o2) {
			if (sorter.get(o2) != sorter.get(o1)) {
				return sorter.get(o2) - sorter.get(o1);
			} else {

				return o1.compareTo(o2);
			}

		}

	}

}
