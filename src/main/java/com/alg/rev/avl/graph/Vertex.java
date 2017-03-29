package com.alg.rev.avl.graph;

public class Vertex {
	private boolean isVisted;
	private String label;
	private int inDegree;

	public Vertex() {
		this.isVisted = false;
		this.inDegree=0;
	}

	public Vertex(String label) {
		super();
		this.isVisted = false;
		this.label = label;
		this.inDegree=0;
	}

	public Vertex(boolean isVisted, String label) {
		super();
		this.isVisted = isVisted;
		this.label = label;
		this.inDegree=0;
	}

	public boolean isVisted() {
		return isVisted;
	}

	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}

	public String getLabel() {
		return label;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

}
