package com.nk.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author zheng
 * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
 * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了.
 * 
 * 一个指针遍历了链表，另一个指针遍历到n-k+1，如果遍历一遍链表求得n，然后再找到n-k+1的结点
 */
public class FindKthToTailTest {

	public static void main(String[] args) {

		
		
		
	}
	
	
	public static ListNode FindKthToTail(ListNode head,int k) {

	
		/*
		//该方法时间复杂度太大 
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
		for (int i = 1; i < k; i++) {             //从第一个节点开始，i=1
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
