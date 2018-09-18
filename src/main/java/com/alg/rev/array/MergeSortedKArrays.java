package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedKArrays {

	public class ArrayContainer implements Comparable<ArrayContainer> {

		private List<Integer> elements;
		private int index;

		public ArrayContainer(List<Integer> elements, int indx) {
			this.elements = elements;
			this.index = indx;
		}

		public int compareTo(ArrayContainer inputContainer) {

			return this.elements.get(this.index) - inputContainer.elements.get(inputContainer.index);
		}

	}

	public List<Integer> mergeKList(List<List<Integer>> kList) {

		List<Integer> result = new LinkedList<Integer>();

		PriorityQueue<ArrayContainer> q = new PriorityQueue<ArrayContainer>();

		for (List<Integer> oneList : kList) {
			ArrayContainer arrayContainer = new ArrayContainer(oneList, 0);
			q.add(arrayContainer);

		}

		while (!q.isEmpty()) {

			ArrayContainer ele = q.poll();

			result.add(ele.elements.get(ele.index));
			if (ele.index < ele.elements.size()-1) {

				ArrayContainer arrayContainer = new ArrayContainer(ele.elements, ele.index + 1);
				q.add(arrayContainer);
			}

		}

		return result;

	}

	public static void main(String[] args) {
		MergeSortedKArrays mergeSortedKArrays = new MergeSortedKArrays();

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);

		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(0);
		list3.add(9);
		list3.add(10);
		list3.add(11);

		List<List<Integer>> kList = new ArrayList<List<Integer>>();
		kList.add(list1);
		kList.add(list2);
		kList.add(list3);
		System.out.println(mergeSortedKArrays.mergeKList(kList));

	}

}
