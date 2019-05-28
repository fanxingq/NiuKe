package com.nk.test1;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * 
 * @author zheng
 * 
 * 1���������ñ�־λresult = false����Ϊһ��ƥ��ɹ�result����Ϊtrue��
 * ʣ�µĴ��벻��ִ�У����ƥ�䲻�ɹ���Ĭ�Ϸ���false
 * 2���ݹ�˼�룬������ڵ���ͬ��ݹ����DoesTree1HaveTree2������
 * ������ڵ㲻��ͬ�����ж�tree1����������tree2�Ƿ���ͬ��
 * ���ж���������tree2�Ƿ���ͬ
 * 3��ע��null��������HasSubTree�У��������������Ϊ�ղŽ����жϣ�
 * DoesTree1HasTree2�У����Tree2Ϊ�գ���˵���ڶ������������ˣ���ƥ��ɹ���
 * tree1Ϊ�������������1�����tree1Ϊ��&&tree2��Ϊ��˵����ƥ�䣬
 *��2�����tree1Ϊ�գ�tree2Ϊ�գ�˵��ƥ�䡣
 *
 */
public class HasSubtreeTest {


	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(4);
		treeNode.left = treeNode2;
		treeNode.right = treeNode3;
		boolean hasSubtree = HasSubtree(treeNode, treeNode);
		System.out.println(hasSubtree);

	}

	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {

		boolean result = false;                     //���root1��root2��һ��Ϊnull�ͷ���false
		if (root1!=null && root2!=null) {
			
			if (root1.val == root2.val) {           //�ȴӸ��ڵ���жԱ�
				result = preTree(root1, root2);    
			}
			if (!result) {                          //���ڵ㲻��ͬ��Ա����ӽڵ�
				result = preTree(root1.left, root2);
			}
			if (!result) {                          //������ϻ����У��ͶԱ��Һ��ӽڵ�
				result = preTree(root1.right, root2);
			}
			
		}
		
		return result;
	}

	public static boolean preTree(TreeNode tree1,TreeNode tree2) {

		if (tree2 == null) {                  //���tree2ζnull����ʾ�ѶԱ���ɣ�������
			return true;
		}
		if (tree1 == null) {                 //����Ա�δ��ʱ��tree1Ϊnull�ˣ��ͷ���false
			return false;
		}
		if (tree1.val != tree2.val) {        //����һ���ڵ㲻ͬ�ͷ���false
			return false;
		}
		
		return preTree(tree1.left, tree2.left) && preTree(tree1.right, tree2.right);
	}

}
