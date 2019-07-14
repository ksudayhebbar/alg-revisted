package com.alg.rev.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	/** Initialize your data structure here. */
	private Map<Integer, Integer> loc;
	private Random rnd;
	private List<Integer> data;

	public RandomizedSet() {
		loc = new HashMap<Integer, Integer>();
		data = new ArrayList<Integer>();
		this.rnd = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (loc.get(val) != null)
			return false;

		loc.put(val, data.size());
		data.add(val);

		return true;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (loc.get(val) != null) {
			int index = loc.get(val);
			if (index < data.size() - 1) {

				int lastOne = data.get(data.size() - 1);
				data.set(index, lastOne);
				loc.put(lastOne, index);

			}

			data.remove(data.size() - 1);
			loc.remove(val);
			return true;
		}

		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return data.get(rnd.nextInt(data.size()));
	}

	public static void main(String[] args) {
		RandomizedSet randomizedSet=new RandomizedSet();
		randomizedSet.insert(1);
		randomizedSet.insert(2);
		randomizedSet.insert(3);
		randomizedSet.remove(2);
	}

}
