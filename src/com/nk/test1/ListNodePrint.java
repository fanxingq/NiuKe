package com.nk.test1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 链表打印 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 
 * @author zheng
 *
 */
public class ListNodePrint {

	public static void main(String[] args) {

		ListNode listNode = null;
		printListFromTailToHead(listNode);

	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		 Stack<Integer> stack = new Stack<Integer>();
		 ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 while (listNode!=null) { //使用栈，先将数据压进栈中，再取出来
		 stack.push(listNode.val);
		 listNode = listNode.next;
		 }
		
		 while (!stack.empty()) {
		
		 arrayList.add(stack.pop());
		 }
		 return arrayList;

//		//复杂度太大不能通过。
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		while (listNode != null) {
//			printListFromTailToHead(listNode.next);
//			arrayList.add(listNode.val);
//		}
//		return arrayList;

	}

}

