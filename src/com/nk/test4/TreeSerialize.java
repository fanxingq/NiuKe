package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author zheng
 *
 * 所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 * 当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 * 另外，结点之间的数值用逗号隔开。
 */
public class TreeSerialize {

	int index = -1;   //计数变量
	
	public static void main(String[] args) {

		
		
		
	}
	
	//序列化
	String Serialize(TreeNode root) {
        
		StringBuffer sb = new StringBuffer();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));   //找到最左边的节点加进去
		sb.append(Serialize(root.right));
		return sb.toString();
	  }
	    
	//反序列化
	TreeNode Deserialize(String str) {
	       
		index ++;  //每次都向后走一位
		String[] strs = str.split(",");
		TreeNode node = null;
		if (!strs[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(strs[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		
		return node;
	  }

}
