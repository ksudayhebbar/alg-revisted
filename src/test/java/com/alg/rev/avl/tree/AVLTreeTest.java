package com.alg.rev.avl.tree;

import org.junit.Test;

public class AVLTreeTest {

	@Test
	public void insertTest() {

		int a[] = { 4, 3, 7, 6, 8, 5 };
		AVLTree avlTree = new AVLTree();
		for (int value : a) {
			avlTree.insert(value);
		}

		avlTree.display();
	}

}
