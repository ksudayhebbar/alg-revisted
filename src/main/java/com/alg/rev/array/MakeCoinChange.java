package com.alg.rev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MakeCoinChange
{

    public int makeChange(int amount, int[] denomination, int index)
    {

        if (index >= denomination.length)
            return 1;

        int ways = 0;
        int denoAmt = denomination[index];

        for (int i = 1; i * denoAmt <= amount; i++)
        {

            System.err.println(denomination[index]);

            int storedAmount = amount - i * denoAmt;

            ways += makeChange(storedAmount, denomination, index + 1);
            System.out.println(storedAmount + " " + ways);

        }

        return ways;

    }

    public List<Integer> changeMaker(int change, int[] denominations, int index)
    {
        List<Integer> resultsList = new ArrayList<Integer>();
        int[] resultDenom;
        resultDenom = new int[4];

        if (change <= 1)
        {
            return resultsList;
        }

        while (change >= denominations[index])
        {
            resultDenom[index] += denominations[index];
            System.out.println("ResultsDenom: " + resultDenom[index]);
            change -= denominations[index];
        }
        resultsList.add(resultDenom[index]);

        for (int val : resultDenom)
        {
            System.out.println(val);
        }

        if (change > denominations[index])
        {
            return changeMaker(change -= denominations[index], denominations, ++index);

        }
        return resultsList;
    }

    public long countWays(int S[], int m, int n)
    {
        // Time complexity of this function: O(mn)
        // Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0); // O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

    public static void main(String[] args)
    {
        int[] deno =
        { 25, 10, 5, 1 };

        MakeCoinChange change = new MakeCoinChange();
        // System.out.println(change.makeChange(100, deno, 0));

        System.err.println(change.countWays(deno, deno.length, 100));

        /*
         * for (int way : changeMaker) {
         * 
         * System.out.println(" " + way); }
         */

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("B");
        list1.add("C");
        map.put("A", list1);

        list1 = new ArrayList<String>();
        list1.add("D");
        list1.add("E");
        map.put("B", list1);

        list1 = new ArrayList<String>();
        list1.add("F");
        list1.add("G");
        map.put("C", list1);
        List<String> st = new ArrayList();
        st.add("A");

        StringBuffer sb = new StringBuffer();
        while (!st.isEmpty())
        {
            String ele = st.remove(0);
            if (ele != null)
            {
                sb.append(ele + "-->");
                List<String> sublist = map.get(ele);
                if (sublist != null)
                {
                    for (String node : sublist)
                    {
                        st.add(node);
                    }
                }
            }

        }

    }

}
