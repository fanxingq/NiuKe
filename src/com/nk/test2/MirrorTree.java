package com.nk.test2;

import com.nk.test1.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
       二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author zheng
 *
 * 分别交换左右子树
 */
public class MirrorTree {

	public static void main(String[] args) {

		
		
		
		
	}
	
	public static void Mirror(TreeNode root) {
     
		TreeNode treeNode = null;
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		treeNode = root.left;
		root.left = root.right;
		root.right = treeNode;
		if (root.left!=null) {
			Mirror(root.left);
		}
		if (root.right!=null) {
			Mirror(root.right);
		}
		
    }

}
