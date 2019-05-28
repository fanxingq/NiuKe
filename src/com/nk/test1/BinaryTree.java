package com.nk.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö������� ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
		
		
		int[] pre = {1,2,4,7,3,5,6,8};     //ǰ�����
		int[] in = {4,7,2,1,5,3,8,6};      //�������
		
		TreeNode tree = reConstructBinaryTree(pre,in);
		System.out.println(tree.toString());
        //TreeNode [val=1, left=TreeNode [val=2, left=TreeNode [val=4, left=null, right=TreeNode [val=7, left=null, right=null]], right=null], right=TreeNode [val=3, left=TreeNode [val=5, left=null, right=null], right=TreeNode [val=6, left=TreeNode [val=8, left=null, right=null], right=null]]]

		//�������
		preTraverseBinTree(tree);
		System.out.println("�������Ϊ��"+preResult.toString());
		//�������
		inTraverseBinTree(tree);
		System.out.println("�������Ϊ��"+inResult.toString());
		//�������
		postTraverseBinTree(tree);
		System.out.println("�������Ϊ��"+postResult.toString());
		//��α���
		levelTraverseBinTree(tree);
		System.out.println("��α���Ϊ��"+levelResult.toString());
		
		
	}

	//�������
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

	//��α���   ��������
	private static void levelTraverseBinTree(TreeNode tree) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			int count = queue.size();
//			List<Integer> list=new ArrayList();
			while (count>0) {
				TreeNode temp = queue.peek();    //���ض��е�ͷ��Ԫ��
//				System.out.println(temp.toString());
				queue.poll();    //�Ƴ������ض��е�ͷ��Ԫ��
				levelResult.add(temp.val + "");
				if (temp.left!=null) {
					queue.add(temp.left);    //�����ӽڵ�ѹ��ȥ
				}
				if (temp.right!=null) {      //���Һ��ӽڵ�ѹ��ȥ
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

	//�������
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

	//�������
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
		
		int root = 0;   //ÿ�ζ��ҳ����ڵ�����λ��
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
