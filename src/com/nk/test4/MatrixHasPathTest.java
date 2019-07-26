package com.nk.test4;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� ���� a b c e s f c s a d e e ������3 X 4
 * �����а���һ���ַ���"bcced"��·����
 * ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 * 
 * @author zheng
 * 
 *         ���ݷ�
 */
public class MatrixHasPathTest {

	public static void main(String[] args) {

	}


//		����˼�룺
//		0.���ݸ������飬��ʼ��һ����־λ���飬��ʼ��Ϊfalse����ʾδ�߹���true��ʾ�Ѿ��߹��������ߵڶ���
//		1.�����������������������飬���ҵ�һ����str�ַ����ĵ�һ��Ԫ����ƥ��ľ���Ԫ�أ�����judge
//		2.����i��j��ȷ��һά�����λ�ã���Ϊ������matrix��һ��һά����
//		3.ȷ���ݹ���ֹ������Խ�磬��ǰ�ҵ��ľ���ֵ�����������Ӧλ�õ�ֵ���Ѿ��߹��ģ��������������ֱ��false��˵������·��ͨ
//		4.��k�����Ǵ��ж����ַ���str�������Ѿ��жϵ������һλ����ʱ˵����ƥ��ɹ���
//		5.������Ǳ���ľ��裬�ݹ鲻�ϵ�Ѱ����Χ�ĸ������Ƿ����������ֻҪ��һ�����ӷ����������ͼ�������������������ĸ��ӵ������Ƿ���ڷ��������ĸ��ӣ�ֱ��k����ĩβ���߲�����ݹ�������ֹͣ��
//		6.�ߵ���һ����˵�������ǲ��ɹ��ģ�����Ҫ��ԭһ�±�־λ����index���ı�־λ��������һ�ֵ��ж�
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		int flag[] = new int[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(matrix, rows, cols, i, j, str, 0, flag))
					return true;
			}
		}
		return false;
	}

	private boolean helper(char[] matrix, int rows, int cols, int i, int j,
			char[] str, int k, int[] flag) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k]
				|| flag[index] == 1)
			return false;
		if (k == str.length - 1)
			return true;
		flag[index] = 1;      //���ߵ�·��1��ʾ
		if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
				|| helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
			return true;
		}
		flag[index] = 0;     //�����ٻָ�
		return false;
	}
}
