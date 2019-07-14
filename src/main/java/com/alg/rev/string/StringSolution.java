package com.alg.rev.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringSolution {

	public static List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		generateParenthesis("", n, n, 0, ret);
		return ret;
	}

	public static void generateParenthesis(String parentheses, int k, int n, int m, List<String> ret) {

		if (n == k || m == k) {
			ret.add(parentheses);
			return;
		}
		if (m > 0) {

			generateParenthesis(parentheses + ")", k, n + 1, m - 1, ret);
		}
		if (n > 0) {

			generateParenthesis(parentheses + "(", n - 1, k, m + 1, ret);
		}

	}

	public static String customSortString(String S, String T) {

		int[] hash = new int[26];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T.length(); i++) {
			hash[T.charAt(i) - 'a']++;
		}
		for (int i = 0; i < S.length(); i++) {
			while (hash[S.charAt(i) - 'a'] > 0) {
				hash[S.charAt(i) - 'a']--;
				sb.append(S.charAt(i));
			}
		}

		for (int i = 0; i < T.length(); i++) {
			while (hash[T.charAt(i) - 'a'] > 0) {
				hash[T.charAt(i) - 'a']--;
				sb.append(T.charAt(i));
			}
		}

		return sb.toString();

	}

	public String multiplie(String first, String second) {

		StringBuffer result = new StringBuffer(first.length() + second.length());

		int[] pos = new int[first.length() + second.length()];
		int carry = 0;
		for (int i = second.length() - 1; i >= 0; i--) {
			carry = 0;
			for (int j = first.length() - 1; j >= 0; j--) {

				int mul = (first.charAt(j) - '0') * (second.charAt(i) - '0');

				mul += pos[i + j + 1];

				int value = mul / 10;
				carry = mul % 10;
				pos[i + j] = value;
				pos[i + j + 1] = carry;
			}
		}

		int i = 0;
		if (pos[0] == 0) {
			i = 1;
		}

		for (; i < pos.length; i++) {

			result.append(pos[i]);

		}
		return result.toString();

	}

	public void palindromePartion(String input, int start) {

		if (start == input.length()) {
			return;
		}

		for (int s = start; s < input.length() - 1; s++) {

			String temp = input.substring(start, s);
			System.out.println(temp);
			palindromePartion(input, s + 1);

		}

	}

	public boolean isPalindrome(String input) {

		for (int left = 0, right = input.length() - 1; left < right; left++, right--) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
		}

		return true;
	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ret = new ArrayList<String>();
		int pre = lower - 1;
		int after = 0;
		for (int i = 0; i < nums.length; i++) {

			after = i == nums.length ? upper + 1 : nums[i];

			if (pre + 2 == after) {
				ret.add(String.valueOf(pre + 1));
			} else if (pre + 2 < after) {
				ret.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
			}
			pre = after;

		}
		ret.add(String.valueOf(pre + 1) + "->" + String.valueOf(upper));
		return ret;
	}

	private void run() {
		// System.out.println(multiplie("123", "456"));

		// palindromePartion("aab", 0);

		// customSortString("cba", "abcd");
		// generateParenthesis(3);

		// reorganizeString("aaaaaaaaaabbbbbccccc");
		// checkValidString("(*)");
		// numDecodings("BC");

		// decodeString("3[a]2[bc]");

		// mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new
		// String[] { "hit" });
		// numJewelsInStones("z", "zz");
		// String[] s = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8
		// act zoo" };
		// reorderLogFiles(s);

		//findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99);
		
		findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

	}

	public static void main(String[] args) {
		new StringSolution().run();

	}

	public String reorganizeString(String S) {
		int N = S.length();
		int[] counts = new int[26];
		for (char c : S.toCharArray())
			counts[c - 'a'] += 100;
		for (int i = 0; i < 26; ++i)
			counts[i] += i;
		// Encoded counts[i] = 100*(actual count) + (i)
		Arrays.sort(counts);

		char[] ans = new char[N];
		int t = 1;
		for (int code : counts) {
			int ct = code / 100;
			char ch = (char) ('a' + (code % 100));
			if (ct > (N + 1) / 2)
				return "";
			for (int i = 0; i < ct; ++i) {
				if (t >= N)
					t = 0;
				ans[t] = ch;
				t += 2;
			}
		}

		return String.valueOf(ans);
	}

	public static boolean checkValidString(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int len = s.length();

		int dp[] = new int[len + 1];

		dp[len] = 1;
		dp[len - 1] = s.charAt(len - 1) != 0 ? 1 : 0;

		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			else {
				dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
			}

		}

		return dp[0];

	}

	public static String mostCommonWord(String paragraph, String[] banned) {

		paragraph = paragraph.toLowerCase();

		Set<String> bannedWords = new HashSet<String>();
		for (String w : banned) {
			bannedWords.add(w);
		}
		Map<String, Integer> counter = new HashMap<String, Integer>();

		String[] words = paragraph.split(" ");

		for (String word : words) {
			word = word.trim();
			if (!Character.isLetter(word.charAt(word.length() - 1))) {
				word = word.substring(0, word.length() - 1);
			}
			if (!bannedWords.contains(word)) {
				counter.put(word, counter.getOrDefault(word, 0) + 1);
			}
		}

		String finalWord = "";
		int mxCount = Integer.MAX_VALUE;

		for (Map.Entry<String, Integer> search : counter.entrySet()) {

			if (mxCount < search.getValue()) {

				finalWord = search.getKey();
				mxCount = search.getValue();
			}

		}

		return finalWord;
	}

	public String decodeString(String s) {

		Stack<String> result = new Stack<String>();
		Stack<Integer> counter = new Stack<Integer>();

		String res = "";
		result.push(res);
		int num = 0;
		for (int i = 0; i < s.length();) {
			num = 0;
			if (Character.isDigit(s.charAt(i))) {

				while (Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				counter.push(num);

			} else if (s.charAt(i) == '[') {
				result.push(res);
				res = "";
				i++;

			} else if (s.charAt(i) == ']') {
				StringBuffer sb = new StringBuffer(result.pop());
				int j = counter.pop();

				while (j > 0) {

					sb.append(res);
					j--;

				}

				res = sb.toString();
				i++;

			} else {

				res += s.charAt(i);
				i++;

			}

		}
		return res.trim();
	}

	public static int numJewelsInStones(String J, String S) {
		int count[] = new int[256];

		for (int c : S.toCharArray()) {

			count[c]++;
		}
		int ans = 0;
		for (int c : J.toCharArray()) {

			if (count[c] > 0) {
				ans += count[c];
				count[c] = 0;
			}
		}
		return ans;
	}

	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {

			public int compare(String log1, String log2) {
				String[] split1 = log1.split(" ", 2);
				String[] split2 = log2.split(" ", 2);
				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
				if (!isDigit1 && !isDigit2) {
					int cmp = split1[1].compareTo(split2[1]);
					if (cmp != 0)
						return cmp;
					return split1[0].compareTo(split2[0]);
				}
				return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

			}

		});

		return logs;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> words = new HashSet<Integer>();
		Set<Integer> doubleWords = new HashSet<Integer>();
		List<String> res = new ArrayList<String>();
		char[] map = new char[26];
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];

			}
			if (!words.add(v) && doubleWords.add(v)) {
				res.add(s.substring(i, i + 10));
			}
		}

		return res;

	}
}
