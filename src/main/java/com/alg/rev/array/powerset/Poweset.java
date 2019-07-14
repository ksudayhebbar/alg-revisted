package com.alg.rev.array.powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Poweset
{
    public static void main(String args[])
    {

    	
             
        
    	
        // int x = set.size() << 1;

        List<Object> list = new ArrayList<Object>();
        list.add(new String("A"));
        list.add(new String("B"));
        list.add(new String("C"));

        /*// int x = list.size() << 1;

        for (int i = 0; i <= 4; i++)
        {

            System.out.println(Integer.toBinaryString(i) + " After Shifting " + Integer.toBinaryString(i<<2));

        }
        for (int i = 0; i <= 4; i++)
        {

            System.out.println(Integer.toBinaryString(i) + " After Shifting " + Integer.toBinaryString(i>>1));
        }

        for (int i = 0; i <= 4; i++)
        {
            System.out.println(Integer.toBinaryString(i) + " After Shifting " + Integer.toBinaryString(i>>>1));

        }*/

        
          ArrayList<ArrayList<Object>> powerSet = Poweset.powerSet(list);
         
    }
    
    public static  class DessendingOrder implements Comparator<Integer[]>{

		

		public int compare(Integer[] o1, Integer[] o2) {
			// TODO Auto-generated method stub
			return o2[0]-o1[1];
		}
    	
    }
    
  
    public List<List<Integer>> subsets(int[] nums) {
        
        
        int s=nums.length<<1;
        Arrays.sort(nums);
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
         List<Integer> ret2=new ArrayList<Integer>();
         for(int k=0;k<nums.length;k++ ){
           for(int i=0;i>=0;i>>=1 ){
             
               if((i&1)==1){
                   ret2.add(nums[i]);
               }
              
              }
             
             ret.add(ret2);
         }
      return ret;
                  
      }

    public static ArrayList<ArrayList<Object>> powerSet(List<Object> set)
    {

        ArrayList<ArrayList<Object>> subSets = new ArrayList<ArrayList<Object>>();

        int x = 1<<set.size() ;

        for (int i = 0; i < x; i++)
        {

            ArrayList<Object> retSubSets = findSubSets(set, i);
            subSets.add(retSubSets);

        }
        return subSets;

    }

    public static ArrayList<Object> findSubSets(List<Object> set, int x)
    {

        ArrayList<Object> sub = new ArrayList<Object>();
        int index = 0;
        for (int k = x;  k >0;  k>>=1)
        {
            System.out.println(Integer.toBinaryString(k) );
            if ((k & 1) == 1)
            {
                Object value = set.get(index);
                sub.add((Object) value);
            }

            index++;

        }
        return sub;
    }

}
