package com.nk.test3;

import com.nk.test1.ListNode;

/**
 * �������������ҳ����ǵĵ�һ��������㡣
 * 
 * @author zheng
 * 
 * �ҳ�2������ĳ��ȣ�Ȼ���ó���������������ĳ��ȲȻ����һ����
 * (��Ϊ2�������ù�����β��)
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
	 
	 //��������ĳ���
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
	 
	 //ʹ��һЩ��������step��
	 public ListNode walkStep(ListNode node,int step){
		 
		 while (step>0) {
			node = node.next;
			step--;
		}
		 
		 return node;
	 }

}
