package com.nk.test2;

/**
 * [���������������]
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:
 * �ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 * 
 * @author zheng
 *
 * ���ö�̬�滮��
 * �����붯̬�滮
 * ��ͬ�㣺���߶�Ҫ��ԭ������������ӽṹ����,���ǽ�ԭ����ֶ���֮,�ֽ�����ɸ���ģ��С(С�������׽���ĳ���)��������.Ȼ��������Ľ�ϲ�,�γ�ԭ����Ľ�.
 * ��ͬ�㣺���η����ֽ��������⿴���໥�����ģ�ͨ���õݹ�������
 * ��̬�滮���ֽ������������Ϊ�໥������ϵ,���ص����֣���Ҫ���䣬ͨ���õ���������
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
			
			max = Math.max(max+array[i], array[i]);   //�ȱȽ�F(i)��array[i]�Ĵ�С��ȡΪmax������F(i)= F(i-1)+array[i]
			result = Math.max(max, result);   //�ڱȽ�result��max��ֵȡ�������������У�һֱ�ڸ������Ž�
			
		}
		
		return result;
		
    }

	
	
	
}
