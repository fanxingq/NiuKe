package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 * 
 * @author zheng
 *	
 * �����������������������˳���ӡ�������þ�������õ�˳��
 */
public class TreeKthNode {

	int index = 0;  //������
	
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
        if (index == k) {     //������������м��ӡ
			return pRoot;
		}
        node = KthNode(pRoot.right, k);
        if (node!=null) {
			return node;
		}
		
		return null;
    }

}
