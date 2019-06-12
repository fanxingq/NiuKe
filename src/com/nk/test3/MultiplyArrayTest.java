package com.nk.test3;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * 
 * @author zheng
 * 
 * B[i]的乘积里面没有A[i]
 * 剑指的思路：
 * B[i]的值可以看作下图的矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 * 下三角：B[i+1] = B[i]*A[i]  上三角：借助temp充当下三角的B[i],最后temp再与B[i]做乘法；B[j]->B[j+1]*A[j+1]
 */
public class MultiplyArrayTest {

	public static void main(String[] args) {

		
	}

	public int[] multiply(int[] A) {

		int length = A.length;
		int[] B = new int[length];
		if (length!=0) {
			B[0] = 1;
			for (int i = 1; i < length; i++) {
				B[i] = A[i-1] * B[i-1];
			}
			
			int temp = 1;
			for (int j = length-2; j >= 0; j--) {
				temp = temp * A[j+1];
				B[j] = temp * B[j];
			}
		}
		
		return B;
    }
	
	
}
