package com.nk.test2;

import com.nk.test1.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author zheng
 *
 */
public class ConvertTreeTwoLIstNodeTest {

	TreeNode pre = null;
    TreeNode head = null;
	public static void main(String[] args) {

		
	}
	
	
	public TreeNode Convert(TreeNode pRootOfTree) {
	       if (pRootOfTree == null) {
				return null;
			}
			
			InTraversalListNode(pRootOfTree);
			
			return head;
	    }
	    public void InTraversalListNode(TreeNode root){
			
			if (root == null) {                   //直接将树的左右子树的指针当成双向链表的两个指针
				return;
			}
			if (root.left!=null) {
				InTraversalListNode(root.left);
			}

			if (pre == null) {
				pre = root;
				head = root;
			}else {
				pre.right = root;
				root.left = pre;
				pre = root;
			}
			if (root.right!=null) {
				InTraversalListNode(root.right);
			}
			
		}

}
