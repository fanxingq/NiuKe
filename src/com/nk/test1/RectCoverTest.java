package com.nk.test1;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author zheng
 *
 * 一共有两种放置方法，一种是竖着放，则剩下考虑n-1个2*1矩形怎么放；
 * 第二种是横着放，此时会用去2个2*1的矩形，因为第二个根据第一个的方法直接固定了，剩下的考虑n-2个2*1矩形怎么放置。
 * 
 * 这就和之前青蛙上台阶类似，一次上一个或者两个台阶。
 * 斐波那契数列
 * 
 */
public class RectCoverTest {

	public static void main(String[] args) {

		int result = RectCover(5);
		System.out.println(result);
		
	}

	public static int RectCover(int target) {

		if (target<1) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int vertical = 1;
		int landScape = 2;
		int result = 0;
		for (int i = 3; i <= target; i++) {
			result = landScape + vertical;
			vertical = landScape;
			landScape = result;
		}
		
		return result;
    }
}
