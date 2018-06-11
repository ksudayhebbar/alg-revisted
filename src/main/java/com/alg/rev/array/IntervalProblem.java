package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntervalProblem {

	public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterVal) {
		if (intervals == null || intervals.isEmpty())
			return null;

		List<Interval> result = new ArrayList<Interval>();

		boolean inserted = false;

		for (Interval oneInterval : intervals) {

			if (newInterVal.getStart() < oneInterval.getEnd()) {

				result.add(newInterVal);

			} else if (newInterVal.getStart() <= oneInterval.getEnd()
					&& newInterVal.getEnd() >= oneInterval.getStart()) {
				Interval merge = new Interval(Math.min(newInterVal.getStart(), oneInterval.getStart()),
						Math.max(newInterVal.getEnd(), oneInterval.getEnd()));
				result.add(merge);
			} else {
				result.add(oneInterval);
			}
		}
		return result;

	}

	public static List<Interval> merge(List<Interval> intveral) {

		if (intveral == null || intveral.isEmpty())
			return null;

		List<Interval> result = new ArrayList<Interval>();

		Interval pre = intveral.get(0);

		for (int i = 1; i < intveral.size(); i++) {

			Interval current = intveral.get(i);

			if (current.getStart() < pre.getEnd()) {

				pre.setEnd(current.getEnd());
			} else if (current.getStart() > pre.getStart()) {
				result.add(pre);
				pre = current;
			}

		}
		result.add(pre);

		return result;

	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();

		Interval oneInterval = new Interval(1, 3);
		input.add(oneInterval);
		oneInterval = new Interval(2, 6);
		input.add(oneInterval);
		oneInterval = new Interval(8, 10);
		input.add(oneInterval);
		oneInterval = new Interval(15, 18);
		input.add(oneInterval);

		oneInterval = new Interval(16, 19);
		input.add(oneInterval);

		oneInterval = new Interval(20, 30);
		input.add(oneInterval);

		List<Interval> merge = IntervalProblem.merge(input);

		for (Interval val : merge) {

			System.out.println(val);
		}

	}

}
