package com.nk.test3;


/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。]
 * 
 * @author zheng
 * 
 * 递归以及逻辑短路与,即计算&&前部分为假就不计算后面的
 */
public class Sum_SolutionTest {

	public static void main(String[] args) {

		
		
	}
	
	public int Sum_Solution(int n) {
      
		int res = n;
		boolean b = (n>0)&&((res += Sum_Solution(n-1))>0);   //当n=0时，前半段为假，后半段不用判断，直接return结束。
		return res;
		
	}
	
}
