package com.nk.test1;

/**
 * 变态跳台阶 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author zheng
 * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
 * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
 * 所以f(n)=f(n-1)+f(n-2)+...+f(1)
 * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
 * 所以f(n)=2*f(n-1)
 * 
 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况 
 */
public class JumpFloorIITest {

	public static void main(String[] args) {

		int result = JumpFloorII(6);
		System.out.println("结果：" + result);

	}

	public static int JumpFloorII(int target) {

		
		if (target<=0) {
			return -1;
		}
		if (target == 1) {
			return 1;
		}
		int prenum = 1;    //前一个值f(n-1)
		int result = 2;    //后一个值f(n)
		for (int i = 2; i <= target; i++) {
			result = 2*prenum;
			prenum = result;
		}
		return result;
	}

}
