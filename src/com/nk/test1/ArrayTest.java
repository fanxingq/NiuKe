package com.nk.test1;

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author zheng
 *
 * ����������Ӷ�ά�������½ǿ�ʼ�Աȣ�֮�����Һ���Աȣ������м���ʱ�������϶Աȡ�
 */
public class ArrayTest {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		int[][] ar = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		boolean find = Find(16, ar);
		System.out.println(find);
	}

	public static boolean Find(int target, int[][] array) {

		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 0; j < array[i].length; j++) {
				if (target == array[i][j]) {
					return true;
				} else if (j == array[i].length - 1) {
					if (target > array[i][j]) {
						return false;
					}
				} else if ((target > array[i][j]) && (target < array[i][j + 1])) {
					for (int m = i; m >= 0; m--) {
						if (target == array[m][j + 1]) {
							return true;
						}

					}
				}

			}

		}

		return false;
	}
}
