package com.alg.rev.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber
{

    public static void main(String[] args)
    {

        int[] num =
        { 3, 30, 34, 5, 9 };

        String[] a = new String[num.length];
        for (int i = 0; i < num.length; i++)
        {
            a[i] = String.valueOf(num[i]);

        }

        Arrays.sort(a, new Comparator<String>()
        {

            public int compare(String o1, String o2)
            {

                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String aStr : a)
        {
            sb.append(aStr);
        }

        System.out.println(sb.toString());
    }

}
