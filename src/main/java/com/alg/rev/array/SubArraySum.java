package com.alg.rev.array;

public class SubArraySum
{

    public static int minSubArraySum(int num[], int n)
    {
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        int sum = 0;
        while (j < num.length)
        {

            if (sum < n)
            {
                sum += num[j];
                j++;

            } else
            {
                minLen = Math.min(minLen, j-i);
                if(i==j-1)
                    return 1;
     
                sum -=num[i];
                i++;

            }

        }
        while(sum>=n){
            minLen = Math.min(minLen, j-i);
     
            sum -=num[i++];
        }
     
        return minLen==Integer.MAX_VALUE? 0: minLen;

    }
    
    public static void main(String[] args)
    {
        int a[]={2,3,1,2,4,3};
        
        System.out.println(SubArraySum.minSubArraySum(a, 7));
        
    }

}
