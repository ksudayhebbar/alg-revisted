package com.alg.rev.array;

/**
 * here are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Analysis
 * 
 * To solve this problem, we need to understand and use the following 2 facts:
 * 1) if the sum of gas >= the sum of cost, then the circle can be completed. 2)
 * if A can not reach C in a the sequence of A-->B-->C, then B can not make it
 * either.
 */

public class GasSatation {

	public int canCompleteCircuit(int[] cost, int[] gas) {

		int start = 0;
		int remaining = 0;
		int total = 0;
		int sumRemaining = 0;
		for (int i = 0; i < gas.length; i++) {
			remaining = gas[i] - cost[i];

			if (sumRemaining >= 0) {

				sumRemaining += remaining;
			} else {
				sumRemaining = remaining;
				start = i;

			}
			total += remaining;

		}

		if (total >= 0) {
			return start;
		}

		return -1;

	}

	public static void main(String[] args) {
		GasSatation gasSatation = new GasSatation();
		int[] cost = { 2, 3, 2, 4, 5 };
		int[] gas = { 1, 2, 3, 4, 5 };
		gasSatation.canCompleteCircuit(cost, gas);
	}

}
