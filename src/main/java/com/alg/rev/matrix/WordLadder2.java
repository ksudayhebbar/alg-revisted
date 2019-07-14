package com.alg.rev.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder2 {
	public Trie t = new Trie();
	public Set<String> ret = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		int visted[][] = new int[board.length][board[0].length];
		for (String word : words) {
			t.insert(word);
		}
		for (int r = 0; r < board.length; r++) {

			for (int c = 0; c < board[0].length; c++) {

				dfs(board, "", visted, r, c);

			}
		}
		return new ArrayList<String>(ret);
	}

	private void dfs(char[][] board, String word, int[][] visted, int r, int c) {
		if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || visted[r][c] == 1) {
			return;
		}
		visted[r][c] = 1;
		word += board[r][c];
		if (!t.startsWith(word)) {
			return;
		}
		if (t.search(word)) {
			ret.add(word);
			return;
		}
		dfs(board, word, visted, r - 1, c);
		dfs(board, word, visted, r + 1, c);
		dfs(board, word, visted, r, c - 1);
		dfs(board, word, visted, r, c + 1);
		visted[r][c] = 0;

	}

	public class Trie {
		public TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');

		}

		public void insert(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				TrieNode temp = cur.findChildern(word.charAt(i));
				if (temp != null) {
					cur = cur.findChildern(word.charAt(i));
				} else {
					TrieNode newNode = new TrieNode(word.charAt(i));
					cur.childrens.add(newNode);
					cur = cur.findChildern(word.charAt(i));
				}
				if (i == word.length() - 1) {
					cur.isEnd = true;
				}

			}

		}

		public boolean search(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				if (cur != null) {
					cur = cur.findChildern(word.charAt(i));
					if (cur != null && cur.isEnd == true) {
						return true;

					}
				}

			}

			return false;
		}

		public boolean startsWith(String word) {
			TrieNode cur = root;
			int index = 0;
			for (int i = 0; i < word.length(); i++) {
				if (cur != null) {
					cur = cur.findChildern(word.charAt(i));
					index++;
				}

			}

			return index != 0;
		}
	}

	public class TrieNode {
		public Character c;
		public List<TrieNode> childrens;
		public boolean isEnd;

		public TrieNode(char c) {
			this.c = c;
			this.childrens = new ArrayList<TrieNode>();
		}

		public TrieNode findChildern(char c) {

			for (TrieNode child : childrens) {

				if (child.c.equals(c)) {
					return child;
				}
			}
			return null;
		}

	}

	public static void main(String[] args) {
		char[][] b = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		WordLadder2 w = new WordLadder2();
		w.findWords(b, new String[] { "oath", "pea", "eat", "rain" });

	}

}
