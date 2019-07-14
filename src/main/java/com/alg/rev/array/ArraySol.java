package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySol {
	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int val=Math.abs(nums[i])-1;
			if(nums[val]>0) {
			 nums[val]=-nums[val];	
			}
			

		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0) {
				res.add(i + 1);
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		findDisappearedNumbers(new int[] { 5, 4, 6, 7, 9, 3, 10, 9, 5, 6 });

	}

}
