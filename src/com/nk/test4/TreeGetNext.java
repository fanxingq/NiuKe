package com.nk.test4;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
		//如果有右子树，则找右子树最左的节点
		if (pNode.right!=null) {
			pNode = pNode.right;
			while (pNode.left!=null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		//如果没右子树，则找第一个当前父节点的左孩子节点
		while (pNode.next!=null) {      //next指向父节点
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