package com.alg.rev.array;

import java.util.logging.Logger;

public class MultiStack {

	public static Logger logger = Logger.getLogger(MultiStack.class.getSimpleName());

	private int stack[];
	private int numberofStack;
	private int sizeOfStack = 0;
	private StackInfo[] stackInfo;

	public MultiStack(int size, int numStack) {
		this.numberofStack = numStack;
		this.sizeOfStack = size * numStack;
		this.stack = new int[sizeOfStack];
		this.stackInfo = new StackInfo[numStack];
		for (int i = 0; i < numStack; i++) {
			this.stackInfo[i] = new StackInfo(size);
			this.stackInfo[i].setStackStarts(size * i);
			this.stackInfo[i].setStackEnds(size * i + size);
		}

		for (StackInfo info : stackInfo) {
			System.out.println(info);
		}

	}

	public boolean push(int value,int statckNum) {
		if(statckNum<numberofStack) {
			
		}
		
		return false;
		
	}

	public int pop(int num, int stackNum) {
		return stackNum;

	}

	private boolean stackEmpty() {
		return false;

	}

	private boolean satckFull() {
		return false;

	}

	public int peak(int num, int stackNum) {
		return stackNum;

	}

	private void reSizeStack() {

	}

	public static void main(String[] args) {
		MultiStack multiStack = new MultiStack(3, 3);
	}

}
