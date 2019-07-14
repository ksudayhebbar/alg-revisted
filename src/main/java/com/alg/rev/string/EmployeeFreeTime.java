package com.alg.rev.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.alg.rev.array.Interval;

public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<Interval>();

		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
			public int compare(Interval one, Interval two) {
				return one.getStart() - two.getEnd();
			}
		});
		for (List<Interval> intervals : schedule) {
			for (Interval inteval : intervals) {
				pq.offer(inteval);
			}
		}

		Interval temp = pq.poll();
		while (!pq.isEmpty()) {
			if (temp.getEnd() < pq.peek().getStart()) {
				result.add(new Interval(temp.getEnd(), pq.peek().getStart()));
				temp = pq.poll();
			} else {
				temp = temp.getEnd() < pq.peek().getEnd() ? pq.peek() : temp;
				pq.poll();
			}

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
