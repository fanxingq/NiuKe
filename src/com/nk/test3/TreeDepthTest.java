package com.nk.test3;

import java.util.LinkedList;
import java.util.Queue;

import com.nk.test1.TreeNode;

/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * 
 * @author zheng
 * 
 * 1. �ݹ飻2. ���ݹ飬�ö���
 */
public class TreeDepthTest {

	public static void main(String[] args) {

		
		
	}

	 public int TreeDepth(TreeNode root) {
	 
		/* //1. �õݹ飬�����������������һ��+1
		 * �ݹ�����һ��
		 if (root == null) {
			return 0;
		}
		 int left = TreeDepth(root.left);
		 int right = TreeDepth(root.right);
		 
		 return Math.max(left, right) + 1;*/
		 
		 //�ǵݹ�,ʹ�ò�α���
		 if (root == null) {
			return 0;
		}
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);   //�����ڵ��ȼ������
		 int count =0, nextcount = 1,depth = 0;
		 while (queue.size()!=0) {
			
			 TreeNode top = queue.poll();   //��ȡ���еĶ�ͷ��������Ҫ���ӵĽڵ�
			 count ++;   //ÿ��һ�ζӾͼ�һ��
			 if (top.left!=null) {   //��������Ϊ�գ��ͽ��������ӽ�ȥ
				queue.add(top.left);
			}
			 if (top.right!=null) {
				queue.add(top.right);
			}
			 if (count == nextcount) {  //nextcountΪ���Ӷ��ٴΡ������ʱ�ͱ�ʾ��һ��Ľڵ��Ա�����
				nextcount = queue.size();
				depth++;
				count = 0;
			}
		}
		 
		 return depth;
	 }
	
	
}
