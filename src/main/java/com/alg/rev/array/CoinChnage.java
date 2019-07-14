package com.alg.rev.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChnage {

	public static int coinChange(int[] coin, int ammount) {

		int dp[] = new int[ammount + 1];

		for (int i = 1; i <= ammount; i++) {

			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= ammount; i++) {

			for (int c : coin) {

				if (i + c <= ammount) {

					if (dp[i] == Integer.MAX_VALUE) {
						dp[i + c] = i + c;

					} else {

						dp[i + c] = Math.max(dp[i] + 1, i + c);
					}
				}

			}
		}
		if (dp[ammount] == Integer.MAX_VALUE) {
			return -1;
		}

		return dp[ammount];

	}

	public static int coinBfs(int[] coin, int amount) {

		Queue<Integer> amountQ = new LinkedList<Integer>();

		Queue<Integer> setps = new LinkedList<Integer>();
		amountQ.offer(0);
		setps.offer(0);
		int s = 0;
		while (!amountQ.isEmpty()) {
			Integer a = amountQ.poll();
			Integer step = setps.poll();

			if (a == amount) {

				s++;

			}

			for (Integer c : coin) {

				if ((a + c) > amount) {
					continue;
				} else {

					amountQ.offer(a + c);
					setps.offer(step++);
				}

			}

		}
		return s;

	}

	public static int change(int amount, int[] coins) {
		int cur[] = new int[amount];

		Arrays.sort(coins);
		
		
	    if(amount<1) return 0;
	     int []dp=new int [amount+1];       
	     int sum=0 ;     
	      while(++sum<amount) {
	             int min=-1;
	              
	              for(int c:coins){
	                  if(sum>=c&&dp[sum-c]!=-1){
	                       int temp=dp[sum-c]+1;  
	                       min=min<0?temp:temp<min?temp:min;   
	                          
	                  }    
	                      
	                      
	              }
	              
	              dp[sum]=min;
	              
	              
	      }     
	         
	            return dp[amount];

		//return change(amount, coins, cur);

	}

	public static int change(int amount, int[] coins, int[] cur) {

		if (amount < 0)
			return -1;

		if (amount == 0) {

			return 0;
		}

		if (cur[amount - 1] != 0) {
			return cur[amount - 1];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {

			int res = change(amount - coins[i], coins, cur);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}

		}
		cur[amount - 1] = min==Integer.MAX_VALUE ?-1:min;

		return cur[amount - 1];

	}

	public static void main(String[] args) {
		System.out.println(change(5,new int[] { 1, 2, 5 }));
		
	}

}
