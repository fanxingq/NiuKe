package com.nk.test3;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author zheng
 * 
 * 这题太难了！抄的答案
 */
public class MatchStringTest {

	public static void main(String[] args) {

		
		
		
	}

	/*
	 * 当模式中的第二个字符不是“*”时： 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。 2、如果
	 * 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
	 * 
	 * 而当模式中的第二个字符是“*”时：
	 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
	 * 1、模式后移2字符，相当于x*被忽略； 2、字符串后移1字符，模式后移2字符；
	 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
	 */
	public boolean match(char[] str, char[] pattern) {

		if (str == null || pattern == null)
			return false;
		boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
		dp[str.length][pattern.length] = true;
		// 开始循环
		for (int i = str.length; i >= 0; i--) {// 外循环：从空串开始匹配
			for (int j = pattern.length - 1; j >= 0; j--) {// 内循环：从最后一个字符开始匹配
				if (j < pattern.length - 1 && pattern[j + 1] == '*') {
					// 1.1：当前相等
					if (i < str.length
							&& (str[i] == pattern[j] || pattern[j] == '.'))
						dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
					else
						// 1.2当前不等
						dp[i][j] = dp[i][j + 2];
				} else {// 若不是"*",看当前是否相等
					if (i != str.length
							&& (str[i] == pattern[j] || pattern[j] == '.')) {// 当前相等
						dp[i][j] = dp[i + 1][j + 1];
					}
				}
			}
		}
		return dp[0][0];

	}

}
