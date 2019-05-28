package com.nk.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * 
 * @author zheng
 *
 * �������Ĳ�α�������������ʵ�֡�
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
		if (root == null) {              //��д������׳��ֿ�ָ���쳣
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size>0) {
				TreeNode head = queue.peek();   //�����е�ͷ��Ԫ�ش�����
				queue.poll();
				list.add(head.val);             //�����е�ͷ����Ƴ����ӽ�list
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
