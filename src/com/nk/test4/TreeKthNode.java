package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 
 * @author zheng
 *	
 * 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
 */
public class TreeKthNode {

	int index = 0;  //计数器
	
	public static void main(String[] args) {

		
	}
	
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) {
			return null;
		}
        TreeNode node = KthNode(pRoot.left, k);
        if (node!=null) {
			return node;
		}
        index ++;
        if (index == k) {     //中序遍历，在中间打印
			return pRoot;
		}
        node = KthNode(pRoot.right, k);
        if (node!=null) {
			return node;
		}
		
		return null;
    }

}
