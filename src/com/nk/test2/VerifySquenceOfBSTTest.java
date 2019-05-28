package com.nk.test2;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。 假设输入的数组的任意两个数字都互不相同。
 * 
 * @author zheng
 * 
 * 二叉搜索树左子树<根<右子树
 * 比如1 4 3 5这个二叉搜索树的后序遍历，没有右子树，所以r一直对应的是4这个索引，
 * 当return judge(a, l, i - 1) && (judge(a, i, r - 1))中的第二个递归，i=r,r-1<r,所以应该是返回true.
 * l==r对应的是叶子结点，l>r对应的是空树，这两种情况都是true。
 * l对应start，r对应end
 */
public class VerifySquenceOfBSTTest {

	public static void main(String[] args) {

//		 int[] arr = {1,2,3,5,6,7,4};
//		int[] arr = { 1, 3, 5, 6, 2, 4 };
//		int[] arr = {5,4,3,2,1};
		int[] arr = {7,4,6,5};
		boolean result = VerifySquenceOfBST(arr);
		System.out.println(result);
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {

//		if (sequence.length == 0) {
//			return false;
//		}
//		if (sequence.length == 1) {
//			return true;
//		}
//		boolean result = postTree(sequence, 0, sequence.length - 1);
////
//		return result;

		// 非递归
		// 非递归也是一个基于递归的思想：
		// 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
		// 最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
		// 即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理

		// 对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
		// 只需看看右子树的右子树是否符合要求即可
		int size = sequence.length;
		if (size == 0) {
			return false;
		}
		int i = 0;
		while (--size!=0) {
			
			while (sequence[i]<sequence[size]){     //先将左子树过滤出去
				i++;
			}
			while (sequence[i]>sequence[size]){    //将右子树从最右根处开始比较，比较到第一个出现小于等于根的值
				i++;
			}
			if (i<size) {      //比较此时的i和根的关系，判断是否是符合后序遍历的
				return false;
			}
			i = 0;    //左移一位，继续比较。右子树一定比左子树大，所以可以先不考虑左子树。只比较右子树和根。
			
		}
		return true;
	}

/*	public static boolean postTree(int[] arr, int pre, int post) {

		if (pre>=post) {
			return true;
		}
		int i = pre;
		while (arr[i] < arr[post]) {
			++i;

		}
		for (int j = i; j < post; j++) {
			if (arr[j]<arr[post]) {
				return false;
			}
		}
		
		return postTree(arr, pre, i-1) && postTree(arr, i, post-1);
		
	}*/

		
	
	
	
	
}
