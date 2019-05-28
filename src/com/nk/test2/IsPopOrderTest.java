package com.nk.test2;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�� ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У� ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 * 
 * @author zheng
 *
 * 
 */
public class IsPopOrderTest {

	public static void main(String[] args) {

		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		boolean isPopOrder = IsPopOrder(pushA, popA);
		System.out.println(isPopOrder);
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {

		Stack<Integer> stack = new Stack<Integer>();
		if (pushA.length == 0) {
			return false;
		}
		int num = 0;
		for (int i = 0; i < pushA.length; i++) {
            //��ջ����Ⱦͳ�ջ��ÿ�ζ�Ҫ��ջ
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[num]) {
				stack.pop();
				num++;
			}
		}

		if (stack.isEmpty()) {   //ջΪ��ʱ��֤����
			return true;
		}
		return false;

	}
}
