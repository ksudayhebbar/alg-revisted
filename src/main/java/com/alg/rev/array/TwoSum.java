package com.alg.rev.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int a[], int traget) {
		if (a == null || a.length < 0)
			return null;
		Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
		int [] retValue=new int[2];
		for (int oValue : a) {

			int sum = traget - oValue;
			if(sums.containsKey( oValue)) {
				retValue[0]=sum;
				retValue[1]=oValue;
			}else {
				sums.put(sum, oValue);

		}
		}
		return retValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
