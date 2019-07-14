package com.alg.rev.perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuationSol {

	public static List<List<Integer>> findSubsequences(int[] nums) {

		List<Integer> cur = new ArrayList<Integer>();
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		findSubsequences(nums, 0, cur, result);
		return new ArrayList(result);
	}

	public static void findSubsequences(int[] nums, int start, List<Integer> cur, Set<List<Integer>> result) {

		if (cur.size() >= 2) {
			result.add(new ArrayList<Integer>(cur));

		}

		for (int i = start; i < nums.length; i++) {

			if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]) {
				cur.add(nums[i]);
				findSubsequences(nums, i + 1, cur, result);

				cur.remove(cur.size() - 1);
			}
		}

	}

	public static List<String> generateParenthesis(int n) {

		List<String> retList = new ArrayList<String>();
		generateParenthesis(n, n, "", retList);
		return retList;

	}

	private static void generateParenthesis(int left, int right, String par, List<String> retList) {

		if (left > right) {
			return;
		}
		if (left == 0 && right == 0) {
			retList.add(par);

		}
		if (left > 0) {
			generateParenthesis(left - 1, right, par + "(", retList);

		}
		if (right > 0) {
			generateParenthesis(left, right - 1, par + ")", retList);

		}

	}

	public static Set<List<Integer>> permuate1(int[] num, int start) {
		 
	
		Set<List<Integer>> retList = new HashSet<List<Integer>>();
		if (start == num.length) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int n : num) {
				tempList.add(n);

			}
		
			retList.add(tempList);
			return retList;

		}

		for (int i = 0; i < num.length; i++) {

			swap(num, start, i);

			Set<List<Integer>> permuate1 = permuate1(num, start + 1);

			retList.addAll(permuate1);

			swap(num, start, i);

		}
		return retList;

	}

	private static void swap(int[] num, int start, int i) {
		int temp = num[i];
		num[i] = num[start];
		num[start] = temp;
	}

	public static Set<Set<Integer>> subSet(int[] num, int s) {
		Set<Set<Integer>> retSet = new HashSet<Set<Integer>>();

		if (s == num.length) {
			return retSet;
		}

		Set<Integer> sSet = new HashSet<Integer>();

		sSet.add(num[s]);
		retSet.add(sSet);
		for (int i = s; i < num.length; i++) {

			Set<Set<Integer>> subSet = subSet(num, s + 1);
			sSet = new HashSet<Integer>();
			for (int j = 0; j < s; j++) {
				sSet.add(num[j]);
			}
			retSet.add(sSet);
			sSet = new HashSet<Integer>();
			for (int k = s; k < num.length; k++) {
				sSet.add(num[k]);
			}
			retSet.add(sSet);
			for (Set<Integer> tem : subSet) {

				retSet.add(tem);
			}

		}
		return retSet;

	}

	public static List<List<Integer>> combinationSum(int num[], int target) {

		List<Integer> cur = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int start = 0;
		Arrays.sort(num);
		 combinationSum(num, start, cur, target, result);
		//combinationUniqueSum(num, start, cur, target, result);
		return result;

	}

	private static void combinationSum(int[] num, int start, List<Integer> cur, int target,
			List<List<Integer>> result) {

		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(cur);
			result.add(temp);
			return;
		}

		for (int i = start; i < num.length; i++) {
			if (target < num[i]) {
				return;
			}
			cur.add(num[i]);
			combinationSum(num, i, cur, target - num[i], result);
			cur.remove(cur.size() - 1);

		}

	}

	private static void combinationUniqueSum(int[] num, int start, List<Integer> cur, int target,
			List<List<Integer>> result) {

		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(cur);
			result.add(temp);
			return;
		}
		int pre = -1;
		for (int i = start; i < num.length; i++) {
			if (target < num[i]) {
				return;
			}
			if (num[i] != pre) {
				cur.add(num[i]);
				combinationSum(num, i + 1, cur, target - num[i], result);
				cur.remove(cur.size() - 1);
				pre = num[i];
			}

		}

	}

	private static void uniquecombination(int n, int k, int start, List<Integer> cur, List<List<Integer>> result) {

		if (cur.size() == k) {
			ArrayList<Integer> temp = new ArrayList<Integer>(cur);
			result.add(temp);
			return;
		}

		for (int i = start; i <= n; i++) {

			cur.add(i);
			uniquecombination(n, k, i + 1, cur, result);
			cur.remove(cur.size() - 1);

		}

	}

	public static int combinationDp(int[] num, int target) {

		int dp[] = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i <= target; i++) {

			for (int n : num) {

				if (n + dp[i] <= target)
					dp[n + i] += dp[i];

			}

		}
		return dp[target];
	}

	public static void main(String[] args) {
		System.out.println(permuate1(new int[] { 1, 2, 3 }, 0));
		// System.out.println(permuate1(new int[] { 1, 1, 2 }, 0));

		// System.out.println(subSet(new int[] { 1, 2, 3 }, 0));

		// System.out.println(generateParenthesis(3));

		// System.out.println(combinationDp(new int[] { 2, 3, 6, 7 }, 7));
		//List<List<Integer>> result = new ArrayList<List<Integer>>();
		// uniquecombination(4, 3, 1, new ArrayList<Integer>(), result);
		// System.out.println(result);
		// System.out.println(restoreIpaddress("25525511135"));
		//System.out.println(factorCombination(16));
		//findSubsequences(new int[] {4,6,7,7});
		
		//combinationSum(new int[] {2},3);

	}

	public static List<String> restoreIpaddress(String ipaddress) {

		List<List<String>> result = new ArrayList<List<String>>();
		List<String> current = new ArrayList<String>();

		dfs(ipaddress, 0, current, result);
		List<String> finalResult = new ArrayList<String>();
		for (List<String> res : result) {
			StringBuffer sb = new StringBuffer();
			for (String s : res) {
				sb.append(s + ".");
			}
			String s = sb.substring(0, sb.length() - 1);
			finalResult.add(s);
		}
		return finalResult;
	}

	private static void dfs(String ipaddress, int s, List<String> current, List<List<String>> result) {

		if (current.size() >= 4 && s != ipaddress.length()) {
			return;
		}
		if (((current.size() + ipaddress.length()) - s + 1) < 4) {
			return;
		}
		if (current.size() == 4 && s == ipaddress.length()) {
			List<String> temp = new ArrayList<String>(current);
			result.add(temp);
		}

		for (int i = 1; i <= 3; i++) {

			if (s + i > ipaddress.length()) {
				break;
			}

			String sub = ipaddress.substring(s, i + s);

			if (i > 1 && sub.charAt(0) == '0') {
				break;
			}
			if (Integer.valueOf(sub) > 255) {
				break;
			}
			current.add(sub);
			dfs(ipaddress, s + i, current, result);

			current.remove(current.size() - 1);

		}

	}

	public static List<List<Integer>> factorCombination(int n) {
		List<Integer> cur = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		factorCombination(2, 1, n, cur, result);
		return result;

	}

	private static void factorCombination(int start, int product, int n, List<Integer> cur,
			List<List<Integer>> result) {

		if (product == n) {
			List<Integer> temp = new ArrayList<Integer>(cur);

			result.add(temp);

		}

		for (int i = start; i < n; i++) {
			if (i * product > n) {
				break;
			}

			cur.add(i);
			factorCombination(i, i * product, n, cur, result);

			cur.remove(cur.size() - 1);

		}
		
		 

	}

}
