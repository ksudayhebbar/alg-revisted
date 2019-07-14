package com.alg.rev.array.toplogical.tpnode;

import java.util.List;

public class TPNode {

	private List<TPNode> childern;
	private List<TPNode> parent;
	private String nodeName;

	public TPNode(List<TPNode> childern, List<TPNode> parent, String nodeName) {
		super();
		this.childern = childern;
		this.parent = parent;
		this.nodeName = nodeName;
	}

	public List<TPNode> getChildern() {
		return childern;
	}

	public void setChildern(List<TPNode> childern) {
		this.childern = childern;
	}

	public List<TPNode> getParent() {
		return parent;
	}

	public void setParent(List<TPNode> parent) {
		this.parent = parent;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

}
