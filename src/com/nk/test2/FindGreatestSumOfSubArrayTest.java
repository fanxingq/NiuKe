package com.nk.test2;

/**
 * [连续子数组的最大和]
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * @author zheng
 *
 * 采用动态规划。
 * 分治与动态规划
 * 共同点：二者都要求原问题具有最优子结构性质,都是将原问题分而治之,分解成若干个规模较小(小到很容易解决的程序)的子问题.然后将子问题的解合并,形成原问题的解.
 * 不同点：分治法将分解后的子问题看成相互独立的，通过用递归来做。
 * 动态规划将分解后的子问题理解为相互间有联系,有重叠部分，需要记忆，通常用迭代来做。
 */
public class FindGreatestSumOfSubArrayTest {

	public static void main(String[] args) {

		int[] array = {1,-2,3,10,-4,7,2,-5};
		int i = FindGreatestSumOfSubArray(array);
		System.out.println(i);
		
	}
	
	
	public static int FindGreatestSumOfSubArray(int[] array) {
        
		if (array.length<=1) {
			return -1;
		}
		int result = array[0];
		int max = array[0];
		
		for (int i = 1; i < array.length; i++) {
			
			max = Math.max(max+array[i], array[i]);   //先比较F(i)和array[i]的大小，取为max。其中F(i)= F(i-1)+array[i]
			result = Math.max(max, result);   //在比较result和max的值取最大。在这个过程中，一直在更新最优解
			
		}
		
		return result;
		
    }

	
	
	
}
