package com.alg.rev.array;

public class StackInfo {
	private int size;
	private int stackStarts = 0;
	private int stackEnds = 0;

	public StackInfo(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStackStarts() {
		return stackStarts;
	}

	public void setStackStarts(int stackStarts) {
		this.stackStarts = stackStarts;
	}

	public int getStackEnds() {
		return stackEnds;
	}

	public void setStackEnds(int stackEnds) {
		this.stackEnds = stackEnds;
	}

	@Override
	public String toString() {
		return "StackInfo [Size=" + size + ", StackStarts=" + stackStarts + ", StackEnds=" + stackEnds + "]";
	}
	

}
