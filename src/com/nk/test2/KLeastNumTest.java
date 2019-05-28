package com.nk.test2;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author zheng
 * 
 * 【需重新重点看，最大堆排序】
 * partition的方法会破坏数组，使用最大堆的方式，每次都与堆顶进行比较。
 * 
 */
public class KLeastNumTest {

	public static void main(String[] args) {

		
		
	}

	
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (input == null || k < 0 || k > input.length) {
			return list;
		}
		int[] num = new int[k];
		for (int i = 0; i < k; i++) {   //将前k个数加进大小为k的数组
			num[i] = input[i];
		}
		for (int i = k/2+1; i >= 0 ; i--) {  //将数组构造成最大堆形式
			adjustHeap(num, i, k-1);
		}
		for (int i = k; i < input.length; i++) {  //与堆顶比，存在更小的数字时
			if (input[i]<num[0]) {
				num[0] = input[i];
				adjustHeap(num, 0, k-1);  //重新调整最大堆
				
			}
		}
		for (int i : num) {
			list.add(i);
		}
		return list;
    }
	
	//最大堆
	public static void adjustHeap(int[] arr,int start,int end){
		
		int temp = arr[start];
		int child = 2*temp + 1;
		while (child<=end) {
			if (child +1 <= end && arr[child+1]>arr[child]) {
				child ++;
			}
			if (arr[child]<temp) {
				break;
			}
			
			arr[start] = arr[child];
			start = child;
			child = child*2 + 1;
			
		}
		
		arr[start] = temp;
		
	}
	
}
