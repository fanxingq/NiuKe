package com.nk.test4;

import java.util.ArrayList;
import java.util.Stack;

import com.nk.test1.TreeNode;

/**
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�� �����а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * 
 * @author zheng
 * 
 * ���ѣ�����
 * 
 */
public class TreePrintZhi {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

		int layer = 1;
        //s1��������ڵ�
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s1.push(pRoot);
		//s2��ż����ڵ�
        Stack<TreeNode> s2 = new Stack<TreeNode>();
         
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
         
        while (!s1.empty() || !s2.empty()) {
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;	        
    }
}