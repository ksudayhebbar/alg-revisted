package com.alg.rev.avl.tree;

public class AVLTree {
	private int data;
	private int hight;
	private AVLTree left;
	private AVLTree right;
	private AVLOperation operation;

	public AVLTree() {
		super();
		this.operation = new AVLOperation();
	}

	public AVLTree(int data, int hight, AVLTree left, AVLTree right) {

		this();
		this.data = data;
		this.hight = hight;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public AVLTree getLeft() {
		return left;
	}

	public void setLeft(AVLTree left) {
		this.left = left;
	}

	public AVLTree getRight() {
		return right;
	}

	public void setRight(AVLTree right) {
		this.right = right;
	}

	public class AVLOperation {

		private AVLTree root;

		public AVLOperation() {

		}

		public AVLTree getRoot() {
			return root;
		}

		public AVLTree singleRotateLeft(AVLTree X) {
			AVLTree W = X.getLeft();
			if (W != null) {
				X.setLeft(W.getRight());
				W.setRight(X);
				X.setHight(Math.max(hight(X.getLeft()), hight(X.getRight())) + 1);
				W.setHight(Math.max(hight(W.getLeft()), X.getHight()) + 1);
			}
			return W;

		}

		private int hight(AVLTree node) {
			int hight = -1;
			if (node == null) {
				return hight;
			} else {
				hight = node.getHight();
			}
			return hight;
		}

		public AVLTree singleRotateRight(AVLTree W) {
			AVLTree X = W.getRight();
			if (X != null) {
				W.setRight(X.getLeft());
				X.setLeft(W);
				X.setHight(Math.max(hight(X.getRight()), W.getHight()) + 1);
				W.setHight(Math.max(hight(X.getRight()), hight(W.getLeft())) + 1);
			}
			return X;

		}

		public AVLTree doubleRotateLeft(AVLTree Z) {
			Z.setLeft(singleRotateRight(Z.getLeft()));

			return singleRotateLeft(Z);
		}

		public AVLTree doubleRoataeRight(AVLTree Y) {
			Y.setRight(singleRotateLeft(Y.getRight()));
			return singleRotateLeft(Y);

		}

		public AVLTree insert(AVLTree root, AVLTree parent, int data) {

			if (root == null) {

				root = new AVLTree(data, 0, null, null);

			} else if (data < root.getData()) {
				root.setLeft(insert(root.getLeft(), root, data));
				if (hight(root.getLeft()) - hight(root.getRight()) == 2) {
					if (data < root.getLeft().getData()) {
						root = singleRotateLeft(root);
					} else {
						root = doubleRotateLeft(root);
					}
				}

			} else if (data > root.getData()) {
				root.setRight(insert(root.getRight(), root, data));
				if (hight(root.getRight()) - hight(root.getLeft()) == 2) {
					if (data < root.getRight().getData()) {
						root = singleRotateRight(root);
					} else {
						root = doubleRoataeRight(root);
					}
				}
			}
			root.setHight(Math.max(hight(root.getLeft()),
					hight(root.getRight())) + 1);

			return root;
		}

		public void setRoot(AVLTree root2) {
			this.root = root2;

		}
	}

	public void insert(int data) {
		AVLTree root = operation.insert(operation.getRoot(),
				operation.getRoot(), data);
		if (operation.getRoot() == null) {
			operation.setRoot(root);
		}
	}

	public void display() {
		inorder(operation.getRoot());
	}

	private void inorder(AVLTree root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}
}
