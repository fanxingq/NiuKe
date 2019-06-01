package com.nk.test3;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
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
			if (isBit(array[i], indexOf1)) {   //������array���ݵ�Nλ��û��1������ֳ������֣�ÿ���ֶ��ǳ���һ��������������������������������ʱ��ֱ��������
				num1[0]^=array[i];
			}else {
				num2[0]^=array[i];
			}
		}
		
    }
	
	//Ѱ�ҵ�NλΪ1��N��array���������������󣬵õ��Ľ��Ӧ����������ͬ�������������������������ͬ��������������
	//����ͬ��������һ���и���NλΪ1��һ��Ϊ0������������ʱ�����������������ҳ���һ��������N
	public int findFirstBitIs(int num){
		
		int indexBit = 0;
		while ((num&1)==0 && indexBit<8*4) {
			
			num = num >> 1;
			++indexBit;
		}
		
		return indexBit;
	}
	
	//�ж�num��Nλ�Ƿ�Ϊ1
	public boolean isBit(int num,int indexBit){
		
		num = num >> indexBit;
		return (num&1) == 1;
		
	}
	
}
