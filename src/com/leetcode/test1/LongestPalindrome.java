package com.leetcode.test1;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * @author zheng
 * 
 * T5
 * 首先应该想到暴力解法
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 */
public class LongestPalindrome {

	public static void main(String[] args) {

		String str = "abcdcbad";
		System.out.println(longestPalindrome2(str));
		
		
	}

	/**
	 * 方法1：暴力法，超时
	 * @param s
	 * @return
	 * 
	 *  时间复杂度：O(n^3)
	 *  空间复杂度：O(1),常量
	 */
	public static String longestPalindrome1(String s) {
    
		String res = "";
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String string = s.substring(i, j);
				if (isPalindrome(string)) {
					if (len<string.length()) {
						len = string.length();
						res = string;
					}
				}
			}
		}
		return res;
    }
	
	/**
	 * 判断是不是回文
	 * @param string
	 * @return
	 */
	public static boolean isPalindrome(String string){
		
		int len = string.length();
		for (int i = 0; i < len/2; i++) {
			if (string.charAt(i) != string.charAt(len-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 方法2：最长公共子串
	 * @param s
	 * @return
	 * 
	 * 把原来的字符串倒置，然后找最长的公共子串就可以了
	 * 动态规划
	 * 时间复杂度 O(n²)
	 * 空间复杂度降为 O(n),使用了一维数组，没用二维数组
	 */
	public static String longestPalindrome2(String s) {
		
		if (s.equals("")) {
			return "";
		}
		String origin = s;  //原数组
		String reverse = new StringBuffer(s).reverse().toString();   //将字符串反转
		int length = s.length();
		int[] arr = new int[length];  //存放反转后与原字符串对比的结果，不匹配就为0，匹配一个就置为1，后续+1，反转后的字符串从最后开始向前算
		int maxLen = 0;
		int maxEnd = 0;
		for (int i = 0; i < length; i++) {
			for (int j = length-1; j >= 0; j--) {
				if (origin.charAt(i) == reverse.charAt(j)) {   //比对值是否一样
					if (i==0 || j==0) {
						arr[j] = 1;   //f(0) = 1,
					}else {
						arr[j] = arr[j-1] +1;      //f(n) = f(n-1) +1;
					}
				}else {
					arr[j] = 0;  //不满足置为0
				}
				if (arr[j]>maxLen) {
					int beforeRev = length-1-j;
					if (beforeRev + arr[j]-1 == i) {
						maxLen = arr[j];     //将长度存进数组
						maxEnd = i;   //最后一个的下标
					}
				}
			}
		}
		
		return s.substring(maxEnd-maxLen+1,maxEnd+1);
	}
	
	/**
	 * 方法3：暴力破解的优化  P(i,j)=(P(i+1,j−1) and (Si==Sj)
	 * 如果有一个是回文，那么它左右如果相等的话也是回文
	 * @param s
	 * @return
	 * 
	 * 时间：n^2 ,空间 n
	 */
	public static String longestPalindrome3(String s) {
		
		int len = s.length();
		String res = "";
		boolean[] P = new boolean[len];
		for (int i = len-1; i >=0; i--) {
			for (int j = len-1; j >= i; j--) {
				P[j] = s.charAt(i) == s.charAt(j) && (j-i<3 || P[j-1]);   //j-i<3 是f(1)和f(2)的情况
				if (P[j] && (j-i+1>res.length())) {
					res = s.substring(i,j+1);
				}
			}
		}
		
		return res;
	}
	
	/**
	 * 方法4：中心扩展算法
	 * @param s
	 * @return
	 *  
	 *  每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
	 *  由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
	 *  时间复杂度：O(n²）  空间：O(1)
	 */
	public static String longestPalindrome4(String s) {
		
		if (s==null || s.length()<1) {
			return "";
		}
		int start = 0,end = 0;
		for (int i = 0; i < s.length(); i++) {
			
			int len1 = expandAroundCenter(s, i, i);  //奇数偶数不一样，有的是从两个中间开始，就是i和i+1，有的是从其中一个开始，也就是i，i一直从0向后走
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if (len>end-start) {
				start = i-(len-1)/2;
				end = i + len/2;
			}
		}
		return s.substring(start,end+1);
	}
	
	//判断是否相等
	public static int expandAroundCenter(String s,int left,int right){
		
		int L = left,R = right;
		while (L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		
		return R-L-1;
	}
	
}
