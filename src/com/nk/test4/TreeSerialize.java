package com.nk.test4;

import com.nk.test1.TreeNode;

/**
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * @author zheng
 *
 * ��ν���л�ָ���Ǳ���������Ϊ�ַ�������ν�����л�ָ���������ַ������¹���ɶ�������
 * ���ڱ���������ʱ����Nullָ��ʱ����ЩNullָ�뱻���л�Ϊһ��������ַ���#����
 * ���⣬���֮�����ֵ�ö��Ÿ�����
 */
public class TreeSerialize {

	int index = -1;   //��������
	
	public static void main(String[] args) {

		
		
		
	}
	
	//���л�
	String Serialize(TreeNode root) {
        
		StringBuffer sb = new StringBuffer();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));   //�ҵ�����ߵĽڵ�ӽ�ȥ
		sb.append(Serialize(root.right));
		return sb.toString();
	  }
	    
	//�����л�
	TreeNode Deserialize(String str) {
	       
		index ++;  //ÿ�ζ������һλ
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
