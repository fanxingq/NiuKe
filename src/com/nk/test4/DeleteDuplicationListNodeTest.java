package com.nk.test4;

import com.nk.test1.ListNode;

/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 ������Ϊ 1->2->5
 * 
 * @author zheng
 *
 */
public class DeleteDuplicationListNodeTest {

	public static void main(String[] args) {

		
		
	}

    public ListNode deleteDuplication(ListNode pHead)
    {

		if (pHead == null || pHead.next == null) { // ֻ��0����1����㣬�򷵻�
			return pHead;
		}
		if (pHead.val == pHead.next.val) { // ��ǰ������ظ����
			ListNode pNode = pHead.next;
			while (pNode != null && pNode.val == pHead.val) {
				// ����ֵ�뵱ǰ�����ͬ��ȫ�����,�ҵ���һ���뵱ǰ��㲻ͬ�Ľ��
				pNode = pNode.next;
			}
			return deleteDuplication(pNode); // �ӵ�һ���뵱ǰ��㲻ͬ�Ľ�㿪ʼ�ݹ�
		} else { // ��ǰ��㲻���ظ����
			pHead.next = deleteDuplication(pHead.next); // ������ǰ��㣬����һ����㿪ʼ�ݹ�
			return pHead;
		}
		
//		if (pHead.val == pHead.next.val) {
//			ListNode p1 = pHead.next;
//			while (p1!=null && p1.val == pHead.val) {
//				p1 = p1.next;
//			}
//			return deleteDuplication(p1);
//		}else {
//			pHead.next = deleteDuplication(pHead.next);
//			return pHead;
//		}
//		
	}

}