package com.nk.test3;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * 
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��.
 * 
 * @author zheng
 *
 * ˫ָ�뼼���������൱����һ�����ڣ����ڵ��������߾�������ָ�룬���Ǹ��ݴ�����ֵ֮����ȷ�����ڵ�λ�úͿ�ȡ�
 * 
 */
public class FindContinuousSequenceTest {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = FindContinuousSequence(100);
		System.out.println(list.toString());
	}

	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	 
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int plow = 1,phigh = 2;
		
		while (plow<phigh) {
			int cur = (plow + phigh)*(phigh-plow+1)/2;   //�Ȳ�������͹�ʽ Sn = (a0+an)*n/2;
			if (cur == sum) {   //�������ʱ���ͽ����������ֵ�ӽ�list��
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = plow; i <= phigh; i++) {
					list.add(i);
				}
				res.add(list);
				plow++;
			}else if (cur<sum) {   //����õĺ�С��sumʱ���ͽ�phighָ������һλ
				phigh++;
			}else {   //����õĺʹ���sumʱ���ͽ�plowָ������һλ
				plow++;
			}
			
		}

		return res;
		
    }
	
	//[[9, 10, 11, 12, 13, 14, 15, 16], [18, 19, 20, 21, 22]]
	
	
	
}
