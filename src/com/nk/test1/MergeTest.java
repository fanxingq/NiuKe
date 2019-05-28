package com.nk.test1;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author zheng
 *
 * 两种方法：1种逐步向后比较，加入第三个链表；第二种用递归的方式实现 
 * 
 * 链表应该有一个头结点，然后后面动的是另一个节点。
 * 
 */
public class MergeTest {

	public static void main(String[] args) {

		ListNode node= new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node1= new ListNode(3);
		ListNode node21 = new ListNode(7);
		ListNode node31 = new ListNode(8);
        node1.next = node21;
        node21.next = node31;
        System.out.println(node1.toString());
		ListNode merge = Merge(node, node1);
		System.out.println(merge.toString());
		
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
       
		ListNode listNode = null;
		ListNode cu = null;
		if (list1==null ) {
			return list2;
		}else if (list2 == null) {
			return list1;
		}
		
		//非递归
		while (list1!=null && list2!=null) {
			
			if (list1.val<=list2.val) {
				if (listNode == null) {
					listNode = cu = list1;
				}
				else {
					cu.next = list1;
					cu = cu.next;   //向后移一个
				}
				list1 = list1.next;
			}else {
				if (listNode == null) {
					listNode = cu = list2;
				}
				else {
					cu.next = list2;
					cu = cu.next;   //向后移一个
				}
				list2 = list2.next;
			}
		}

			 if(list1==null){
				 listNode.next=list2;
			 }
		    if(list2==null){
			   	listNode.next=list1;
			 }
		
		
//		//递归,剑指offer上解析
//		if (list1.val<list2.val) {
//			listNode = list1;
//			listNode.next = Merge(list1.next, list2);
//		}else {
//			listNode = list2;
//			listNode.next = Merge(list1, list2.next);
//		}
		
		return listNode;
    }

}
