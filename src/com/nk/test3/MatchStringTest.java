package com.nk.test3;

/**
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * 
 * @author zheng
 * 
 * ����̫���ˣ����Ĵ�
 */
public class MatchStringTest {

	public static void main(String[] args) {

		
		
		
	}

	/*
	 * ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ�� 1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ� 2�����
	 * �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��
	 * 
	 * ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
	 * ����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
	 * 1��ģʽ����2�ַ����൱��x*�����ԣ� 2���ַ�������1�ַ���ģʽ����2�ַ���
	 * 3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
	 */
	public boolean match(char[] str, char[] pattern) {

		if (str == null || pattern == null)
			return false;
		boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
		dp[str.length][pattern.length] = true;
		// ��ʼѭ��
		for (int i = str.length; i >= 0; i--) {// ��ѭ�����ӿմ���ʼƥ��
			for (int j = pattern.length - 1; j >= 0; j--) {// ��ѭ���������һ���ַ���ʼƥ��
				if (j < pattern.length - 1 && pattern[j + 1] == '*') {
					// 1.1����ǰ���
					if (i < str.length
							&& (str[i] == pattern[j] || pattern[j] == '.'))
						dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
					else
						// 1.2��ǰ����
						dp[i][j] = dp[i][j + 2];
				} else {// ������"*",����ǰ�Ƿ����
					if (i != str.length
							&& (str[i] == pattern[j] || pattern[j] == '.')) {// ��ǰ���
						dp[i][j] = dp[i + 1][j + 1];
					}
				}
			}
		}
		return dp[0][0];

	}

}
