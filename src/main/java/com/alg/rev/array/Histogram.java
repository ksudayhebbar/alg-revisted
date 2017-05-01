package com.alg.rev.array;

import java.util.Stack;

public class Histogram
{

    public int getHistogram(int[] height)
    {

        if (height == null)
            return -1;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i < height.length)
        {

            if (stack.isEmpty() || height[i] >= height[stack.peek()])
            {
                stack.push(i);
                i++;
            } else
            {
                int index = stack.pop();

                int h = height[index];
                int w = stack.isEmpty() ? 1 : i - stack.peek() - 1;
                max = Math.max(max, h * w);

            }

        }

        while (!stack.isEmpty())
        {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;

    }

    public static void main(String[] args)
    {
        Histogram histogram = new Histogram();
        int[] a =
        { 2, 1, 5, 6, 2, 3 };
        histogram.getHistogram(a);

    }

}
