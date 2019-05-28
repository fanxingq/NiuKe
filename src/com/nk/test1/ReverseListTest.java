package com.nk.test1;

/**
 * ����һ��������ת��������������ı�ͷ��
 * 
 * @author zheng
 * 
 * ��Ҫ�࿴���顣
 */
public class ReverseListTest {

	public static void main(String[] args) {

		
	}
	
	public static ListNode ReverseList(ListNode head) {

		// ÿ��ѭ�������д�����������ʼ������ 0 -> 1 -> 2 -> 3 -> 4 
		// 0 -> 1 -> 2 -> 3 -> 4   oldHeadָ��0�� newHeadָ��0��toBeReversedָ��1
		// 1 -> 0 -> 2 -> 3 -> 4   oldHeadָ��0�� newHeadָ��1��toBeReversedָ��2
		// 2 -> 1 -> 0 -> 3 -> 4  oldHeadָ��0�� newHeadָ��2��toBeReversedָ��3
		// 3 -> 2 -> 1 -> 0 -> 4   oldHeadָ��0�� newHeadָ��3��toBeReversedָ��4
		// 4 -> 3 -> 2 -> 1 -> 0   oldHeadָ��0�� newHeadָ��4��toBeReversedָ��null
		if(head==null)
            return null;
		ListNode pre = null;
		ListNode next = null;
		
		while (head.next!=null) {
			next = head.next;    //��head����һ���ڵ㱣�浽next��
			head.next = pre;     //��head����һ���ڵ�ָ��pre����ת������
			pre = head;
			head = next;
			
		}
		
		return pre;
    
		
	}

}
