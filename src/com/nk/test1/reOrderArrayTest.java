package com.nk.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 *  
 * @author zheng
 *
 * ����˼·��һ����ð��������һ�����½�һ�����顣
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

			/*//����˼·�ɣ���һ��˼·������ð���㷨��ǰż�������ͽ�����
			class Solution {
			public:
			    void reOrderArray(vector<int> &array) {
			 
			         
			        for (int i = 0; i < array.size();i++)
			        {
			            for (int j = array.size() - 1; j>i;j--)
			            {
			                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //ǰż���潻��
			                {
			                    swap(array[j], array[j-1]);
			                }
			            }
			        }
			    }
			};
			//�ڶ���˼·���ٴ���һ������
			*/
	    //����1
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
			System.out.println("����--"+i);
		}	
		/*
		//�ڶ��ַ���
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
