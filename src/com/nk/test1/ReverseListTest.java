package com.nk.test1;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * @author zheng
 * 
 * 需要多看几遍。
 */
public class ReverseListTest {

	public static void main(String[] args) {

		
	}
	
	public static ListNode ReverseList(ListNode head) {

		// 每次循环的情况写出来，假设初始链表是 0 -> 1 -> 2 -> 3 -> 4 
		// 0 -> 1 -> 2 -> 3 -> 4   oldHead指向0， newHead指向0，toBeReversed指向1
		// 1 -> 0 -> 2 -> 3 -> 4   oldHead指向0， newHead指向1，toBeReversed指向2
		// 2 -> 1 -> 0 -> 3 -> 4  oldHead指向0， newHead指向2，toBeReversed指向3
		// 3 -> 2 -> 1 -> 0 -> 4   oldHead指向0， newHead指向3，toBeReversed指向4
		// 4 -> 3 -> 2 -> 1 -> 0   oldHead指向0， newHead指向4，toBeReversed指向null
		if(head==null)
            return null;
		ListNode pre = null;
		ListNode next = null;
		
		while (head.next!=null) {
			next = head.next;    //将head的下一个节点保存到next中
			head.next = pre;     //将head的下一个节点指向pre，反转过来。
			pre = head;
			head = next;
			
		}
		
		return pre;
    
		
	}

}
