package com.alg.rev.string.trie;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {

	private TNode root = null;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TNode(' ');
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			TNode temp = cur.findChild(c);

			if (temp == null) {

				TNode newNode = new TNode(c);
				cur.childs.add(newNode);
				cur = cur.findChild(c);

			} else {

				cur = cur.findChild(c);
			}

			if (i == word.length() - 1) {
				cur.isEnd = true;

			}

		}

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {

		return search(word.toCharArray(), 0, root);

	}

	public boolean search(char[] word, int pos, TNode cur)

	{

		if (word.length == pos) {
			if (cur != null && cur.isEnd) {
				return true;
			} else {
				return false;
			}
		}
		if (word[pos] != '.') {
			cur = cur.findChild(word[pos]);
			return search(word, pos + 1, cur);

		} else {
			for (int i = 0; i < cur.childs.size(); i++) {
				cur = cur.childs.get(i);
				if (search(word, pos + 1, cur)) {
					return true;
				}

			}

		}

		return false;

	}

	public class TNode {
		public Character c;
		public List<TNode> childs;
		public boolean isEnd;

		public TNode(Character iC) {

			this.c = iC;
			this.childs = new ArrayList<TNode>();
		}

		public TNode findChild(Character c) {

			for (TNode child : childs) {

				if (child.c.equals(c)) {
					return child;
				}

			}

			return null;
		}

	}

}
