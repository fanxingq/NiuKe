package com.nk.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *  
 * @author zheng
 *
 * 两个思路，一个是冒泡排序，另一个是新建一个数组。
 */
public class reOrderArrayTest {

	public static void main(String[] args) {

		int[] array = {1,2,3,4,5,6,7};
		reOrderArray(array);
		
	}

	public static void reOrderArray(int[] array) {

		int left = 0;
		int right = array.length-1;
		int num = 0;

			/*//两个思路吧，第一个思路：类似冒泡算法，前偶后奇数就交换：
			class Solution {
			public:
			    void reOrderArray(vector<int> &array) {
			 
			         
			        for (int i = 0; i < array.size();i++)
			        {
			            for (int j = array.size() - 1; j>i;j--)
			            {
			                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //前偶后奇交换
			                {
			                    swap(array[j], array[j-1]);
			                }
			            }
			        }
			    }
			};
			//第二个思路：再创建一个数组
			*/
	    //方法1
		for (left = 0; left < array.length; left++) {
			
			for (right = array.length-1; right>0; right--) {
				
				if(((array[right] & 1) == 1) && ((array[right-1] & 1) == 0)) {   

					num = array[right];
					array[right] = array[right-1];
					array[right-1] = num;
				}
			}
		}
		for (int i : array) {
			System.out.println("数组--"+i);
		}	
		/*
		//第二种方法
		int[] newArr =new int[array.length]; 
		int i = 0;
		for (left = 0; left < array.length; left++) {
				if ((array[left] & 1) == 0) {
					newArr[num] = array[left];
					num ++;
				}else if ((array[left] & 1) == 1) {
					array[i] = array[left];
					i ++;
				}
		}
		for (int j = 0; j < newArr.length; j++) {
			if (i>= array.length) {
				break;
			}
			array[i] = newArr[j];
			i ++;
		}
		for (int n : array) {
			System.out.println(n);
		}
		*/
	}
}
