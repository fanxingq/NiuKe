package com.nk.test2;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author zheng
 * 
 * ��࿴���Σ���ͼ��⡢
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
		int rLength = matrix.length;         //����
		int cLength = matrix[0].length;   //����
		//�����ӡ��Ȧ��
		int circle = ((rLength<cLength?rLength:cLength)-1)/2+1;   //�к���˭��ѡ˭
		
		for (int i = 0; i < circle; i++) {
			
			//�������Ҵ�ӡ
			for (int j = i; j < cLength-i; j++) {
				list.add(matrix[i][j]);
			}
			
			//���ϵ��´�ӡ
			for (int j = i+1; j < rLength-i; j++) {
				list.add(matrix[j][cLength-i-1]);
			}
			
			//���������ӡ
			for (int j = cLength-2-i; j >=i && (rLength-i-1)!=i ; j--) {   //���ֻ��һ�е����
				list.add(matrix[rLength-1-i][j]);
			}
			
			//���µ��ϴ�ӡ
			for (int j = rLength-i-2; j >i && (cLength-i-1)!=i ; j--) {    //���ֻ��һ�е����
				list.add(matrix[j][i]);
				
			}
		
//		System.out.println(list.toString() + "**");
    }
		return list;
			
		
	}
}
