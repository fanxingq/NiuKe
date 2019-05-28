package com.nk.test2;

import com.nk.test1.TreeNode;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * ��������:
       �������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author zheng
 *
 * �ֱ𽻻���������
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
