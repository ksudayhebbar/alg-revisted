package com.alg.rev.avl.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphAJMatrix {
	private boolean[][] ajMatrix;
	private List<Vertex> vertexs;
	private int vertexCount = 0;
	private boolean isDirected = false;
	private int[][] weight;

	public GraphAJMatrix(int row, int col, boolean isDirected,
			boolean isWeighted) {
		super();
		this.ajMatrix = new boolean[row][col];
		if (isWeighted) {
			this.weight = new int[row][col];
		}
		this.vertexs = new ArrayList<Vertex>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ajMatrix[i][j] = false;
				this.weight[i][j] = -1;
			}
		}
		this.isDirected = isDirected;
	}

	public void addVertex(String label) {
		vertexs.add(new Vertex(label));
	}

	public void addEdge(int src, int dest) {
		if (vertexs.get(src) != null) {
			String label = vertexs.get(vertexCount).getLabel();
			addVertex(getLabel(label));
			vertexCount++;
		}
		if (vertexs.get(dest) != null) {
			String label = vertexs.get(vertexCount).getLabel();
			addVertex(getLabel(label));
			vertexCount++;
		}
		if (!isDirected) {
			ajMatrix[src][dest] = true;
			ajMatrix[dest][src] = true;

		} else {
			ajMatrix[src][dest] = true;
			int inderee = vertexs.get(dest).getInDegree();
			vertexs.get(dest).setInDegree(inderee++);
		}

	}

	public void addEdge(int src, int dest, int weight) {

		addEdge(src, dest);

		if (!isDirected) {
			this.weight[src][dest] = weight;
			this.weight[dest][src] = weight;

		} else {
			this.weight[src][dest] = weight;

		}

	}

	private String getLabel(String lable) {
		Character lab = lable.charAt(0);
		String retLable = "";
		if (lab >= 'A' && lab <= 'Z') {
			int charInt = lab = '0';
			retLable = Character.getName(charInt++);

		}
		return retLable;

	}

	public void display(int v) {
		System.out.println(vertexs.get(v).getLabel());
	}

	public void dfs(int vertex) {

		Stack<Integer> dfsStack = new Stack<Integer>();
		dfsStack.push(vertex);
		display(vertex);
		vertexs.get(vertex).setVisted(true);

		while (!dfsStack.isEmpty()) {

			int u = getUnvistedVertex(dfsStack.peek());
			if (u != -1) {
				dfsStack.push(u);
				display(u);
				vertexs.get(u).setVisted(true);

			} else {

				dfsStack.pop();
			}

		}

		resetVistFlags();

	}

	private void resetVistFlags() {
		for (int i = 0; i < vertexCount; i++) {
			vertexs.get(i).setVisted(false);
		}

	}

	private int getUnvistedVertex(int tempVertex) {
		for (int col = 0; col < vertexCount; col++) {
			if (ajMatrix[tempVertex][col] == true
					&& !vertexs.get(tempVertex).isVisted()) {
				return col;
			}
		}
		return -1;
	}

	public void bfs(int vertex) {

		Queue<Integer> dfsQ = new LinkedBlockingQueue<Integer>();
		dfsQ.add(vertex);
		display(vertex);
		vertexs.get(vertex).setVisted(true);
		int v = -1;
		int u = -1;
		while (!dfsQ.isEmpty()) {
			v = dfsQ.poll();
			while ((u = getUnvistedVertex(v)) != -1) {
				dfsQ.add(u);
				display(u);
				vertexs.get(u).setVisted(true);
			}
		}
		resetVistFlags();
	}

	public int[] toplogicalSort() {
		int u, v, order = 0;
		int[] topolicalSortOrder = new int[vertexCount];
		int[] inDegree = new int[vertexCount];
		Queue<Integer> dfsQ = new LinkedBlockingQueue<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			if (vertexs.get(i).getInDegree() == 0) {
				dfsQ.add(i);
			}
			inDegree[i] = vertexs.get(i).getInDegree();
		}

		while (!dfsQ.isEmpty()) {
			v = dfsQ.poll();
			topolicalSortOrder[v] = ++order;

			while ((u = getUnvistedVertex(v)) != -1) {
				if (--inDegree[u] == 0)
					dfsQ.add(u);
			}

		}

		if (order != vertexCount) {
			System.out.println("Graph has cycle...");
			return null;
		} else {
			return topolicalSortOrder;
		}

	}

	public Map<String, int[]> unwightedShortedPath(int source) {

		int u = -1;
		int v = -1;
		int[] distance = new int[vertexCount];
		int[] path = new int[vertexCount];

		Queue<Integer> dfsQ = new LinkedBlockingQueue<Integer>();
		for (int i = 0; i < vertexCount; i++) {
			distance[i] = -1;
			path[i] = -1;
		}
		dfsQ.add(source);
		display(source);
		vertexs.get(source).setVisted(true);
		distance[source] = 0;

		while (!dfsQ.isEmpty()) {
			v = dfsQ.poll();
			while ((u = getUnvistedVertex(v)) != -1) {
				if (distance[u] == -1) {
					distance[u] = distance[v] + 1;
					path[u] = v;
					dfsQ.add(u);
				}
			}
		}
		Map<String, int[]> distanceMatrix = new HashMap<String, int[]>();
		distanceMatrix.put("Distance", distance);
		distanceMatrix.put("path", path);
		resetVistFlags();
		return distanceMatrix;
	}

	public Map<String, int[]> wightedShortedPath(int source) {

		int u = -1;
		Distance v;
		int[] distance = new int[vertexCount];
		int[] path = new int[vertexCount];

		Queue<Distance> dfsQ = new PriorityQueue<Distance>(vertexCount);
		for (int i = 0; i < vertexCount; i++) {
			distance[i] = -1;
			path[i] = -1;
		}

		dfsQ.add(new Distance(source, 0));
		display(source);
		vertexs.get(source).setVisted(true);
		distance[source] = 0;

		while (!dfsQ.isEmpty()) {
			v = dfsQ.poll();
			while ((u = getUnvistedVertex(v.getVertex())) != -1) {
				int newDistance = distance[v.getVertex()]
						+ weight[v.getVertex()][u];
				if (distance[u] == -1) {
					distance[u] = newDistance;
					path[u] = v.getVertex();
					dfsQ.offer(new Distance(u, newDistance));
				} else if (newDistance > distance[u]) {
					distance[u] = newDistance;
					path[u] = v.getVertex();

					for (Distance d : dfsQ) {
						if (d.getVertex() == u) {
							dfsQ.remove(d);
						}

					}
					dfsQ.offer(new Distance(u, newDistance));
				}
			}
		}
		Map<String, int[]> distanceMatrix = new HashMap<String, int[]>();
		distanceMatrix.put("Distance", distance);
		distanceMatrix.put("path", path);
		resetVistFlags();
		return distanceMatrix;
	}

	public void showPathsAndDistance() {

		for (int i = 0; i < vertexCount; i++) {
			unwightedShortedPath(i);
		}
		
		for (int i = 0; i < vertexCount; i++) {
			wightedShortedPath(i);
		}
		
		for (int i = 0; i < vertexCount; i++) {
			bellmanFordAlg(i);
		}
	}

	private class Distance implements Comparable<Distance> {
		private int vertex = -1;
		private int distance;

		public Distance(int source, int distance) {
			this.vertex = source;
			this.distance = distance;
		}

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int compareTo(Distance o) {
			return this.distance - o.distance;
		}

	}

	public Map<String, int[]> bellmanFordAlg(int source) {
		int u = -1;
		Distance v;
		int[] distance = new int[vertexCount];
		int[] path = new int[vertexCount];

		Queue<Distance> dfsQ = new PriorityQueue<Distance>(vertexCount);
		for (int i = 0; i < vertexCount; i++) {
			distance[i] = -1;
			path[i] = -1;
		}

		dfsQ.add(new Distance(source, 0));
		display(source);
		vertexs.get(source).setVisted(true);
		distance[source] = 0;

		while (!dfsQ.isEmpty()) {
			v = dfsQ.poll();
			while ((u = getUnvistedVertex(v.getVertex())) != -1) {
				int newDistance = distance[v.getVertex()]
						+ weight[v.getVertex()][u];

				if(distance[u]>newDistance){
					distance[u] = newDistance;
					path[u] = v.getVertex();
					Distance w= new Distance(u, distance[u]);
					if(dfsQ.contains(w)){
						dfsQ.add(w);
					}
				}
			}
		}
		
		Map<String, int[]> distanceMatrix = new HashMap<String, int[]>();
		distanceMatrix.put("Distance", distance);
		distanceMatrix.put("path", path);
		resetVistFlags();
		return distanceMatrix;
	}

}
