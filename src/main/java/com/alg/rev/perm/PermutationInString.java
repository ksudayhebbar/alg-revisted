package com.alg.rev.perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationInString {
	private static Set<String> dic = new HashSet<String>();

	
	public static boolean checkInclusion(String s1, String s2) {
		char[] dicArray = s1.toCharArray();

		return checkInclusion(s1, s2);

	}

	public static boolean constructDic(char[] dicArray, int start, String s2) {
		boolean bflag = false;
		if (dicArray.length == start) {

			String temp = new String(dicArray);
			if (s2.indexOf(temp) >= 0) {
				bflag = true;
				return bflag;
			}

		}

		for (int i = start; i < dicArray.length; i++) {

			swap(dicArray, start, i);
			bflag |= constructDic(dicArray, start + 1, s2);
			swap(dicArray, start, i);
		}

		return bflag;
	}

	public static void swap(char[] dic, int i, int j) {

		char c = dic[i];
		dic[i] = dic[j];
		dic[j] = c;

	}

	public static void main(String[] args) {

		System.out.println(checkInclusion2("ab", "eidbaooo"));
	}

	public static boolean checkInclusion2(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2)
			return false;

		int count[] = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;

		}

		if (allZero(count))
			return true;

		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt((i - len1)) - 'a']++;
			if (allZero(count))
				return true;

		}
		return false;

	}

	public static boolean allZero(int[] count) {

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
