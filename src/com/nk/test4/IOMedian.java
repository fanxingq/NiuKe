package com.nk.test4;

import java.util.PriorityQueue;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * 
 * @author zheng
 * 
 * ʹ�������С����
 */
public class IOMedian {

	// ����������ѣ�lambda���ʽ�˽���
	private static PriorityQueue<Integer> leftHeap = new PriorityQueue<>((x, y) -> y - x);
	// ���������С��
	private static PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
	// ��ǰ����������ż��
	private static boolean isOdd = true;

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 4, 1, 6, 7, 0, 8 };
		for (int i = 0; i < arr.length; i++) {
			Insert(arr[i]);
			Double res = GetMedian();
			System.out.println(res);
		}
	}

	public static void Insert(Integer num) {

		if (isOdd) {// ������������ʱ�� insert�����ݽ��� [��ߣ�����]��
			if (leftHeap.isEmpty()) {
				leftHeap.add(num);
			} else {// ���ʱ��rightHeapһ������null���Ͳ������ˡ�����³���Կ�������
				int rightMin = rightHeap.peek();
				if (num <= rightMin) {// ֱ�Ӳ��뵽[��ߣ���С��]��
					leftHeap.add(num);
				} else {
					rightHeap.add(num);// �Ȱ�cur����[�ұ���СrightMin|��С��]��
					leftHeap.add(rightHeap.poll());// Ȼ���rightMin����[����|������leftMax]��
				}
			}
		} else {// ������ż����ʱ�� insert�����ݽ��� [�ұߣ���С��]��
				// ���ʱ��leftHeapһ������null���Ͳ������ˡ�����³���Կ�������
			int leftMax = leftHeap.peek();
			if (num >= leftMax) {// ֱ�Ӳ��뵽[�ұߣ���С��]��
				rightHeap.add(num);
			} else {
				leftHeap.add(num);// �Ȱ�cur����[�ұ���СrightMin|��С��]�У�
				rightHeap.add(leftHeap.poll());// Ȼ���rightMin����[����|������leftMax]��
			}
		}
		isOdd = !isOdd;// �ı���ż��
	}

	public static Double GetMedian() {

		if (leftHeap.isEmpty())
			return 0.0;
		if (!isOdd)// �������num�ı�����ż�ԣ���������������˼
			return leftHeap.peek() / 1.0;
		else
			return (leftHeap.peek() + rightHeap.peek()) / 2.0;
	}

}
