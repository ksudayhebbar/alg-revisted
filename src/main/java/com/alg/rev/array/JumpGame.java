package com.alg.rev.array;

public class JumpGame {

	public static int jump(int[] num) {

		int max = 0;
		for (int i = 0; i < num.length; i++) {

			if (num[i] == 0 && max == i) {

				return -1;
			}
			if (max == num.length - 1) {
				return max;
			}
			if (num[i] + i > max) {

				max = num[i] + i;
			}

		}
		return max;

	}

	public static int jump2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int lastReach = 0;
		int reach = 0;
		int step = 0;

		for (int i = 0; i <= reach && i < nums.length; i++) {
			// when last jump can not read current i, increase the step by 1
			if (i > lastReach) {
				step++;
				lastReach = reach;
			}
			// update the maximal jump
			reach = Math.max(reach, nums[i] + i);
		}

		if (reach < nums.length - 1)
			return 0;

		return step;
	}

	public static void main(String[] args) {
		int[] num = { 3,2,1,0,4 };
		System.out.println(canJump(num));

	}
	
	public static boolean canJump(int[] nums) {
        int i=0;
        int reach=0;
       for( ;i<nums.length && i<=reach ;i++){
               
    	   reach=Math.max(i+nums[i],reach);
               
       }
   
       return i==nums.length;
}

}
