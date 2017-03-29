package com.alg.rev.heap;

import java.util.Arrays;

public class Heap implements IHeap {

	private int heap[];
	private int capcity;
	private int count;
	private boolean type;

	public Heap(int capcity, int count, boolean type) {
		super();
		this.capcity = capcity;
		this.count = count;
		this.type = type;
		this.heap = new int[capcity];
	}

	public int[] getHeap() {
		return heap;
	}

	public void setHeap(int[] heap) {
		this.heap = heap;
	}

	public int getCapcity() {
		return capcity;
	}

	public void setCapcity(int capcity) {
		this.capcity = capcity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public int getParent(int capcity, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int parent(int node) {

		if (node < count && node < capcity)
			return -1;
		else
			return (node - 1) / 2;
	}

	public int getLeftChild(int node) {
		if (node < count && node < capcity)
			return -1;
		else {
			return (node * 2) + 1;
		}

	}

	public int getRightChild(int node) {
		if (node < count && node < capcity)
			return -1;
		else {
			return (node * 2) + 2;
		}
	}

	public int getMax() {
		int retValue = -1;
		if (isType()) {
			if (count > 0)
				retValue = heap[0];
		}
		return retValue;
	}

	public int getMin() {
		int retValue = -1;
		if (!isType()) {
			if (count > 0)
				retValue = heap[0];
		}
		return retValue;
	}

	private void heapfiy(int nodeNO) {

		int left, right, max;

		left = getLeftChild(nodeNO);
		right = getRightChild(nodeNO);

		if (left != -1 && heap[left] > heap[nodeNO]) {
			max = left;
		} else {
			max = nodeNO;
		}
		if (right != -1 && heap[right] > heap[max]) {
			max = right;
		}
		if (nodeNO != max) {

			swap(nodeNO, max);
		}
		heapfiy(max);
	}

	private void swap(int nodeNO, int max) {
		int temp = heap[nodeNO];
		heap[nodeNO] = heap[max];
		heap[max] = temp;

	}

	public int delete() {
		int retValue = -1;

		if (count > 0) {
			retValue = heap[0];
			count--;
			heapfiy(0);
		}

		return retValue;
	}

	public void insert(int data) {
		if (count < capcity)
			throw new ArrayIndexOutOfBoundsException();
		/*
		 * int j = 1; for (int i = 1; data > heap[(i - 1 / 2)]; i = (i - 1) / 2)
		 * { heap[i] = heap[(i - 1 / 2)]; j = i; }
		 * 
		 * heap[j] = data;
		 */

		heap[this.count++] = data;

		for (int i = (this.count / 2) - 1; i > 0; i--) {

			heapfiy(i);

		}

	}

	public void resizeHeap() {
		int temp[] = new int[capcity];
		int i = 0;
		for (int val : heap) {
			temp[i++] = val;
		}
		
		heap=new int [capcity*2];
		 i = 0;
		for (int val : temp) {
			heap[i++] = val;
		}
		

	}
}
