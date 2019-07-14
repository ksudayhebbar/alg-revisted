package com.alg.rev.array;

import java.util.List;

public class ProductArrayItSelf {
	
	public static int[] productarrayitself(int num[]) {
	
		int []ret=new  int[num.length];
		ret[0]=1;
		
		for(int i=1;i<num.length;i++) {
			ret[i]=ret[i-1]*num[i-1];
		}
		
		int right=1;
		for(int i=num.length-1;i>=0;i--) {
			ret[i]*=right;
			right*=num[i];
		}
		
		return ret;
		
		
	}

	public static void main(String[] args) {
		
		productarrayitself(new int[] {1,2,3,4});
	}

}
