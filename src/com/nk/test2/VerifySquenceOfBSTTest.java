package com.nk.test2;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ���� ����������Yes,�������No�� �������������������������ֶ�������ͬ��
 * 
 * @author zheng
 * 
 * ����������������<��<������
 * ����1 4 3 5��������������ĺ��������û��������������rһֱ��Ӧ����4���������
 * ��return judge(a, l, i - 1) && (judge(a, i, r - 1))�еĵڶ����ݹ飬i=r,r-1<r,����Ӧ���Ƿ���true.
 * l==r��Ӧ����Ҷ�ӽ�㣬l>r��Ӧ���ǿ������������������true��
 * l��Ӧstart��r��Ӧend
 */
public class VerifySquenceOfBSTTest {

	public static void main(String[] args) {

//		 int[] arr = {1,2,3,5,6,7,4};
//		int[] arr = { 1, 3, 5, 6, 2, 4 };
//		int[] arr = {5,4,3,2,1};
		int[] arr = {7,4,6,5};
		boolean result = VerifySquenceOfBST(arr);
		System.out.println(result);
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {

//		if (sequence.length == 0) {
//			return false;
//		}
//		if (sequence.length == 1) {
//			return true;
//		}
//		boolean result = postTree(sequence, 0, sequence.length - 1);
////
//		return result;

		// �ǵݹ�
		// �ǵݹ�Ҳ��һ�����ڵݹ��˼�룺
		// ������һ����������С�����ȥ���������ַ�Ϊleft��right�����֣�right���ֵ�
		// ���һ���������������ĸ���Ҳ������������ֵ��������ǿ���ÿ��ֻ���������Ƿ��������
		// ���ɣ���ʹ������������������Ҳ���Կ���������������ɵ���������������������

		// �����������ص���ԭ���⣬������������������������ֵ�����������ĸ�С������ʱ����������������������
		// ֻ�迴�����������������Ƿ����Ҫ�󼴿�
		int size = sequence.length;
		if (size == 0) {
			return false;
		}
		int i = 0;
		while (--size!=0) {
			
			while (sequence[i]<sequence[size]){     //�Ƚ����������˳�ȥ
				i++;
			}
			while (sequence[i]>sequence[size]){    //�������������Ҹ�����ʼ�Ƚϣ��Ƚϵ���һ������С�ڵ��ڸ���ֵ
				i++;
			}
			if (i<size) {      //�Ƚϴ�ʱ��i�͸��Ĺ�ϵ���ж��Ƿ��Ƿ��Ϻ��������
				return false;
			}
			i = 0;    //����һλ�������Ƚϡ�������һ���������������Կ����Ȳ�������������ֻ�Ƚ��������͸���
			
		}
		return true;
	}

/*	public static boolean postTree(int[] arr, int pre, int post) {

		if (pre>=post) {
			return true;
		}
		int i = pre;
		while (arr[i] < arr[post]) {
			++i;

		}
		for (int j = i; j < post; j++) {
			if (arr[j]<arr[post]) {
				return false;
			}
		}
		
		return postTree(arr, pre, i-1) && postTree(arr, i, post-1);
		
	}*/

		
	
	
	
	
}
