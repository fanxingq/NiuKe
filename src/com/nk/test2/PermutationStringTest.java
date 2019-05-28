package com.nk.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���
 * abc,acb,bac,bca,cab��cba��
 * 
 * @author zheng
 *
 */
public class PermutationStringTest {

	public static void main(String[] args) {

		
		
	}

	public ArrayList<String> Permutation(String str) {
	       List<String> list = new ArrayList<String>();
			if (str!= null && str.length()>0) {
				//�ݹ�ĳ�ʼֵΪ��str���飬�յ�list����ʼ�±�0��
				PermutationHelper(str.toCharArray(), 0, list);
				Collections.sort(list);
			}
			
			return (ArrayList<String>) list;
	    }
	    public void PermutationHelper(char[] cstr, int i, List<String> list){
		
			 //���ǵݹ����ֹ����������i�±��Ѿ��Ƶ�char�����ĩβ��ʱ�򣬿��������һ���ַ�������������
			if (i == cstr.length-1) {
				String string = String.valueOf(cstr);
				if (!list.contains(string)) {
					list.add(string);
	                return;
				}
			}else {
				for (int j = i; j < cstr.length; j++) {
					swap(cstr, i, j);
					PermutationHelper(cstr, i+1, list);
					swap(cstr, i, j);   //ÿ�ν�����Ҫ�ص�ԭ����״̬
				}
			}
			
		}
		
		public void swap(char[] cs, int i, int j){
			
			char temp = cs[i];
			cs[i] = cs[j];
			cs[j] = temp;
			
		}
	
	

	
}
