package com.leetcode.test1;

import java.util.HashMap;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * 
 * @author zheng
 * 
 * T3
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {

		String s = "abbad";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}

	public static int lengthOfLongestSubstring(String s) {
        
		/**
		 * ��ǩ���������ڱ����ⷨʱ�临�ӶȽϸߣ���ﵽ O(n^2)��
		 * �ʶ���ȡ�������ڵķ�������ʱ�临�Ӷȶ���һ�� map ���ݽṹ�洢 (k, v)������ key ֵΪ�ַ���value ֵΪ�ַ�λ�� +1��
		 * �� 1 ��ʾ���ַ�λ�ú�һ���ſ�ʼ���ظ����Ƕ��岻�ظ��Ӵ��Ŀ�ʼλ��Ϊ start������λ��Ϊ end���� end���ϱ������
		 * �������� [start, end] �������ַ���ͬ���������ʱ���ַ���Ϊ key ֵ����ȡ�� value ֵ�������� start��
		 * ��ʱ [start, end] �����ڲ������ظ��ַ������Ƿ���� start����������� map ���ݽṹ�ͽ�� ans��
		 * ʱ�临�Ӷȣ�O(n)
		 */
		
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();
		int start = 0;
		for (int end = 0; end < c.length; end++) {
			
			if (map.containsKey(c[end])) {
				start = Math.max(start, map.get(c[end]));       //��start����Ϊmap���value����һ������λ�ã�map�����Ŀǰ���µ�key��Ӧ��valueֵ
			}
			result = Math.max(result, end-start+1);      //result������µĽ����ÿ�ζ�Ҫ�Ƚϸ���
			map.put(c[end], end+1);
			
		}
		
		return result;
    }
}
