package com.alg.rev.string.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private Node root;

	public Trie() {
		this.root = new Node(' ');
	}

	public void insert(String input) {

		Node curent = root;
		int count = 0;
		for (Character c : input.toCharArray()) {

			Node childNode = curent.findSubNode(c);

			if (childNode != null && childNode.isEnd()) {
				curent = childNode;

			} else {

				curent.getNodes().add(new Node(c));
				curent = curent.findSubNode(c);

			}

			count++;
			if (count == input.length()) {
				curent.isEnd = true;
			}
		}

	}

	public boolean search(String value) {
		Node curent = root;
		
		for (Character c : value.toCharArray()) {
			Node childNode = curent.findSubNode(c);
			if (childNode != null) {
				curent = childNode;
			} else {
				return false;
			}
		}
		if (curent.isEnd) {
			return true;
		}
		return false;

	}

	private class Node {

		private Character data;
		private boolean isEnd;
		private List<Node> nodes = new ArrayList<Node>();

		public Node(Character c) {
			this.data = c;
			this.isEnd = false;
		}

		public Node findSubNode(Character c) {

			for (Node chidNode : nodes) {
				if (chidNode.data.equals(c)) {
					return chidNode;
				}
			}

			return null;

		}

		public Character getData() {
			return data;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public List<Node> getNodes() {
			return nodes;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", isEnd=" + isEnd + ", nodes=" + nodes + "]";
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("a");
		trie.insert("all");
		trie.insert("als");
		trie.insert("alss");
		System.out.println(trie.search("a"));
		System.out.println(trie.search("al"));
		System.out.println(trie.search("all"));
		System.out.println(trie.search("alll"));
		System.out.println(trie.search("als"));
		System.out.println(trie.search("alss"));
	}
}
