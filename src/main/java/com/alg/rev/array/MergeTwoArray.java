package com.alg.rev.array;

public class MergeTwoArray
{

    public static void main(String[] args)
    {
        int[] frist =
        { 4, 5, 6, 7 };
        int[] second =
        { 3, 8, 9 };

        int flength = 0;
        int slength = 0;
        int[] tempArray = new int[(frist.length + second.length) + 1];
        int k = 0;
        while ((flength < frist.length) && slength < second.length)
        {

            if (frist[flength] < second[slength])
            {
                tempArray[k++] = frist[flength];
                flength++;
            } else
            {
                tempArray[k++] = second[slength];
                slength++;
            }

        }

        while (flength < frist.length)
        {
            tempArray[k++] = frist[flength];
            flength++;
        }

        while (slength < second.length)
        {
            tempArray[k++] = second[slength];
            slength++;
        }

    }

}
