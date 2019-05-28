package com.nk.test1;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * 
 * @author zheng
 *
 * a.�������������1�׻���2�ף���ô�ٶ���һ��������һ�ף���ôʣ�µ���n-1��̨�ף�������f(n-1);
 * b.�ٶ���һ��������2�ף���ôʣ�µ���n-2��̨�ף�������f(n-2)
 * c.��a\b������Եó�������Ϊ: f(n) = f(n-1) + f(n-2) 
 * d.Ȼ��ͨ��ʵ�ʵ�������Եó���ֻ��һ�׵�ʱ�� f(1) = 1 ,ֻ�����׵�ʱ������� f(2) = 2
 * e.���Է������յó�����һ��쳲��������У�
 *
 */
public class JumpFloorTest {
	
	private static int[] record = null;
	public static void main(String[] args) {

		int jumpFloor = JumpFloor(6);
		System.out.println(jumpFloor);
		
	}
	
	public static int JumpFloor(int target) {

		/*int num1 = 1;
		int num2 = 2;
		int result = 0;
		if (target<1) {
			return -1;
		}else if (target == 1) {
			result = num1;
		}else if (target == 2) {
			result = num2;
		}
		
		for (int i = 2; i < target; i++) {
			result = num1 + num2;
			num1 = num2;
			num2 = result;
		}
		
		return result;*/
		
		if (target<=2) {
			return target;
		}
		if (record == null) {
			record = new int[target];
		}
		if (record[target-2]!=0 && record[target-3]!=0) {
			record[target-1] = record[target-2] + record[target-3];
		}else {
			return JumpFloor(target-1) + JumpFloor(target-2);
		}
		
		return 0;
		
    }

}
