package com.alg.rev.search;

public class ArraySearch {
	public void checkRepeatedElements(int a[]) {

		if (a != null && a.length > 0) {
			int[] count = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				count[a[i]]++;
				if (count[a[i]] == 2) {
					System.out.println(a[i]);
					
				}
			}
		}
	}

	public static void main(String[] args) {
		ArraySearch arraySearch = new ArraySearch();
		int []a={1,1,2,4,10,8,8};
		arraySearch.checkRepeatedElements(a);
	}
}
