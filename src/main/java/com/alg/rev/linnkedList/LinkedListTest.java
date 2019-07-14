package com.alg.rev.linnkedList;

public class LinkedListTest {
	public class LinkedListNode {

		public int value;

		public LinkedListNode next;

		public LinkedListNode(int i) {
			value = i;
		}

		public LinkedListNode(int i, LinkedListNode n) {
			value = i;
			this.next = n;
		}

		public LinkedListNode() {
			// TODO Auto-generated constructor stub
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LinkedListNode getNext() {
			return next;
		}

		public void setNext(LinkedListNode next) {
			this.next = next;
		}

	}

	public static LinkedListNode evenOdd(LinkedListNode node) {

		LinkedListNode cur = node;

		LinkedListNode oddNode = cur;
		LinkedListNode evenNode = cur.getNext();
		LinkedListNode conectionoddNode = cur.getNext();

		while (oddNode != null && evenNode != null) {
			LinkedListNode temp = evenNode.getNext();
			if (temp == null) {
				break;
			}

			oddNode.setNext(evenNode.getNext());
			oddNode = oddNode.getNext();

			evenNode.setNext(oddNode.getNext());
			evenNode = evenNode.getNext();

		}

		oddNode.setNext(conectionoddNode);

		return cur;

	}

	public static void print(LinkedListNode cur) {

		while (cur != null) {
			System.out.println(cur.getValue());
			cur = cur.getNext();
		}
	}

	public static LinkedListNode removeElements(LinkedListNode node, int num) {

		LinkedListNode pre = null;

		LinkedListNode cur = node;

		LinkedListNode retNode = node;

		while (cur != null) {

			if (cur.getValue() == num) {
				cur = cur.getNext();
				if (cur == null) {
					pre.setNext(null);
				}

			} else {
				if (pre != null) {
					pre.setNext(cur);
					pre = pre.getNext();

				} else {
					pre = cur;
				}
				cur = cur.getNext();

			}

		}

		return retNode;

	}

	public static LinkedListNode swapNodesPairs(LinkedListNode node) {

		LinkedListNode retNode = node;

		LinkedListNode cur = node.getNext();
		LinkedListNode pre = node; // 1-->2-->3--4
		while (cur != null) {

			LinkedListNode next = cur.getNext();

			int temp = cur.getValue();

			cur.setValue(pre.getValue());
			pre.setValue(temp);
			pre = next;
			cur = next.getNext();

		}

		return retNode;

	}

	public LinkedListNode swapNodesPairs2(LinkedListNode node) {

		LinkedListNode helper = new LinkedListNode(0);
		helper.next = node;
		LinkedListNode cur = helper;

		while (cur.next != null && cur.next.next != null) {
			// use t1 to track first node
			LinkedListNode pre = cur;
			cur = cur.next;
			pre.next = cur.next;

			// use t2 to track next node of the pair
			LinkedListNode next = cur.next.next;
			cur.next.next = cur;
			cur.next = next;

		}

		return helper.next;

	}

	/*
	 * public static LinkedListNode reverseKthgroupoNodes(LinkedListNode n, int k) {
	 * 
	 * 
	 * return reverseKthgroupoNodes(n, k, 0);
	 * 
	 * }
	 */

	private LinkedListNode reverseKthgroupoNodes(LinkedListNode head, int k) {

		LinkedListNode cur = head;
		int tempCount = 0;

		// LinkedListNode retNode = new LinkedListNode(0);
		// retNode.next = head;

		while (cur != null && tempCount != k) {
			cur = cur.getNext();
			tempCount++;
		}

		if (tempCount == k) {

			cur = reverseKthgroupoNodes(cur, k);

			while (tempCount-- > 0) {

				LinkedListNode temp = head.next;
				head.next = cur;
				cur = head;
				head = temp;
			}
			head = cur;

		}
		return head;
	}

	public static void main(String[] args) {
		new LinkedListTest().run();
		;
	}

	public void run() {
		LinkedListNode n1 = new LinkedListNode(1,
				new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, null)))));

		// print(evenOdd(n1));

		LinkedListNode n2 = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(6,
				new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6, null)))))));

		// print(removeElements(n2, 6));

		print(swapNodesPairs2(n1));

		//print(reverseKthgroupoNodes(n1, 3));
	}

}
