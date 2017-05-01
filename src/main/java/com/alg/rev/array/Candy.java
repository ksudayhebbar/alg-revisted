package com.alg.rev.array;

import java.util.Arrays;

public class Candy
{

    public int CoundCandy(int[] rating)
    {
        int maxCanday = 0;
        int[] candy = new int[rating.length];
        Arrays.sort(rating);
        candy[0] = 1;
        for (int i = 1; i < rating.length; i++)
        {

            if (rating[i] == rating[i - 1])
            {
                candy[i] = candy[i - 1];
            } else if (rating[i] > rating[i - 1])
            {

                candy[i] = candy[i - 1] + 1;
            } else
            {
                candy[i] = 1;
            }

        }

        for (int i = rating.length - 2; i > 0; i--)
        {

            int cur = 1;
            if (rating[i] > rating[i + 1])
            {
                cur = candy[i + 1] + 1;
            }

            maxCanday += Math.max(cur, candy[i]);
            candy[i] = cur;

        }

        return maxCanday;

    }

    public static void main(String[] args)
    {
        Candy candy = new Candy();
        int[] rating =
        { 2, 3, 5, 1, 6, 2, 3 };
        candy.CoundCandy(rating);
    }

}
