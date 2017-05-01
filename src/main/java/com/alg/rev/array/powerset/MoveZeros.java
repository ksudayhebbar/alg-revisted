package com.alg.rev.array.powerset;

public class MoveZeros
{

    public static void main(String[] args)
    {
        int[] nums =
        { 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
        int i = 0;
        int j = nums.length - 1;
        while (i < j)
        {

            if (nums[i] == 0)
            {
                i++;
                continue;
            }
            if (nums[j] == 1)
            {
                j--;
                continue;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

    }

}
