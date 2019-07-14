package com.alg.rev.array.powerset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class CombinationFinder {
	public void powerSet(String prefix, List<String> input, Set<Set<String>> powerSet) {
		//List<String> q = new LinkedList<String>();
		Queue<String> s=new LinkedList<String>();
		List<String> q = new LinkedList<String>(s);
		if (input != null && input.size() < 0) {

			Set<String> resutl = new HashSet<String>();
			resutl.add(prefix);
			powerSet.add(resutl);
			return;
		} else {
			Set<String> resutl = new HashSet<String>();
			resutl.add(prefix);
			powerSet.add(resutl);
			for (int i = 0; i < input.size(); i++)

			{

				String temp = prefix + " " + input.get(i);
				List<String> copyInput = copyArray(input, 0, i);
				List<String> copyInput2 = copyArray(input, i + 1, input.size());
				List<String> merge = merge(copyInput, copyInput2);
				powerSet(temp, merge, powerSet);

			}

		}

	}

	private List<String> copyArray(List<String> inp, int start, int end) {
		List<String> copy = new ArrayList<String>();

		for (int i = start; i < end; i++) {
			copy.add(inp.get(i));
		}

		return copy;

	}

	private List<String> merge(List<String> inp1, List<String> inp2) {

		List<String> copy = new ArrayList<String>();
		copy.addAll(inp1);
		copy.addAll(inp2);
		return copy;
	}

	public Set<Set<String>> powerSet(List<String> input) {

		if (input != null && input.size() < 0) {
			return null;

		} else {

			Set<Set<String>> powerSet = new HashSet<Set<String>>();
			powerSet("", input, powerSet);
			return powerSet;
		}

	}

	public static void main(String[] args) {
		CombinationFinder combinationFinder = new CombinationFinder();
		Set<String> powerSet = new TreeSet<String>();
		List<String> str = new ArrayList<String>();
		str.add("AB");
		str.add("FF");
		str.add("GF");
		Set<Set<String>> powerSet2 = combinationFinder.powerSet(str);

		for (Set<String> set : powerSet2)

		{
			System.out.print("[");
			for (String s : set) {
				System.out.print(s);
			}
			System.out.print("]");
			System.out.println();
		}

		Set<Set<Object>> subsetUsingBitMap = combinationFinder.getSubsetUsingBitMap(str);

		for (Set<Object> set : subsetUsingBitMap)

		{
			System.out.print("[");
			for (Object s : set) {
				System.out.print(s);
			}
			System.out.print("]");
			System.out.println();
		}

	}

	private static Set<Set<Object>> getSubsetUsingBitMap(List<String> str) {

		Set<Set<Object>> result = new HashSet<Set<Object>>();

		int numOfSubsets = 1 << str.size(); // OR Math.pow(2, list.size())

		// For i from 0 to 7 in case of [a, b, c],
		// we will pick 0(0,0,0) and check each bits to see any bit is set,
		// If set then element at corresponding position in a given Set need to
		// be included in a subset.
		for (int i = 0; i < numOfSubsets; i++) {

			Set<Object> subset = new HashSet<Object>();

			int mask = 1; // we will use this mask to check any bit is set in
							// binary representation of value i.

			for (int k = 0; k < str.size(); k++) {

				if ((mask & i) != 0) { // If result is !=0 (or >0) then bit is set.
					subset.add(str.get(k)); // include the corresponding
											// element from a given set in a
											// subset.
				}

				// check next bit in i.
				mask = mask << 1;
			}

			// add all subsets in final result.
			result.add(subset);
		}
		return result;
	}

}
