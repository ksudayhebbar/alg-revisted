package com.alg.rev.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

	public static boolean search(String s, char[][] grid) {
		boolean retValue = false;
		int[][] visted = new int[grid.length][grid[0].length];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				visted[r][c] = -1;
			}

		}

		for (Character c : s.toCharArray()) {
			for (int r = 0; r < grid.length; r++) {
				for (int col = 0; col < grid[0].length; col++) {
					visted[r][col] = -1;
				}

			}
			retValue = search(grid, 0, 0, c, visted);

			if (!retValue) {
				return retValue;
			}

		}

		return retValue;

	}

	private static boolean dfs(char[][] grid, String word, int row, int col, int stringLen) {
		if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
			return false;
		}
		if (stringLen == word.length() - 1) {
			return true;
		}
		if (grid[row][col] == word.charAt(stringLen)) {
			char tempChar = grid[row][col];
			grid[row][col] = '#';

			if (dfs(grid, word, row + 1, col, stringLen + 1) || dfs(grid, word, row - 1, col, stringLen + 1)
					|| dfs(grid, word, row, col + 1, stringLen + 1) || dfs(grid, word, row, col - 1, stringLen + 1)) {
				return true;
			}
			grid[row][col] = tempChar;

		}
		return false;

	}

	private static boolean search(char[][] grid, int r, int c, Character s, int[][] visted) {

		if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || visted[r][c] == 1) {
			return false;
		}
		visted[r][c] = 1;
		if (grid[r][c] != s) {

			if (search(grid, r + 1, c, s, visted)) {
				return true;
			} else if (search(grid, r - 1, c, s, visted)) {
				return true;
			} else if (search(grid, r, c + 1, s, visted)) {
				return true;
			} else if (search(grid, r, c + -1, s, visted)) {
				return true;
			} else {
				return false;
			}

		} else {
			grid[r][c] = '#';
			return true;
		}

	}

	public static void main(String[] args) {
		char[][] m = { { 'A', 'B', 'C', 'E' },

				{ 'S', 'F', 'C', 'S' },

				{ 'A', 'D', 'E', 'E' }

		};
	//	System.out.println(search("ABCB", m));

	//	System.out.println(dfs(m, "ABCB", 0, 0, 0));

		char[][] b = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };

		String[] w = { "oath", "pea", "eat", "rain" };

		WordSearch ws = new WordSearch();
		List<String> findWords = ws.findWords(b, w);
		System.out.println(findWords);
		
	}

	Set<String> result = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		// HashSet<String> result = new HashSet<String>();

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(result);
	}

	public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (visited[i][j])
			return;

		str = str + board[i][j];

		if (!trie.startsWith(str))
			return;

		if (trie.search(str)) {
			result.add(str);
		}

		visited[i][j] = true;
		dfs(board, visited, str, i - 1, j, trie);
		dfs(board, visited, str, i + 1, j, trie);
		dfs(board, visited, str, i, j - 1, trie);
		dfs(board, visited, str, i, j + 1, trie);
		visited[i][j] = false;
	}
}

// Trie Node
class TrieNode {
	public TrieNode[] children = new TrieNode[26];
	public String item = "";
}

// Trie
class Trie {
	public TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		if (node.item.equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		return true;
	}
}
