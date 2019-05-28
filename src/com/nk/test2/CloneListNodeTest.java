package com.nk.test2;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author zheng
 * 
 */
public class CloneListNodeTest {

	public static void main(String[] args) {

		
	}
	
	public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
			return null;
		}
		RandomListNode listNode = pHead;
		//先将整个链表复制
		while (listNode!=null) {
			RandomListNode newNode = new RandomListNode(listNode.label);
			RandomListNode nextNode = listNode.next;
			listNode.next = newNode;
			newNode.next = nextNode;
			listNode = nextNode;        //后移一位直至复制完
			
		}
		//处理random指针的复制
		listNode = pHead;   //每次重新遍历都要重新指向头结点
		while (listNode!=null) {
			listNode.next.random = (listNode.random == null)?null:listNode.random.next;   //将复制节点的random指向原节点的random的下一个节点
			listNode = listNode.next.next;   //listNode指针跳过下一个复制节点指向下一个原节点
			
		}
		//拆分
		listNode = pHead;
		RandomListNode newHead = pHead.next;   //创建新的链表
		while (listNode!=null) {
			RandomListNode newNode = listNode.next;
			listNode.next = newNode.next;
			newNode.next = (newNode.next == null)?null:newNode.next.next;
			listNode = listNode.next;
		}
		
		return newHead;
    }
	
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
