package com.nk.test3;

import com.nk.test1.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author zheng
 * 
 * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
 * (因为2个链表用公共的尾部)
 */
public class FindFirstCommonNodeTest {

	public static void main(String[] args) {

		
	}
	
	 public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 
		 int len1 = findListLength(pHead1); 
		 int len2 = findListLength(pHead2);
		 if (len1>len2) {
			pHead1 = walkStep(pHead1, len1-len2);
		}else {
			pHead2 = walkStep(pHead2, len2-len1);
		}
		 
		while (pHead1!=null) {
			if (pHead1 == pHead2) {
				return pHead1;
			}
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		} 
		 
		 return null;
	 }
	 
	 //计算链表的长度
	 public int findListLength(ListNode node){
		 
		 if (node==null) {
			return 0;
		}
		 int sum = 1;
		 while (node.next!=null) {
			sum++;
			node = node.next;
		}
		 return sum;
		 
	 }	 
	 
	 //使长一些的链表走step步
	 public ListNode walkStep(ListNode node,int step){
		 
		 while (step>0) {
			node = node.next;
			step--;
		}
		 
		 return node;
	 }

}
