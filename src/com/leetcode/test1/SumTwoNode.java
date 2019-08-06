package com.leetcode.test1;

import java.util.Arrays;

import com.nk.test1.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * @author zheng
 *
 */
public class SumTwoNode {

	public static void main(String[] args) {

		 StringBuffer sb1 = new StringBuffer();
		 sb1.append(1);
		 sb1.append(3);
		 
		System.out.println(sb1.toString());
		
		ListNode node= new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
		
	}

	//不能直接相加，要一位一位加
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	      
		 ListNode dummyHead = new ListNode(0);
		    ListNode p = l1, q = l2, curr = dummyHead;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.val : 0;
		        int y = (q != null) ? q.val : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new ListNode(sum % 10);
		        System.out.println(curr);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    //最后进位使用
		    if (carry > 0) {
		        curr.next = new ListNode(carry);
		        System.out.println("*"+curr);
		    }
		    return dummyHead.next;
	 }
	
//	 java.lang.NullPointerException
//	  at line 27, Solution.addTwoNumbers
//	  at line 54, __DriverSolution__.__helper__
//	  at line 81, __Driver__.main
	
}
