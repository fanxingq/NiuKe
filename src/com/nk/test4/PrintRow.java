package com.nk.test4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 * 
 * @author zheng
 * 
 * ��α���,ʹ�ö���
 * ��α������и���־depth���бȽ�
 * �����Ѿ�
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
//		queue.add(pRoot);   //���ڵ����
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
//				end = queue.size();  //startÿ��++��ʾ��һ���ڵ���ӣ����������нڵ㶼�����ˣ���start=end
//				start = 0;
//				lists.add(list);
//				list = new ArrayList<Integer>();
//			}
//		}
		
		
		return lists;
    }
	
	//ʹ�õݹ�ʵ��
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
