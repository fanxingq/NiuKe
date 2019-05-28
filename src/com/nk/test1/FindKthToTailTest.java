package com.nk.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����������������е�����k����㡣
 * @author zheng
 * ����ָ�룬���õ�һ��ָ��͵ڶ���ָ�붼ָ��ͷ��㣬Ȼ�����õ�һ��ָ����(k-1)���������k���ڵ㡣
 * Ȼ������ָ��ͬʱ�����ƶ�������һ����㵽��ĩβ��ʱ�򣬵ڶ����������λ�þ��ǵ�����k���ڵ���.
 * 
 * һ��ָ�������������һ��ָ�������n-k+1���������һ���������n��Ȼ�����ҵ�n-k+1�Ľ��
 */
public class FindKthToTailTest {

	public static void main(String[] args) {

		
		
		
	}
	
	
	public static ListNode FindKthToTail(ListNode head,int k) {

	
		/*
		//�÷���ʱ�临�Ӷ�̫�� 
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode listNode = null;
		while (head.next!=null) {
			list.add(head);
		}
		listNode = list.get(list.size()-k);
		return listNode;*/
		
		if (head==null||k<=0) {
			return null;
		}
		ListNode preIndex = head;
		ListNode lastIndex = head;
		for (int i = 1; i < k; i++) {             //�ӵ�һ���ڵ㿪ʼ��i=1
			if (preIndex.next!=null) {
				preIndex = preIndex.next;
			}else {
				return null;
			}
		}
		while (preIndex.next!=null) {
			lastIndex = lastIndex.next;
			preIndex = preIndex.next;
		}
		
		return lastIndex;
	}
	

}
