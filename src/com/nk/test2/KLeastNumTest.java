package com.nk.test2;

import java.util.ArrayList;

/**
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * @author zheng
 * 
 * ���������ص㿴����������
 * partition�ķ������ƻ����飬ʹ�����ѵķ�ʽ��ÿ�ζ���Ѷ����бȽϡ�
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
		for (int i = 0; i < k; i++) {   //��ǰk�����ӽ���СΪk������
			num[i] = input[i];
		}
		for (int i = k/2+1; i >= 0 ; i--) {  //�����鹹���������ʽ
			adjustHeap(num, i, k-1);
		}
		for (int i = k; i < input.length; i++) {  //��Ѷ��ȣ����ڸ�С������ʱ
			if (input[i]<num[0]) {
				num[0] = input[i];
				adjustHeap(num, 0, k-1);  //���µ�������
				
			}
		}
		for (int i : num) {
			list.add(i);
		}
		return list;
    }
	
	//����
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
