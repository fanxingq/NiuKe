package com.nk.test3;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,
 * ��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��
 * Ϊ�˷������,�������Ϊ��С����0��
 * 
 * @author zheng  
 * max ��¼ ���ֵ
 * min ��¼  ��Сֵ
 * min ,max ������0
 * �������� 1 max - min <5
 *       2 ��0��û���ظ�������(��)
 *       3 ���鳤�� Ϊ5
 */
public class IsContinuousTest {

	public static void main(String[] args) {

		
	}

	public boolean isContinuous(int [] numbers) {
		
		if (numbers.length<5) {
			return false;
		}
		int[] d = new int[14];  //����d������¼�Ƿ����ظ������֣���ʼֵΪ0
		d[0] = -5;
		int max = -1;
		int min = 14;
		for (int i = 0; i < numbers.length; i++) {
			d[numbers[i]]++;   //�鵽������������ͬ����λ������1
			if (numbers[i] == 0) {
				continue;
			}
			if (d[numbers[i]]>1) {  //�ж�����d�������λ��>1����������ظ�����
				return false;
			}
			if (numbers[i]>max) {
				max = numbers[i];
			}
			if (numbers[i]<min) {
				min = numbers[i];
			}
			
		}
		if (max - min < 5) {
			return true;
		}
		
		return false;
		
	}
	
}
