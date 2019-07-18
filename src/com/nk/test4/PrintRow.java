package com.nk.test4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author zheng
 * 
 * 层次遍历,使用队列
 * 层次遍历，有个标志depth进行比较
 * 忘了已经
 */
public class PrintRow {

	public static void main(String[] args) {

		
	}

	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return lists;
		}
//		depth(pRoot, 1, lists);
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		queue.add(pRoot);   //根节点入队
//		int start = 0,end = 1;
//		while (!queue.isEmpty()) {
//			TreeNode node = queue.remove();
//			list.add(node.val);
//			start ++;
//			if (node.left!=null) {
//				queue.add(node.left);
//			}
//			if (node.right != null) {
//				queue.add(node.right);
//			}
//			if (start == end) {
//				end = queue.size();  //start每次++表示有一个节点出队，当本层所有节点都出完了，则start=end
//				start = 0;
//				lists.add(list);
//				list = new ArrayList<Integer>();
//			}
//		}
		
		
		return lists;
    }
	
	//使用递归实现
	public void depth(TreeNode root,int depth,ArrayList<ArrayList<Integer>> lists){
		
		if (root == null) {
			return;
		}
		if (depth>lists.size()) {
			lists.add(new ArrayList<Integer>());
		}
		lists.get(depth-1).add(root.val);
		
		depth(root.left,depth+1,lists);
		
		depth(root.right,depth+1,lists);
		
		
	}
}
