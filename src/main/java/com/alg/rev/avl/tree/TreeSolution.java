package com.alg.rev.avl.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeSolution {

	public class TreeNode {
		public int value;
		public TreeNode left;

		public TreeNode right;

		public TreeNode next;

		public TreeNode parent;

		public TreeNode(int value) {
			super();
			this.value = value;
		}

		public TreeNode(int value, TreeNode left, TreeNode right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public TreeNode getNext() {
			return next;
		}

		public void setNext(TreeNode next) {
			this.next = next;
		}

		public TreeNode getParent() {
			return parent;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();

			sb.append("Value " + value);
			sb.append(left != null ? " Left :" + left.getValue() : " NULL");
			sb.append(right != null ? " Right  :" + right.getValue() : " NULL");

			return sb.toString();
		}
	}

	public void preOrder(TreeNode root) {

		if (root != null) {

			System.out.println(root.getValue());

			preOrder(root.getLeft());
			preOrder(root.getRight());

		}

	}

	public void preOrder2(TreeNode root) {

		if (root != null) {

			Stack<TreeNode> st = new Stack<TreeNode>();
			st.push(root);
			while (st.isEmpty()) {

				TreeNode temp = st.pop();

				System.out.println(temp.getValue());

				if (temp.getRight() != null) {
					st.push(temp.getRight());
				}

				if (temp.getLeft() != null) {
					st.push(temp.getLeft());
				}

			}

		}

	}

	public void inorder(TreeNode root) {

		if (root != null) {

			Stack<TreeNode> st = new Stack<TreeNode>();

			while (true) {

				while (root != null) {
					st.push(root);

					root = root.getLeft();
				}

				if (st.isEmpty()) {
					break;
				}
				TreeNode pop = st.pop();
				if (pop != null) {
					System.out.println(pop.getValue());

					root = pop.getRight();
				}
			}
		}

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				TreeNode pop = stack.pop();
				res.add(pop.getValue());
			} else {
				if (temp.right != null) {
					stack.push(temp.getRight());
					temp.right = null;
				}
				if (temp.left != null) {
					stack.push(temp.getLeft());
					temp.left = null;
				}
			}
		}
		return res;
	}

	public List<Integer> levelTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();

			if (temp == null) {
				if (q.peek() != null)
					q.add(null);
			} else {
				res.add(temp.getValue());
				if (temp.right != null) {
					q.add(temp.getRight());

				}
				if (temp.left != null) {
					q.add(temp.getLeft());

				}
			}
		}
		return res;
	}

	public List<Integer> verticalOrder(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		q.add(root);
		level.add(0);
		int mxLevel = 0;
		int minlvel = 0;
		Map<Integer, List<Integer>> levelHolder = new HashMap<Integer, List<Integer>>();
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			int templevel = level.poll();

			if (levelHolder.get(templevel) != null) {
				levelHolder.get(templevel).add(temp.getValue());

			} else {
				List<Integer> veticalList = new ArrayList<Integer>();
				veticalList.add(temp.getValue());
				levelHolder.put(templevel, veticalList);

			}

			if (temp.right != null) {
				q.add(temp.getRight());
				level.add(templevel + 1);

			}
			if (temp.left != null) {
				q.add(temp.getLeft());
				level.add(templevel - 1);
			}

		}
		Collection<List<Integer>> values = levelHolder.values();

		List<Integer> result = new ArrayList<Integer>();
		for (List<Integer> v : values) {
			result.addAll(v);
		}

		return result;

	}

	public TreeNode invertBinnaryTree(TreeNode root) {
		if (root.getLeft() != null)
			invertBinnaryTree(root.getLeft());
		if (root.getRight() != null)
			invertBinnaryTree(root.getRight());

		TreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);

		return root;

	}

	public static int counter = 0;

	public int kThSmallestElementR(TreeNode root, int k) {
		int retValue = -1;
		if (root == null)
			return retValue;

		retValue = kThSmallestElementR(root.getLeft(), k);

		if (counter != k) {
			counter++;
			retValue = root.getValue();
		}

		if (counter == k) {
			return retValue;
		} else {

			retValue = kThSmallestElementR(root.getRight(), k);
		}

		return retValue;
	}

	public int kThSmallestElement(TreeNode root, int k) {

		Stack<TreeNode> st = new Stack<TreeNode>();

		TreeNode cur = root;
		while (!st.isEmpty() || cur != null) {

			if (cur != null) {
				st.push(cur);
				cur = cur.getLeft();
			} else {
				TreeNode temp = st.pop();
				k--;
				if (k == 0 && temp != null) {

					return temp.getValue();
				}
				cur = temp.getRight();

			}

		}
		return -1;

	}

	public TreeNode flatenTreeNode(TreeNode root) {

		Stack<TreeNode> st = new Stack<TreeNode>();

		TreeNode cur = root;
		while (!st.isEmpty() || cur != null) {

			if (cur != null && cur.getRight() != null) {
				st.push(cur.getRight());
			}

			if (cur != null && cur.getLeft() != null) {

				cur.setRight(cur.getLeft());
				cur.setLeft(null);
				cur = cur.getRight();
			} else if (!st.isEmpty()) {
				TreeNode temp = st.pop();
				cur.setRight(temp);
				cur = cur.getRight();
			} else if (cur != null) {
				cur = cur.getRight();
			}
		}
		return root;

	}

	public boolean isVaildTree(TreeNode root, int leftValue, int rightValue) {

		if (root != null && root.getValue() < leftValue || root.getValue() > rightValue) {
			return false;
		}

		if (root.getLeft() != null && !isVaildTree(root.getLeft(), leftValue, root.getValue())) {
			return false;
		}
		if (root.getRight() != null && !isVaildTree(root.getRight(), root.getValue(), rightValue)) {

			return false;
		}

		return true;
	}

	public boolean pathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		if (root.getValue() == sum && (root.getLeft() == null && root.getRight() == null)) {

			return true;
		}

		return pathSum(root.getLeft(), sum - root.getValue()) || pathSum(root.getRight(), sum - root.getValue());

	}

	public boolean pathSum2(TreeNode root, int sum) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> pathSum = new LinkedList<Integer>();
		q.add(root);
		pathSum.add(root.getValue());

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			int nodeValue = pathSum.poll();

			if (nodeValue == sum) {
				return true;
			}

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
				pathSum.add(nodeValue + temp.getLeft().getValue());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
				pathSum.add(nodeValue + temp.getRight().getValue());
			}

		}
		return false;

	}

	public int minDepth(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		Queue<Integer> leafCounter = new LinkedList<Integer>();

		q.add(root);

		leafCounter.add(1);

		while (!q.isEmpty()) {

			TreeNode temp = q.poll();
			int count = leafCounter.poll();
			if (temp.getLeft() == null && temp.getRight() == null) {

				return count;

			}
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
				leafCounter.add(count + 1);

			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
				leafCounter.add(count + 1);
			}
		}

		return 0;
	}

	public List<Integer> rigthSideView(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {

				TreeNode temp = queue.poll();

				if (i == 0) {

					result.add(temp.getValue());
				}

				if (temp.getRight() != null) {
					queue.add(temp.getRight());

				}
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());

				}
			}

		}

		return result;

	}

	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

		if (root != null) {
			if (root.getValue() > q.getValue() && root.getValue() < q.getValue()) {
				return root;
			} else if (root.getValue() > q.getValue() && root.getValue() > q.getValue()) {
				return lca(root.getLeft(), p, q);
			} else if (root.getValue() < q.getValue() && root.getValue() < q.getValue()) {
				return lca(root.getRight(), p, q);
			}
		}
		return root;
	}

	public boolean isSymmerticTree(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 != null && root2 != null && root1.getValue() == root2.getValue()) {

			boolean left = isSymmerticTree(root1.getLeft(), root2.getLeft());

			boolean right = isSymmerticTree(root1.getRight(), root2.getRight());

			return left & right;

		}

		return false;
	}

	public boolean isValidSerialization(String preorder) {

		Stack<Character> st = new Stack<Character>();

		for (Character c : preorder.toCharArray()) {
			if (c != ',') {
				st.push(c);

				while (st.size() >= 3 && st.get(st.size() - 1) == '#' && st.get(st.size() - 1) == '#'
						&& st.get(st.size() - 3) != '#') {

					st.remove(st.size() - 1);
					st.remove(st.size() - 1);
					st.remove(st.size() - 1);
					st.add('#');

				}
			}
		}

		if (st.size() == 1 || st.peek().equals('#')) {
			return true;
		}
		return false;

	}

	public TreeNode nextPointer(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		Queue<Integer> level = new LinkedList<Integer>();

		q.add(root);
		level.add(1);

		while (!q.isEmpty()) {

			TreeNode temp = q.poll();
			int l = level.poll();

			if (level.isEmpty()) {
				temp.setNext(null);
			} else if (level.peek() > l) {
				temp.setNext(null);

			} else {

				temp.setNext(q.peek());
			}

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
				level.add(l + 1);
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
				level.add(l + 1);
			}
		}
		return root;

	}

	public TreeNode nextPointer2(TreeNode root) {

		TreeNode lastHead = root;
		TreeNode lastCurent = null;
		TreeNode currentHead = null;
		TreeNode current = null;

		while (lastHead != null) {

			lastCurent = lastHead;

			while (lastCurent != null) {
				if (currentHead == null) {
					currentHead = lastCurent.getLeft();
					current = lastCurent.getLeft();
				} else {
					current.setNext(lastCurent.getLeft());
					current = current.getNext();
				}

				if (currentHead != null) {
					current.setNext(lastCurent.getRight());
					current = current.getNext();
				}

				lastCurent = lastCurent.getNext();

			}
			// update last head
			lastHead = currentHead;
			currentHead = null;
		}
		return root;

	}

	public List<TreeNode> unqiueTree(int n) {

		return unqiueTree(0, n);

	}

	private List<TreeNode> unqiueTree(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {

			list.add(null);
			return list;
		}
		if (start == end) {

			list.add(new TreeNode(start));
			return list;

		}
		List<TreeNode> left;
		List<TreeNode> right;
		for (int s = start; s <= end; s++) {
			left = unqiueTree(start, s - 1);
			right = unqiueTree(s + 1, end);

			for (TreeNode leftn : left) {

				for (TreeNode rightn : right) {

					TreeNode root = new TreeNode(s);
					root.setLeft(leftn);
					root.setRight(rightn);

					list.add(root);
				}

			}

		}
		return list;

	}

	public int sumTOLeaf(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		int left = root.getValue();
		int right = root.getValue();
		int result = 0;
		while (!q.isEmpty()) {

			TreeNode temp = q.poll();
			if (temp.getLeft() == null && temp.getRight() == null)
				result = left + right;
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
				left = left * 10 + temp.getLeft().getValue();
			}

			if (temp.getRight() != null) {
				q.add(temp.getRight());
				right = right * 10 + temp.getRight().getValue();
			}

		}

		return result;

	}

	public int sumTOLeaf(TreeNode root, int x) {

		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null) {

			return x * 10 + root.getValue();
		}

		return sumTOLeaf(root.getLeft(), x * 10 + root.getValue())
				+ sumTOLeaf(root.getRight(), x * 10 + root.getValue());

	}

	public int closestValue(TreeNode root, int traget) {

		Queue<TreeNode> q = new LinkedList<TreeSolution.TreeNode>();

		q.add(root);
		int closest = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();

			if (Math.abs(traget - temp.getValue()) < closest) {
				closest = Math.abs(traget - temp.getValue());

			}

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());

			}

			if (temp.getRight() != null) {
				q.add(temp.getRight());

			}

		}
		return closest;

	}

	public String serialize(TreeNode root) {

		if (root == null)
			return "";

		StringBuffer sb = new StringBuffer();

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		// sb.append(root.getValue() + ",");

		while (!q.isEmpty()) {

			TreeNode temp = q.poll();

			if (temp != null) {
				q.add(temp.getLeft());
				q.add(temp.getRight());
				sb.append(temp.getValue() + ",");
			} else {
				sb.append("#" + ",");
			}

		}

		return sb.substring(0, sb.length() - 1);

	}

	public TreeNode deserialize(String value) {
		if (value == null)
			return null;

		String[] values = value.split(",");

		TreeNode root = new TreeNode(Integer.valueOf(values[0]));

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 1;
		while (!q.isEmpty()) {

			TreeNode temp = q.poll();

			if (temp == null) {

				continue;
			}

			if (!values[count].equals("#")) {
				TreeNode left = new TreeNode(Integer.valueOf(values[count]));
				temp.setLeft(left);
				q.add(left);

			} else {
				temp.setLeft(null);
				q.add(null);
			}
			count++;
			if (!values[count].equals("#")) {
				TreeNode right = new TreeNode(Integer.valueOf(values[count]));
				temp.setRight(right);
				q.add(right);

			} else {
				temp.setLeft(null);
				q.add(null);
			}
			count++;

		}
		return root;
	}

	public TreeNode insert(TreeNode node, int data) {

		if (node == null) {

			return new TreeNode(data);
		}

		TreeNode temp = null;

		if (data <= node.getValue()) {
			temp = insert(node.getLeft(), data);
			node.setLeft(temp);
			temp.setParent(node);

		} else {
			temp = insert(node.getRight(), data);
			node.setRight(temp);
			temp.setParent(node);
		}

		return node;

	}

	public int inorderSuccessor(TreeNode node) {

		if (node.getRight() != null) {

			return minValue(node.getRight());
		}

		TreeNode cur = node.getParent();

		while (cur != null && cur == cur.getParent()) {
			node = cur;
			cur = cur.getParent();
		}

		return cur.getValue();

	}

	private int minValue(TreeNode right) {

		TreeNode cur = right;
		while (cur.getLeft() != null) {

			cur = cur.getLeft();
		}

		return cur.getValue();
	}

	public static void main(String[] args) {
		TreeSolution tree = new TreeSolution();
		tree.run();
	}

	public static TreeNode pre = null;

	private void run() {
		TreeNode root = new TreeNode(40);

		TreeNode fleaf1 = new TreeNode(20);

		TreeNode sleaf2 = new TreeNode(60);

		TreeNode leaf3 = new TreeNode(10);
		TreeNode leaf4 = new TreeNode(30);
		TreeNode leaf5 = new TreeNode(50);
		TreeNode leaf6 = new TreeNode(70);

		root.setLeft(fleaf1);

		root.setRight(sleaf2);

		fleaf1.setRight(leaf4);
		fleaf1.setLeft(leaf3);

		sleaf2.setLeft(leaf5);

		sleaf2.setRight(leaf6);

		// doubleLinkedList(root);

		// System.err.println(kThSmallestElementR(root, 4));

		// System.err.println(kThSmallestElement(root, 4));

		// inorder(flatenTreeNode(root));

		// preOrder(root);

		// preOrder(root);

		// inorder(invertBinnaryTree(root));

		// System.out.println(verticalOrder(root));

		// System.out.println(isVaildTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		// System.err.println(pathSum(root, 100));

		// System.err.println(minDepth(root));

		// System.err.println(rigthSideView(root));

		// TreeNode lca = lca(root, root.getLeft(), root);

		// System.out.println(isSymmerticTree(root, root));

		// System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

		// nextPointer2(root);

		/*
		 * List<TreeNode> unqiueTree = unqiueTree(3);
		 * 
		 * for (TreeNode t : unqiueTree) { inorder(t); }
		 */

		// TreeNode one = new TreeNode(1, new TreeNode(2), new TreeNode(3));

		// List<String> path = new ArrayList<String>();

		// binaryTreePaths(root, path, "");

		// System.out.println(sumTOLeaf(root));

		// System.err.println(sumTOLeaf(root, 0));

		// System.err.println(2 * getHight(one) - 1);

		// System.out.println(serialize(root));

		// inorder(deserialize(serialize(root)));

		// List<List<Integer>> leafs = new ArrayList<List<Integer>>();
		// findleaves(leafs, root);

		// System.err.println(leafs);

		int[] t = { 1, 2, 3, 4, 5, 6 };
		// SumRangeTree buildSumRangeTree = buildSumRangeTree(t, 0, t.length - 1);

		// System.out.println(sumofRanges(buildSumRangeTree, 0, 6));
		// updateSum(buildSumRangeTree, 10, 3);

		// System.out.println(sumofRanges(buildSumRangeTree, 0, 6));
		TreeNode r = new TreeNode(0);
		r.left = new TreeNode(-4);
		r.left.right = new TreeNode(-1);
		r.left.right.right = new TreeNode(3);
		r.left.right.right.left = new TreeNode(-2);
		r.right = new TreeNode(-3);
		r.right.left = new TreeNode(8);
		r.right.left.right = new TreeNode(9);
		r.right.left.right.left = new TreeNode(4);

		// System.out.println(sumOfLeftLeaves(r));
		/// diameterOfBinaryTree(r);
		TreeNode r1 = new TreeNode(2);

		r1.left = new TreeNode(1);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(2);
		TreeNode s = lowestCommonAncestor(r1, p, q);
		System.out.println(s.value);
		
		TreeNode z=new TreeNode(1);
		TreeNode zl=new TreeNode(2);
		TreeNode zr=new TreeNode(3);
		z.setLeft(zl);	
		z.setRight(zr);
		zl.setLeft(new TreeNode(4));
		zl.setRight(new TreeNode(5));
		System.out.println(zigzagLevelOrder(z));

	}

	public int findleaves(List<List<Integer>> leafs, TreeNode root) {

		if (root == null) {
			return -1;

		}
		int left = findleaves(leafs, root.getLeft());
		int right = findleaves(leafs, root.getRight());

		int cur = Math.max(left, right) + 1;

		if (leafs.size() <= cur) {

			leafs.add(new ArrayList<Integer>());
		}

		leafs.get(cur).add(root.getValue());
		return cur;
	}

	public void binaryTreePaths(TreeNode root, List<String> path, String s) {
		if (root == null) {

			return;

		}

		s += root.getValue() + " ";

		if (root.getLeft() == null && root.getRight() == null) {

			path.add(s.substring(3));
			return;
		}

		binaryTreePaths(root.getLeft(), path, s);
		binaryTreePaths(root.getRight(), path, s);
	}

	public int getHight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return Math.max(getHight(root.getLeft()), getHight(root.getLeft())) + 1;

	}

	class BSTIterator implements Iterator {

		private Stack<TreeNode> st = new Stack<TreeNode>();

		public BSTIterator(TreeNode root) {

			while (root != null) {
				st.push(root);
				root = root.left;
			}

		}

		public boolean hasNext() {
			return !st.isEmpty();
		}

		public Object next() {
			TreeNode node = st.pop();
			int result = node.getValue();
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					st.push(node);
					node = node.left;
				}
			}
			return result;
		}

	}

	public class SumRangeTree {

		private int start;
		private int end;
		private int sum;

		private SumRangeTree left;
		private SumRangeTree right;

		public SumRangeTree(int s, int r) {
			this.start = s;
			this.end = r;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		public SumRangeTree getLeft() {
			return left;
		}

		public void setLeft(SumRangeTree left) {
			this.left = left;
		}

		public SumRangeTree getRight() {
			return right;
		}

		public void setRight(SumRangeTree right) {
			this.right = right;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Start :" + start);
			sb.append("End :" + end);
			sb.append("Value :" + sum);
			return sb.toString();
		}

	}

	private SumRangeTree buildSumRangeTree(int[] a, int left, int right) {

		if (left < right && left > a.length && right < a.length)
			return null;
		SumRangeTree node;
		if (left == right) {
			node = new SumRangeTree(left, right);
			node.setSum(a[left]);
			return node;
		} else {

			int mid = left + (right - left) / 2;
			node = new SumRangeTree(left, right);
			node.setLeft(buildSumRangeTree(a, left, mid));
			node.setRight(buildSumRangeTree(a, mid + 1, right));

			node.setSum(node.getLeft().getSum() + node.getRight().getSum());
		}

		return node;
	}

	public void updateSum(SumRangeTree root, int val, int pos) {

		if (root == null)
			return;
		int mid = root.getStart() + (root.getEnd() - root.getStart()) / 2;

		if (root.getStart() == root.getEnd() && root.getStart() == pos) {
			root.setSum(val);
			return;
		}
		if (pos <= mid) {
			updateSum(root.getLeft(), val, pos);
		} else {
			updateSum(root.getRight(), val, pos);
		}
		if (root != null && root.getLeft() != null && root.getRight() != null)
			root.setSum(root.getLeft().getSum() + root.getRight().getSum());
	}

	public int sumofRanges(SumRangeTree root, int i, int j) {
		if (root == null)
			return -1;
		int mid = root.getStart() + (root.getEnd() - root.getStart()) / 2;
		if (i <= root.getStart() && j >= root.getEnd()) {
			return root.getSum();
		}
		int res = 0;
		if (root.getStart() < j) {

			res += sumofRanges(root.getLeft(), i, mid);
		} else {
			res += sumofRanges(root.getLeft(), mid + 1, j);
		}
		return res;

	}

	public static void doubleLinkedList(TreeNode root) {
		if (root != null) {
			doubleLinkedList(root.getLeft());
			if (pre == null) {
				pre = root;
			} else {
				root.setLeft(pre);
				pre.setRight(root);
			}
			pre = root;
			doubleLinkedList(root.getRight());

		}

	}

	public int sumOfLeftLeaves(TreeNode root) {

		TreeNode cur = root;
		Stack<TreeNode> st = new Stack<TreeNode>();

		int retValue = 0;
		while (cur != null || !st.isEmpty()) {

			if (cur != null && cur.right != null) {
				st.push(cur.right);

			}

			if (cur != null && cur.left == null && cur.right == null) {

				retValue += cur.value;
			}

			if (cur != null && cur.left != null) {
				cur = cur.left;

			} else if (!st.isEmpty()) {
				TreeNode pop = st.pop();
				cur = pop.left;

			} else {
				cur = cur.left;
			}

		}

		return retValue;
	}

	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		helper(root);
		return diameter;
	}

	public int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = diameterOfBinaryTree(root.left);
		int right = diameterOfBinaryTree(root.right);
		diameter = Math.max(diameter, left + right);

		return Math.max(left, right) + 1;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root != null && root.value >= q.value && root.value <= q.value) {

			return root;

		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		return left != null ? left : right != null ? right : null;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null)
			return new ArrayList<List<Integer>>();

		Queue<Integer> level = new LinkedList<Integer>();
		Queue<TreeNode> dfs = new LinkedList<TreeNode>();
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

		dfs.add(root);
		level.add(1);
		boolean dir = false;
		while (!dfs.isEmpty()) {

			TreeNode node = dfs.remove();
			int l = level.remove();
			if (result.get(l) != null) {
				result.get(l).add(node.value);

			} else {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(node.value);
				result.put(l, temp);
			}
			if (dir) {
				if (node != null && node.left != null) {
					dfs.add(node.left);
					level.add(l + 1);
					dir = false;
				}
				if (node != null && node.right != null) {
					dfs.add(node.right);
					level.add(l + 1);
					dir = false;

				}
				
			} else {

				if (node != null && node.right != null) {
					dfs.add(node.right);
					level.add(l + 1);
					dir = true;
				}
				if (node != null && node.left != null) {
					dfs.add(node.left);
					level.add(l + 1);
					dir = true;
				}
				

			}

		}

		return new ArrayList<List<Integer>>(result.values());

	}
}
