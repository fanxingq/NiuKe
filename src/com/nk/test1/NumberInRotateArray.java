package com.nk.test1;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author zheng
 *
 * 原始数组是有序的，最小值为前后两部分的分割点，采用二分法查找
 * 定义两个指针，分别指向数组首尾。取中间值，与首尾值进行比
 * 较，首一定大于尾。 
 * 两种情况：1,中间大于左部分，则取中间到最右边这部分；2，中间小于等于左部分，则取最左边到中间这部分。 
 * 当只剩两个数的时候，直接比较大小。
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
		
		if (arrLeft<arrRight) {         //有序
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
