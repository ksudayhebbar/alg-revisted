package com.alg.rev.array;

public class LongestSubstring {
	public static int longestSubstring(String s, int k) {
		int[] count = new int[256];
		int num = 0;
		int j = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(count[s.charAt(i) - 'a']<=k) {
				max+=count[s.charAt(i) - 'a'];
			
			}
			
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb",3));

	}

}
