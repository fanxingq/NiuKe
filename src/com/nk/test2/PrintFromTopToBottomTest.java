package com.nk.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * @author zheng
 *
 * 二叉树的层次遍历，借助队列实现。
 */
public class PrintFromTopToBottomTest {

	public static void main(String[] args) {

		
		TreeNode treeNode = null;
		ArrayList<Integer> list = PrintFromTopToBottom(treeNode);
		System.out.println(list.toString());
		
		
		
		
	}
	
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {              //不写这个容易出现空指针异常
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size>0) {
				TreeNode head = queue.peek();   //将队列的头部元素存起来
				queue.poll();
				list.add(head.val);             //将队列的头结点移除并加进list
				if (head.left!=null) {
					queue.add(head.left);
				}
				if (head.right!=null) {
					queue.add(head.right);
				}
				size --;
			}
			
		}
		
		return list;
    }
	

}
