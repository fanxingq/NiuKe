package com.nk.test4;

/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 * @author zheng
 *
 */
public class TreeGetNext {

	public static void main(String[] args) {

	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {

		if (pNode == null) {
			return null;
		}
		//���������������������������Ľڵ�
		if (pNode.right!=null) {
			pNode = pNode.right;
			while (pNode.left!=null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		//���û�����������ҵ�һ����ǰ���ڵ�����ӽڵ�
		while (pNode.next!=null) {      //nextָ�򸸽ڵ�
			if (pNode.next.left==pNode) {
				return pNode.next;
			}
			pNode = pNode.next;
		}
		
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}