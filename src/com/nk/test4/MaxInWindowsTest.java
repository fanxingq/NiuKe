package com.nk.test4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 * @author zheng
 * ˼·����������Ӧ���Ƕ��У���Ϊ�˵õ��������ڵ����ֵ����������Դ�����ɾ��Ԫ�أ����ʹ��˫�˶��С�
 *     ԭ��
 *     ��������Ԫ��k��������˫�˶����е�Ԫ����Ƚ�
 *     1��ǰ���kС�ģ�ֱ���Ƴ����У���Ϊ���ٿ��ܳ�Ϊ���滬�����ڵ����ֵ��!��,
 *     2��ǰ���k���X���Ƚ������±꣬�ж�X�Ƿ��Ѳ��ڴ���֮�ڣ������ˣ�ֱ���Ƴ�����
 *     ���еĵ�һ��Ԫ���ǻ��������е����ֵ
 */
public class MaxInWindowsTest {

	public static void main(String[] args) {

		
		
		
	}

	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || num.length == 0 || size<=0 || num.length<size) {
			return new ArrayList<Integer>();
		}
        ArrayList<Integer> result = new ArrayList<Integer>();
        //˫�˶��У�������¼ÿ�����ڵ����ֵ
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i++) {
			while (!qmax.isEmpty() && num[qmax.peekLast()]<num[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			//�ж϶���Ԫ���Ƿ����
			if (qmax.peekFirst() == i-size) {
				qmax.pollFirst();
			}
			//��result�б��м���Ԫ��
			if (i>=size-1) {
				result.add(num[qmax.peekFirst()]);
			}
		}
		
		return result;
    }
	
	
}
