package com.nk.test3;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 
 * @author zheng
 *
 */
public class FindNumsAppearOnceTest {

	public static void main(String[] args) {

		
	}
	
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        
		if (array == null || array.length<2) {
			return;
		}
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			temp ^= array[i];
		}
		int indexOf1 = findFirstBitIs(temp);
		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], indexOf1)) {   //将数组array根据第N位有没有1，将其分成两部分，每部分都是除了一个数，其他数都是两个，做异或运算的时候直接消除。
				num1[0]^=array[i];
			}else {
				num2[0]^=array[i];
			}
		}
		
    }
	
	//寻找第N位为1的N，array数组做完异或运算后，得到的结果应该是两个不同数的异或运算结果，其他两两相同的数都被抵消了
	//不相同的两个数一定有个第N位为1，一个为0，做异或运算的时候消不掉，所以先找出来一个这样的N
	public int findFirstBitIs(int num){
		
		int indexBit = 0;
		while ((num&1)==0 && indexBit<8*4) {
			
			num = num >> 1;
			++indexBit;
		}
		
		return indexBit;
	}
	
	//判断num第N位是否为1
	public boolean isBit(int num,int indexBit){
		
		num = num >> indexBit;
		return (num&1) == 1;
		
	}
	
}
