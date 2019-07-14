package com.alg.rev.string;

import java.util.ArrayList;
import java.util.List;

public class Lca {
	public static void main(String[] args) {
		Lca lca = new Lca();
		//System.out.println(lca.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		//System.out.println(lca.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(lca.longestCommonPrefix(new String[] { "a" }));
	}

	public String longestCommonPrefix(String[] strs) {
		Trie trie = new Trie();
		String s = "";
		int maxCharCount = Integer.MAX_VALUE;
		trie.search(strs[0]);
		for (int i = 0; i < strs.length; i++) {

			int charCount = trie.search(strs[i]);
			if (charCount != 0) {
				maxCharCount = Math.min(maxCharCount, charCount);
				s = strs[i].substring(0, maxCharCount);

			}
		}
		return s;
	}

	public class Trie {

		private TrieNode root;

		public Trie() {
			super();
			this.root = new TrieNode(' ');

		}

		public boolean add(String words) {

			TrieNode current = root;
			int count = 0;
			for (Character c : words.toCharArray()) {

				TrieNode temp = current.searchChild(c);

				if (temp == null) {
					TrieNode newNode = new TrieNode(c);
					current.getChildren().add(newNode);
					current = current.searchChild(c);

				} else {
					current = current.searchChild(c);
				}
				if (count == words.length()) {
					current.setEnd(true);
				}

			}
			return false;

		}

		public int search(String words) {
			TrieNode current = root;
			int charMatched = 0;
			for (Character c : words.toCharArray()) {
				if (current != null) {
					current = current.searchChild(c);
				}
				if (current != null && !current.isEnd()) {
					charMatched++;
				}

			}

			if (charMatched == 0) {
				add(words);
			}

			return charMatched;

		}

	}

	public class TrieNode {

		private Character c;
		private List<TrieNode> children;
		private boolean end;

		public TrieNode(Character c) {
			this.c = c;
			children = new ArrayList<TrieNode>();

		}

		public TrieNode searchChild(Character c) {

			for (TrieNode t : children) {

				if (t.c.equals(c)) {

					return t;
				}
			}

			return null;

		}

		public List<TrieNode> getChildren() {

			return children;
		}

		public void setEnd(boolean e) {

			end = e;
		}

		public boolean isEnd() {

			return end;
		}

	}
}
