package com.nk.test2;

import java.util.ArrayList;

import com.nk.test1.TreeNode;

/**
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * 
 * @author zheng
 *
 * ˼����������ȱ���������Ľⷨ�ǳ����Ĥ�ݣ� 
 */
public class FindPathTreeSumTest {

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {

		
		
	}
	
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		if (root == null) {
			return allList;
		}
		list.add(root.val);
		target -= root.val;   //�ǳ�����!
		if (target == 0 && root.left == null && root.right == null) {
			allList.add(new ArrayList<Integer>(list));     //������new�Ļ���ʼ����listAll���������ö�ָ����ͬһ��һ��list(ѧ����)
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size()-1);   //�Ƴ����һ��Ԫ�أ���ȱ�����һ��·����Ҫ���ˡ�ʹ�õ�Ӧ���ǻ��˵���һ���Ĳ�������һ���ݹ�����ִ�С�
		
		return allList;
        
    }
	

}
