package com.nk.test2;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 * 
 * @author zheng
 *
 */
public class MoreThanHalfNum_SolutionTest {

	public static void main(String[] args) {

		
		
		
	}

	public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			}else {
				map.put(array[i], map.get(array[i])+1);
				
			}
			if (map.get(array[i])>(array.length/2)) {
				return array[i];
			}
		}
		
		
		return 0;
    }
	
	
}
