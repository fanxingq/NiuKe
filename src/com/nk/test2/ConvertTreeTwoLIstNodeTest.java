package com.nk.test2;

import com.nk.test1.TreeNode;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * @author zheng
 *
 */
public class ConvertTreeTwoLIstNodeTest {

	TreeNode pre = null;
    TreeNode head = null;
	public static void main(String[] args) {

		
	}
	
	
	public TreeNode Convert(TreeNode pRootOfTree) {
	       if (pRootOfTree == null) {
				return null;
			}
			
			InTraversalListNode(pRootOfTree);
			
			return head;
	    }
	    public void InTraversalListNode(TreeNode root){
			
			if (root == null) {                   //ֱ�ӽ���������������ָ�뵱��˫�����������ָ��
				return;
			}
			if (root.left!=null) {
				InTraversalListNode(root.left);
			}

			if (pre == null) {
				pre = root;
				head = root;
			}else {
				pre.right = root;
				root.left = pre;
				pre = root;
			}
			if (root.right!=null) {
				InTraversalListNode(root.right);
			}
			
		}

}
