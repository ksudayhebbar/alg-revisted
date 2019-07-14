package com.alg.rev.array;

public class Interval {
	private int start;
	private int end;

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

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
