package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author zheng
 * 
 * 对称，根的左子树和右子树，左子树的左孩子节点对应右子树的右孩子节点，左子树的右孩子节点对应右子树的左孩子节点
 * 且对称点的值应该相等
 */
public class TreeisSymmetrical {

	public static void main(String[] args) {

		
	}

	boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {   //根
			return true;     
		}
		
		return find(pRoot.left, pRoot.right);
    }
	
	boolean find(TreeNode lNode,TreeNode rNode){
		
		if (lNode == null && rNode == null) {
			return true;
		}
		if (lNode!=null && rNode!=null) {
			return lNode.val == rNode.val && find(lNode.left, rNode.right) 
					&& find(lNode.right, rNode.left); 
		}
		return false;
		
	}
	
	
}
