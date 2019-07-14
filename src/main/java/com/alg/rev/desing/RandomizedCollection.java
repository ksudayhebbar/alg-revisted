package com.alg.rev.desing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {
	private Map<Integer, List<Integer>> loc;
	private Random rnd;
	private List<Integer> data;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		loc = new HashMap<Integer, List<Integer>>();
		data = new ArrayList<Integer>();
		this.rnd = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean allreadyContains = loc.containsKey(val);
		if (!allreadyContains) {
			loc.put(val, new ArrayList());
		}

		loc.get(val).add(data.size());
		data.add(val);

		return !allreadyContains;

	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained
	 * the specified element.
	 */
	public boolean remove(int val) {

		boolean allreadyContains = loc.containsKey(val);
		if (!allreadyContains)
			return false;

		List<Integer> indexes = loc.get(val);
		if (!indexes.isEmpty()) {
			int index = indexes.get(0);

			if (index < data.size() - 1) {

				int lastOne = data.get(data.size() - 1);
				insert(lastOne);
				data.remove(data.size() - 1);
				loc.get(val).remove(0);

			} else {
				data.remove(data.size() - 1);
				loc.remove(val);
			}
			return true;
		} else {

			loc.remove(val);

		}

		return false;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return data.get(rnd.nextInt(data.size()));
	}

	public static void main(String[] args) {
		RandomizedCollection r=new RandomizedCollection();
		System.out.println(r.insert(-1));
		System.out.println(r.remove(-2));
		System.out.println(r.insert(-2));
		System.out.println(r.getRandom());
		System.out.println(r.remove(-1));
		System.out.println(r.insert(-2));
		System.out.println(r.getRandom());
	}

}
