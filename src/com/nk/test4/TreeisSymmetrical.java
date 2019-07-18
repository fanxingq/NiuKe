package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * ��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * @author zheng
 * 
 * �Գƣ��������������������������������ӽڵ��Ӧ���������Һ��ӽڵ㣬���������Һ��ӽڵ��Ӧ�����������ӽڵ�
 * �ҶԳƵ��ֵӦ�����
 */
public class TreeisSymmetrical {

	public static void main(String[] args) {

		
	}

	boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {   //��
			return true;     
		}
		
		return find(pRoot.left, pRoot.right);
    }
	
	boolean find(TreeNode lNode,TreeNode rNode){
		
		if (lNode == null && rNode == null) {
			return true;
		}
		if (lNode!=null && rNode!=null) {
			return lNode.val == rNode.val && find(lNode.left, rNode.right) 
					&& find(lNode.right, rNode.left); 
		}
		return false;
		
	}
	
	
}
