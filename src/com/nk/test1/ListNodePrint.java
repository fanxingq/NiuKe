package com.nk.test1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * �����ӡ ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
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
		 while (listNode!=null) { //ʹ��ջ���Ƚ�����ѹ��ջ�У���ȡ����
		 stack.push(listNode.val);
		 listNode = listNode.next;
		 }
		
		 while (!stack.empty()) {
		
		 arrayList.add(stack.pop());
		 }
		 return arrayList;

//		//���Ӷ�̫����ͨ����
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		while (listNode != null) {
//			printListFromTailToHead(listNode.next);
//			arrayList.add(listNode.val);
//		}
//		return arrayList;

	}

}

