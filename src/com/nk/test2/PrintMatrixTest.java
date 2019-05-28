package com.nk.test2;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author zheng
 * 
 * 需多看几次，画图理解、
 */
public class PrintMatrixTest {
	
	public static void main(String[] args) {

//		int[][] arr = { {1,2,3,4 } ,{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] arr = { {1,2,3,4 }};
		int[][] arr = { {1} ,{5},{9},{13}};
//		int[][] arr = { {1,2},{3,4 } ,{5,6},{7,8},{9,10}};
		ArrayList<Integer> list = printMatrix(arr);
		System.out.println(list.toString());
		
		
	}

	
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	    
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rLength = matrix.length;         //行数
		int cLength = matrix[0].length;   //列数
		//计算打印的圈数
		int circle = ((rLength<cLength?rLength:cLength)-1)/2+1;   //行和列谁少选谁
		
		for (int i = 0; i < circle; i++) {
			
			//从左向右打印
			for (int j = i; j < cLength-i; j++) {
				list.add(matrix[i][j]);
			}
			
			//从上到下打印
			for (int j = i+1; j < rLength-i; j++) {
				list.add(matrix[j][cLength-i-1]);
			}
			
			//从右向左打印
			for (int j = cLength-2-i; j >=i && (rLength-i-1)!=i ; j--) {   //针对只有一行的情况
				list.add(matrix[rLength-1-i][j]);
			}
			
			//从下到上打印
			for (int j = rLength-i-2; j >i && (cLength-i-1)!=i ; j--) {    //针对只有一列的情况
				list.add(matrix[j][i]);
				
			}
		
//		System.out.println(list.toString() + "**");
    }
		return list;
			
		
	}
}
