package com.alg.rev.search;

public class RotatedSortedArray {

	public int findMin(int num[]) {

		return findMin(num, 0, num.length);
	}

	private int findMin(int[] num, int left, int right) {
		if (right == left) {
			return num[left];
		}
		if (right == left + 1) {
			return Math.min(num[left], num[right]);
		}

		int middle = (right - left) / 2;
		if (num[right] > num[left]) {
			return num[left];
		} else if (num[left] == num[right]) {
			return findMin(num, left + 1, right);

		} else if (num[left] < num[middle])
			return findMin(num, left, middle - 1);
		else

			return findMin(num, middle + 1, right);

	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[left] < nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]) {
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				left++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {4,5,6,7,0,1,2},0));
	}
}
