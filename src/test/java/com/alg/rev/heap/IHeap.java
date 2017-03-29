package com.alg.rev.heap;

public interface IHeap {
	public int getParent(int capcity, int type);

	public int getLeftChild(int node);

	public int getRightChild(int node);

	public int getMax();

	public int getMin();

	public int delete();

	public void insert(int data);

}
