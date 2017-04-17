package com.alg.rev.array;

public class RemoveDups
{

    
    public static int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;
 
        int prev = 0; // point to previous
        int curr = 1; // point to current
 
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
 
        return prev + 1;
    }
    
    public static void main(String[] args)
    {
        int []a={1,2,2,3,3,4,4,4,5,6};
        RemoveDups.removeDuplicates(a);
    }
}
