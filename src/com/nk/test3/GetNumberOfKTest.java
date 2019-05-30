package com.nk.test3;

import java.util.HashMap;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 
 * @author zheng
 * 二分查找
 */
public class GetNumberOfKTest {

	public static void main(String[] args) {

		
	}

	public int GetNumberOfK(int [] array , int k) {
	    
		/*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i])==null) {
				map.put(array[i], 1);
			}else {
				map.put(array[i], map.get(array[i])+1);
			}
		}
		if (map.get(k)!=null) {
			return map.get(k);
		}
		
		return 0;*/
		
		
		return bioSearch(array, k+0.5) - bioSearch(array, k-0.5);   //因为是整数，所以选k+-0.5，这其中包含的数就是k的个数
		
		
    }
	
	public int bioSearch(int[] data, double num){
		
		int s = 0;
		int e = data.length - 1;
		while (s<=e) {        //二分查找
			int mid = (e-s)/2+s;
			if (data[mid] < num) {
				s = mid+1;
			}else if (data[mid] > num) {
				e = mid-1;
			}
		}
		
		return s;
	}
}
