package com.nk.test1;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * @author zheng
 *
 * ԭʼ����������ģ���СֵΪǰ�������ֵķָ�㣬���ö��ַ�����
 * ��������ָ�룬�ֱ�ָ��������β��ȡ�м�ֵ������βֵ���б�
 * �ϣ���һ������β�� 
 * ���������1,�м�����󲿷֣���ȡ�м䵽���ұ��ⲿ�֣�2���м�С�ڵ����󲿷֣���ȡ����ߵ��м��ⲿ�֡� 
 * ��ֻʣ��������ʱ��ֱ�ӱȽϴ�С��
 * 
 */
public class NumberInRotateArray {

	private static int result = 0;
	public static void main(String[] args) {

		int[] array = {3,4,5,6,1,2};
//		int[] array = {2,3,0,1,1,1};
		int minNum = minNumberInRotateArray(array);
		System.out.println(minNum);
		
	}
	
	public static int minNumberInRotateArray(int [] array) {
		if (array.length == 0) {
			return 0;
		}
		int arrLeft = array[0];
		int arrRight = array[array.length-1];
		
		if (arrLeft<arrRight) {         //����
			return array[0];
		}
		minNum(array,0,array.length-1);
		
		return result;
	    
    }
	
	public static void minNum(int[] arr, int left, int right){

		int mid = (right - left)/2 + left;
		if (right - left == 1) {
			if (arr[left]>arr[right]) {
				result = arr[right];
				return;
			}else {
				result = arr[left];
				return;
			}
		}
		if (arr[mid] < arr[left]) {
			minNum(arr, left, mid);
		}else if (arr[mid] >= arr[left]) {
			minNum(arr, mid, right);
		}
		
	}

}
