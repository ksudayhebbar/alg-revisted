package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKElement {

	public static List<Integer> findTopKelement(int[] num, int k) {
		List<Integer> result = null;
		if (num != null) {
			result = new ArrayList<Integer>();
			Map<Integer, Integer> counter = new TreeMap<Integer, Integer>();
			for (int no : num) {

				if (counter.get(no) != null) {
					counter.put(no, counter.get(no) + 1);
				} else {
					counter.put(no, 1);
				}

			}

			Map<Integer, Integer> arranger = new TreeMap<Integer, Integer>(new ValueCompare(counter));
			arranger.putAll(counter);
			int kthElement = 0;
			for (Map.Entry<Integer, Integer> value : arranger.entrySet()) {
				if (kthElement != k) {
					result.add(value.getKey());
					kthElement++;
				} else {
					return result;
				}

			}

		}

		return result;

	}

	public static class ValueCompare implements Comparator<Integer> {
		Map<Integer, Integer> tempcounter = new TreeMap<Integer, Integer>();

		public ValueCompare(Map<Integer, Integer> counter) {
			tempcounter.putAll(counter);
		}

		public int compare(Integer o1, Integer o2) {
			int diff = tempcounter.get(o2) - tempcounter.get(o1);
			if (diff == 0) {

				return 0;

			}

			return diff;
		}

	}

	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 2, 2, 3, 4, 6, 7, 7, 8, 9, 4, 6, 6, 6, 6, 6, 4 };

		System.out.println(findTopKelement(num, 3));

	}

}
