package com.nk.test3;

import com.nk.test1.TreeNode;

/**
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 * 
 * @author zheng
 * 
 * �������������
 */
public class IsBalanced_SolutionTreeTest {

	boolean isBalance = true;
	public static void main(String[] args) {

		
		
		
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
      
		if (root == null) {
			return true; 
		}
//		int left = depth(root.left);
//		int right = depth(root.right);
//		if (left>right) {
//			if (left-right<=1) {
//				return true;
//			}
//		}else {
//			if (right-left<=1) {
//				return true;
//			}
//		}
		depth(root);
		return isBalance;
		
    }
	

	public int depth(TreeNode tree){
		
		if (!isBalance) {   //�����˼�֦
			return -1;
		}
		if (tree == null) {
			return 0;
		}
		int left = depth(tree.left);
		int right = depth(tree.right);
//		return Math.max(left, right) + 1;   //ֱ�������������
		if (Math.abs(left-right)>1) {   //ÿ���ж�һ�����������ĸ߶Ȳ��Ƿ����1
			isBalance = false;
		}
		
		return right>left?right+1:left+1;
	}
	

		/*public class Solution {
		    public boolean IsBalanced_Solution(TreeNode root) {
		        return getDepth(root) != -1;
		    }
		     
		    private int getDepth(TreeNode root) {
		        if (root == null) return 0;
		        int left = getDepth(root.left);
		        if (left == -1) return -1;
		        int right = getDepth(root.right);
		        if (right == -1) return -1;
		        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
		    }
		}*/
}
