package com.nk.test3;

import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * ��Ӧÿ�����԰����������������С�������.
 * 
 * @author zheng
 * 
 * �������������������ͷβ����ָ��i��j��
 * ��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС��
 * ��ai + aj > sum��aj�϶����Ǵ�֮һ��ǰ���ѵó� i ǰ��������ǲ����ܣ���j -= 1
 * ��ai + aj < sum��ai�϶����Ǵ�֮һ��ǰ���ѵó� j ����������ǲ����ܣ���i += 1
 * O(n)
 */
public class FindNumbersWithSumArrayTest {

	public static void main(String[] args) {

		
	}

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length<2) {   //����Ԥ��
			return list;
		}
		int low = 0,high = array.length-1;
		while (low<high) {
			int cur = array[low] + array[high];
			if (cur == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			}else if (cur>sum) {
				high--;
			}else {
				low++;
			}
		}
		
		return list;
    }
	
	
}
