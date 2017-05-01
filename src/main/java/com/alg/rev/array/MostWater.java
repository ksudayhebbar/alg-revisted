package com.alg.rev.array;

public class MostWater
{

    public static int containerWithMostWater(int[] hights)
    {
        int area = 0;

        int left = 0;
        int right = hights.length - 1;
        int maxArea = 0;
        int width = 20;
        while (left < right)
        {
            int length = right - left;
            int hight=Math.min(hights[left], hights[right]);
            area = 10 * length*hight;

            if (hights[left] < hights[right])
            {
                left++;
            } else
            {
                right--;
            }

            if (area > maxArea)
            {

                maxArea = area;
            }
        }

        return maxArea;

    }

    public static void main(String[] args)
    {
        int[] hights =
        { 2, 3, 4, 6, 8, 6 };
        System.out.println(MostWater.containerWithMostWater(hights));
    }

}
