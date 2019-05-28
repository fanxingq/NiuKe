package com.nk.test1;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * @author zheng
 * 
 * 1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
 * 剩下的代码不会执行，如果匹配不成功，默认返回false
 * 2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
 * 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 * 再判断右子树和tree2是否相同
 * 3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 * DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
 * tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
 *（2）如果tree1为空，tree2为空，说明匹配。
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

		boolean result = false;                     //如果root1和root2有一方为null就返回false
		if (root1!=null && root2!=null) {
			
			if (root1.val == root2.val) {           //先从根节点进行对比
				result = preTree(root1, root2);    
			}
			if (!result) {                          //根节点不相同则对比左孩子节点
				result = preTree(root1.left, root2);
			}
			if (!result) {                          //如果以上还不行，就对比右孩子节点
				result = preTree(root1.right, root2);
			}
			
		}
		
		return result;
	}

	public static boolean preTree(TreeNode tree1,TreeNode tree2) {

		if (tree2 == null) {                  //如果tree2味null，表示已对比完成，是子树
			return true;
		}
		if (tree1 == null) {                 //如果对比未完时，tree1为null了，就返回false
			return false;
		}
		if (tree1.val != tree2.val) {        //其中一个节点不同就返回false
			return false;
		}
		
		return preTree(tree1.left, tree2.left) && preTree(tree1.right, tree2.right);
	}

}
