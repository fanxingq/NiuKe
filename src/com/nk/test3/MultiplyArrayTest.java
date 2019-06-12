package com.nk.test3;

/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 * ����ʹ�ó�����
 * 
 * @author zheng
 * 
 * B[i]�ĳ˻�����û��A[i]
 * ��ָ��˼·��
 * B[i]��ֵ���Կ�����ͼ�ľ�����ÿ�еĳ˻���
 * �����������˿��Ժ�����ã������ǣ���������Ҳ�����ˡ�
 * ������ǵ�˼·�ͺ������ˣ������������е����ˣ������������B[i]�е�һ���֣�Ȼ�󵹹������������еķֲ����ɣ�����һ����Ҳ�˽�ȥ��
 * �����ǣ�B[i+1] = B[i]*A[i]  �����ǣ�����temp�䵱�����ǵ�B[i],���temp����B[i]���˷���B[j]->B[j+1]*A[j+1]
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
