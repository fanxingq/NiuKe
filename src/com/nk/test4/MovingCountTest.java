package com.nk.test4;

/**
 * ������һ��m�к�n�еķ��� һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * @author zheng
 *
 */
public class MovingCountTest {

	public static void main(String[] args) {

	}

	public int movingCount(int threshold, int rows, int cols) {

		int flag[][] = new int[rows][cols]; // ��¼�Ƿ��Ѿ��߹�
		return helper(0, 0, rows, cols, flag, threshold);
	}

	private int helper(int i, int j, int rows, int cols, int[][] flag,
			int threshold) {
		if (i < 0 || i >= rows || j < 0 || j >= cols
				|| numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
			return 0;
		flag[i][j] = 1;
		return helper(i - 1, j, rows, cols, flag, threshold)
				+ helper(i + 1, j, rows, cols, flag, threshold)
				+ helper(i, j - 1, rows, cols, flag, threshold)
				+ helper(i, j + 1, rows, cols, flag, threshold) + 1;
	}

	private int numSum(int i) {
		int sum = 0;
		do {
			sum += i % 10;
		} while ((i = i / 10) > 0);
		return sum;
	}
}
