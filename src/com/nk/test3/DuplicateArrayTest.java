package com.nk.test3;

import java.util.HashSet;

/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * 
 * @author zheng
 *
 */
public class DuplicateArrayTest {

	public static void main(String[] args) {

		
		
	}

	// Parameters:
    // numbers:an array of integers
    // length: the length of array numbers
    // duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    // Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    // ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:true if the input is valid, and there are some duplications in the array number
    // otherwise false
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	   
		HashSet<Integer> hashSet = new HashSet<Integer>();        //�ҵ��ظ������ַŽ�duplication����0λ�ô�
		for (int i = 0; i < length; i++) {
			
			if (!hashSet.add(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			}
		}
		
		
		return false;
		
/*		for (int i = 0; i != length; ++i) {        //���ʱ���hashset��
			int index = numbers[i] % length;
			if (numbers[index] >= length) {
				duplication[0] = index;
				return true;
			}
			numbers[index] += length;
		}
		return false;*/
    }
	
	
}
