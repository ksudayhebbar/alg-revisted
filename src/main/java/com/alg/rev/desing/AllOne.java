package com.alg.rev.desing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AllOne {

	/*Map<String, Integer> counter;
	Map<Integer, List<String>> maxCounter;
	Map<Integer, List<String>> minCounter;

	*//** Initialize your data structure here. *//*
	public AllOne() {
		counter = new HashMap<String, Integer>();
		maxCounter = new TreeMap<Integer, List<String>>(Collections.reverseOrder());
		minCounter = new TreeMap<Integer, List<String>>();
	}

	*//** Inserts a new key <Key> with value 1. Or increments an existing key by 1. *//*
	public void inc(String key) {
		
		 * int count=1; if(counter.get(key)!=null) { count =counter.get(key);
		 * counter.put(key,counter.getOrDefault(key,1)+1); }else { }
		 

		if (maxCounter.get(counter.get(key)) != null) {

			maxCounter.remove(counter.get(key)).remove(key);
			minCounter.remove(counter.get(key)).remove(key);
			if (maxCounter.get(counter.get(key) + 1) != null) {
				maxCounter.get(counter.get(key) + 1).add(key);
				minCounter.get(counter.get(key) + 1).add(key);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(key);
				maxCounter.put(1, temp);
				minCounter.put(1, temp);
			}

		}
		counter.put(key, counter.getOrDefault(key, 1) + 1);

	}

	*//**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the data
	 * structure.
	 *//*
	public void dec(String key) {
		if (maxCounter.get(counter.get(key)) != null) {

			maxCounter.remove(counter.get(key)).remove(key);
			minCounter.remove(counter.get(key)).remove(key);
			if (maxCounter.get(counter.get(key) - 1) != null) {
				maxCounter.get(counter.get(key) - 1).add(key);
				minCounter.get(counter.get(key) - 1).add(key);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(key);
				maxCounter.put(1, temp);
				minCounter.put(1, temp);
			}

		}
		counter.put(key, counter.getOrDefault(key, 1) - 1);
		if (counter.get(key) == 0) {
			if (maxCounter.get(counter.get(key)) != null) {
				maxCounter.remove(counter.get(key)).remove(key);
				minCounter.remove(counter.get(key)).remove(key);
			}

		}
	}

	*//** Returns one of the keys with maximal value. *//*
	public String getMaxKey() {
		maxCounter.
	}

	*//** Returns one of the keys with Minimal value. *//*
	public String getMinKey() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
