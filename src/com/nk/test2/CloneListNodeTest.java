package com.nk.test2;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
		//�Ƚ�����������
		while (listNode!=null) {
			RandomListNode newNode = new RandomListNode(listNode.label);
			RandomListNode nextNode = listNode.next;
			listNode.next = newNode;
			newNode.next = nextNode;
			listNode = nextNode;        //����һλֱ��������
			
		}
		//����randomָ��ĸ���
		listNode = pHead;   //ÿ�����±�����Ҫ����ָ��ͷ���
		while (listNode!=null) {
			listNode.next.random = (listNode.random == null)?null:listNode.random.next;   //�����ƽڵ��randomָ��ԭ�ڵ��random����һ���ڵ�
			listNode = listNode.next.next;   //listNodeָ��������һ�����ƽڵ�ָ����һ��ԭ�ڵ�
			
		}
		//���
		listNode = pHead;
		RandomListNode newHead = pHead.next;   //�����µ�����
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
