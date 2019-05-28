package com.nk.test2;

import java.util.ArrayList;

import com.nk.test1.TreeNode;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * @author zheng
 *
 * 思想类似于深度遍历，大神的解法非常巧妙，膜拜！ 
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
		target -= root.val;   //非常巧妙!
		if (target == 0 && root.left == null && root.right == null) {
			allList.add(new ArrayList<Integer>(list));     //不重新new的话从始至终listAll中所有引用都指向了同一个一个list(学到了)
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size()-1);   //移除最后一个元素，深度遍历完一条路径后要回退。使用的应该是回退到上一步的操作，上一步递归后继续执行。
		
		return allList;
        
    }
	

}
