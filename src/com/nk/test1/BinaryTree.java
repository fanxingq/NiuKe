package com.nk.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author zheng
 *
 */
public class BinaryTree {

	private static List<String> preResult = new ArrayList<String>();
	private static List<String> inResult = new ArrayList<String>();
	private static List<String> postResult = new ArrayList<String>();
	private static List<String> levelResult = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		
		int[] pre = {1,2,4,7,3,5,6,8};     //前序遍历
		int[] in = {4,7,2,1,5,3,8,6};      //中序遍历
		
		TreeNode tree = reConstructBinaryTree(pre,in);
		System.out.println(tree.toString());
        //TreeNode [val=1, left=TreeNode [val=2, left=TreeNode [val=4, left=null, right=TreeNode [val=7, left=null, right=null]], right=null], right=TreeNode [val=3, left=TreeNode [val=5, left=null, right=null], right=TreeNode [val=6, left=TreeNode [val=8, left=null, right=null], right=null]]]

		//先序遍历
		preTraverseBinTree(tree);
		System.out.println("先序遍历为："+preResult.toString());
		//中序遍历
		inTraverseBinTree(tree);
		System.out.println("中序遍历为："+inResult.toString());
		//后序遍历
		postTraverseBinTree(tree);
		System.out.println("后序遍历为："+postResult.toString());
		//层次遍历
		levelTraverseBinTree(tree);
		System.out.println("层次遍历为："+levelResult.toString());
		
		
	}

	//后序遍历
	private static void postTraverseBinTree(TreeNode tree) {

		if (tree == null) {
			return;
		}
		if (tree.left!=null) {
			postTraverseBinTree(tree.left);
		}
		if (tree.right!=null) {
			postTraverseBinTree(tree.right);
		}
		postResult.add(tree.val + "");
		
		
	}

	//层次遍历   借助队列
	private static void levelTraverseBinTree(TreeNode tree) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			int count = queue.size();
//			List<Integer> list=new ArrayList();
			while (count>0) {
				TreeNode temp = queue.peek();    //返回队列的头部元素
//				System.out.println(temp.toString());
				queue.poll();    //移除并返回队列的头部元素
				levelResult.add(temp.val + "");
				if (temp.left!=null) {
					queue.add(temp.left);    //将左孩子节点压进去
				}
				if (temp.right!=null) {      //将右孩子节点压进去
					queue.add(temp.right);
				}
				
				count --;
			}
//			for (Integer integer : list) {
////				System.out.println("**"+integer);
//				levelResult.add(integer + "");
//			}
		}
		
	}

	//中序遍历
	private static void inTraverseBinTree(TreeNode tree) {

		if (tree == null) {
			return;
		}
		if (tree.left!=null) {
			inTraverseBinTree(tree.left);
		}
		inResult.add(tree.val + "");
		if (tree.right!=null) {
			inTraverseBinTree(tree.right);
		}
		
		
	}

	//先序遍历
	private static void preTraverseBinTree(TreeNode tree) {

		if (tree == null) {
			return ;
		}
		preResult.add(tree.val+"");
		if (tree.left!=null) {
			preTraverseBinTree(tree.left);
		}
		if (tree.right!=null) {
			preTraverseBinTree(tree.right);
		}
		
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		
		TreeNode tree = binaryTreeRecursive(pre,0,pre.length-1,in,0,in.length-1);
		
		
		return tree;

	}

	public static TreeNode binaryTreeRecursive(int[] pre, int preStart, int preEnd,
			int[] in, int inStart, int inEnd) {
				
		TreeNode treeNode = new TreeNode(pre[preStart]);
		treeNode.left = null;
		treeNode.right = null;
		
		if (preStart == preEnd && inStart == inEnd) {
			
			return treeNode;
			
		}
		
		int root = 0;   //每次都找出根节点所在位置
		for (root = inStart; root < in.length; root++) {
			
			if (pre[preStart] == in[root]) {
				break;
			}
		}
		
		int leftLength = root - inStart;
		int rightLength = inEnd - root;
		if (leftLength>0) {
			treeNode.left = binaryTreeRecursive(pre, preStart + 1, preStart + leftLength, in, inStart, root - 1);
		}
		if (rightLength>0) {
			treeNode.right = binaryTreeRecursive(pre, preStart + leftLength + 1, preEnd, in, root + 1, inEnd);
		}
		
		return treeNode;
	}
	
	

}
