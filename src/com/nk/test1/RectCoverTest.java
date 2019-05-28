package com.nk.test1;

/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * @author zheng
 *
 * һ�������ַ��÷�����һ�������ŷţ���ʣ�¿���n-1��2*1������ô�ţ�
 * �ڶ����Ǻ��ŷţ���ʱ����ȥ2��2*1�ľ��Σ���Ϊ�ڶ������ݵ�һ���ķ���ֱ�ӹ̶��ˣ�ʣ�µĿ���n-2��2*1������ô���á�
 * 
 * ��ͺ�֮ǰ������̨�����ƣ�һ����һ����������̨�ס�
 * 쳲���������
 * 
 */
public class RectCoverTest {

	public static void main(String[] args) {

		int result = RectCover(5);
		System.out.println(result);
		
	}

	public static int RectCover(int target) {

		if (target<1) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int vertical = 1;
		int landScape = 2;
		int result = 0;
		for (int i = 3; i <= target; i++) {
			result = landScape + vertical;
			vertical = landScape;
			landScape = result;
		}
		
		return result;
    }
}
