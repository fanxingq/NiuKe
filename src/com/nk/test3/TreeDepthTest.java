package com.nk.test3;

import java.util.LinkedList;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * @author zheng
 * 
 * 1. 递归；2. 不递归，用队列
 */
public class TreeDepthTest {

	public static void main(String[] args) {

		
		
	}

	 public int TreeDepth(TreeNode root) {
	 
		/* //1. 用递归，左子树和右子树大的一个+1
		 * 递归好像快一点
		 if (root == null) {
			return 0;
		}
		 int left = TreeDepth(root.left);
		 int right = TreeDepth(root.right);
		 
		 return Math.max(left, right) + 1;*/
		 
		 //非递归,使用层次遍历
		 if (root == null) {
			return 0;
		}
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);   //将根节点先加入队列
		 int count =0, nextcount = 1,depth = 0;
		 while (queue.size()!=0) {
			
			 TreeNode top = queue.poll();   //获取队列的队头，即即将要出队的节点
			 count ++;   //每出一次队就加一次
			 if (top.left!=null) {   //左子树不为空，就将左子树加进去
				queue.add(top.left);
			}
			 if (top.right!=null) {
				queue.add(top.right);
			}
			 if (count == nextcount) {  //nextcount为出队多少次。当相等时就表示这一层的节点以遍历完
				nextcount = queue.size();
				depth++;
				count = 0;
			}
		}
		 
		 return depth;
	 }
	
	
}
