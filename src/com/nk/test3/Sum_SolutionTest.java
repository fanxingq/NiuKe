package com.nk.test3;


/**
 * ��1+2+3+...+n��
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����]
 * 
 * @author zheng
 * 
 * �ݹ��Լ��߼���·��,������&&ǰ����Ϊ�پͲ���������
 */
public class Sum_SolutionTest {

	public static void main(String[] args) {

		
		
	}
	
	public int Sum_Solution(int n) {
      
		int res = n;
		boolean b = (n>0)&&((res += Sum_Solution(n-1))>0);   //��n=0ʱ��ǰ���Ϊ�٣����β����жϣ�ֱ��return������
		return res;
		
	}
	
}
