package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLader2 {
	Map<String, List<String>> ajList = new HashMap<String, List<String>>();
	List<List<String>> result = new ArrayList<List<String>>();
	List<String> tracker = new ArrayList<String>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord))
			return null;

		Queue<String> q = new LinkedList<String>();
		Set<String> visted = new HashSet<String>();
		Set<String> unvisted = new HashSet<String>(wordList);

		q.add(beginWord);

		visted.add(beginWord);
	
		int cur = 1;
		int next = 0;
		boolean found = false;
		while (!q.isEmpty()) {
			String pop = q.remove();
			cur--;
			
			for (int i = 0; i < pop.length(); i++) {
				StringBuilder builder=new StringBuilder(pop);
				for (char oneChar = 'a'; oneChar <= 'z'; oneChar++) {
					builder.setCharAt(i, oneChar);
					String newWord = new String(builder);
					if (unvisted.contains(newWord)) {
						visted.add(newWord);
						q.add(newWord);
						next++;

						if (ajList.get(newWord) != null) {
							ajList.get(newWord).add(pop);

						} else {
							List<String> temp = new ArrayList<String>();
							temp.add(pop);
							ajList.put(newWord, temp);
						}

						if (newWord.equals(endWord) && !found) {
							found = true;
						}
					}
				}

			}

			if (cur == 0) {
				if (found)
					break;
				unvisted.removeAll(visted);
				visted.clear();
				cur = next;
				next = 0;
			}

		}

		backtrack( endWord,beginWord);

		return result;
	}

	private void backtrack(String start, String end) {
		if (start.equals(end)) {
			tracker.add(0, start);
			result.add(new ArrayList<String>(tracker));
			tracker.remove(0);
			return;
		}
		tracker.add(0, start);
		if (ajList.get(start) != null) {
			List<String> words = ajList.get(start);
			for (String word : words) {
				backtrack(word, end);

			}
			tracker.remove(0);
		}

	}

	public static void main(String[] args) {
		WordLader2 w = new WordLader2();
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		w.findLadders("hit", "cog", wordList);

	}

}
