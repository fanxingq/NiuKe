package com.nk.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * @author zheng
 *
 * �Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ��������
 * 
 * ���ڱȽ��������������е�{3��32��321} �������ȷ���3������3��32�Ƚϣ�
 * ��Ϊ332>323 ����3>32 �����ʱΪ[32,3]; 
 * ���������м���321������32�Ƚϣ�32132<32321 �� 321<32  
 * ��321Ӧ����32ǰ�棬����3�Ƚ� 3213<3321 ��321<3 ������������[321��32��3]
 *
 */
public class ArrayMinNumberTest {

	public static void main(String[] args) {

		int[] array = {3,32,321};
		String string = PrintMinNumber(array);
		System.out.println(string);
		
		
	}

	public static String PrintMinNumber(int [] numbers) {

		String str = "";
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {   //�Ƚ�����ʵ�ֽӿڵ������ڲ��ࡣ����ָ���� Comparator ������˳��� List ����Ԫ�ؽ�������

			@Override
			public int compare(Integer n1, Integer n2) {

				String str1 = n1 + "" + n2;
				String str2 = n2 + "" + n1;
				
				
				return str1.compareTo(str2);  //�Ƚ�������һ���ӿڣ�ͨ��ʵ������ӿ���дcompare������������ֵ������ڷ���0������ڣ����ظ�ֵ����С�ڡ�
			}
			
		}); 
		
		for (Integer i : list) {
			str += i;
		}
		
		return str;
    }
	
	
	
	
}
