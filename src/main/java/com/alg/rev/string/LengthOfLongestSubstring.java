package com.alg.rev.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring
{
    public static int lengthOfLongestSubstring(String str)
    {
        if (str == null)
            return -1;
        boolean[] flags = new boolean[256];
        int i = 0;
        int j = 0;
        int logestSubString = 0;
        while (j < str.length())
        {
            char cur = str.charAt(j);

            if (flags[cur])
            {

                logestSubString = Math.max(logestSubString, j - i);
                for (int k = i; k < str.length(); k++)
                {
                    if (str.charAt(k) == cur)
                    {
                        i = k + 1;
                        break;
                    }
                    flags[str.charAt(k)] = false;
                }

            } else
            {

                flags[cur] = true;

            }
            j++;

        }

        return logestSubString = Math.max(logestSubString, j - i);

    }

    public static void main(String[] args)
    {
        // System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("b"));
        String[] words =
        { "foo", "bar" };
        LengthOfLongestSubstring.findSubstring("barfoothefoobarman", words);

    }

    public static List<Integer> findSubstring(String s, String[] words)
    {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
        {
            return result;
        }

        // frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words)
        {
            if (map.containsKey(w))
            {
                map.put(w, map.get(w) + 1);
            } else
            {
                map.put(w, 1);
            }
        }

        int len = words[0].length();

        for (int j = 0; j < len; j++)
        {
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;// start index of start
            int count = 0;// count totoal qualified words so far

            for (int i = j; i <= s.length() - len; i = i + len)
            {
                String sub = s.substring(i, i + len);
                if (map.containsKey(sub))
                {
                    // set frequency in current map
                    if (currentMap.containsKey(sub))
                    {
                        currentMap.put(sub, currentMap.get(sub) + 1);
                    } else
                    {
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while (currentMap.get(sub) > map.get(sub))
                    {
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);

                        count--;
                        start = start + len;
                    }

                    if (count == words.length)
                    {
                        result.add(start); // add to result

                        // shift right and reset currentMap, count & start point
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start = start + len;
                    }
                } else
                {
                    currentMap.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }

        return result;
    }
}
