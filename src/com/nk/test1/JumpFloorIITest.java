package com.nk.test1;

/**
 * ��̬��̨�� һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 * 
 * @author zheng
 * ��Ϊn��̨�ף���һ����n����������1������2��������n��
 * ��1����ʣ��n-1������ʣ��������f(n-1)
 * ��2����ʣ��n-2������ʣ��������f(n-2)
 * ����f(n)=f(n-1)+f(n-2)+...+f(1)
 * ��Ϊf(n-1)=f(n-2)+f(n-3)+...+f(1)
 * ����f(n)=2*f(n-1)
 * 
 * ÿ��̨�׶������벻������������������һ��̨�ף������һ��̨�ױ����������Թ���2^(n-1)����� 
 */
public class JumpFloorIITest {

	public static void main(String[] args) {

		int result = JumpFloorII(6);
		System.out.println("�����" + result);

	}

	public static int JumpFloorII(int target) {

		
		if (target<=0) {
			return -1;
		}
		if (target == 1) {
			return 1;
		}
		int prenum = 1;    //ǰһ��ֵf(n-1)
		int result = 2;    //��һ��ֵf(n)
		for (int i = 2; i <= target; i++) {
			result = 2*prenum;
			prenum = result;
		}
		return result;
	}

}
