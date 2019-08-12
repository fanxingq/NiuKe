package com.leetcode.test1;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * @author zheng
 * 
 * T4
 * 解析链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */
public class FindMedianSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(findMedianSortedArrays2(nums1, nums2));
	}
	
	/**
	 * 方法1 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 * 构建一个m+n的数组，将两个有序数组排序放进去
	 * 时间复杂度为O(m+n)
	 * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
	 */
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        
		double res = 0.0;
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[] nums = new int[n1+n2];
		if (n1 == 0) {
			if (n2%2 == 0) {
				return (nums2[n2/2-1] + nums2[n2/2])/2.0;
			}else {
				return nums2[n2/2];
			}
		}
		if (n2 == 0) {
			if (n1%2 == 0) {
				return (nums1[n1/2-1] + nums1[n1/2])/2.0;
			}else {
				return nums1[n1/2];
			}
		}
		//将数放进新的数组
		int count = 0;   //总长度
		int num1index = 0;
		int num2index = 0;
		while (count!=n1+n2) {
			
			if (n1 == num1index) {
				while (n2!=num2index) {
					nums[count++] = nums2[num2index++];
				}
				break;
			}
			if (n2 == num2index) {
				while (n1!=num1index) {
					nums[count++] = nums1[num1index++];
				}
				break;
			}
			if (nums1[num1index] < nums2[num2index]) {
				nums[count++] = nums1[num1index++];
			}else {
				nums[count++] = nums2[num2index++];
			}
		}
		//对nums数组进行判断中位数
		if (count%2 != 0) {
			res = nums[count/2];
		}else {
			res = (nums[count/2] + nums[count/2-1])/2.0;
		}
		
		return res;
    }
	
	/**
	 * 方法2
	 * 我们一次遍历就相当于去掉不可能是中位数的一个值，也就是一个一个排除。
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 * 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)。
	 * 空间复杂度：O(1)
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
	
		int n = nums1.length;
		int m = nums2.length;
		int len = n+m;
		int right = -1,left = -1;       //right比left多循环一层，如果是偶数，则需要记录上一个值，如果是奇数，就直接取中位数
		int nstart = 0,mstart = 0;
		for (int i = 0; i <= len/2; i++) {          //不管是奇还是偶，都要搜索len/2+1
			
			left = right;
			if (nstart<n && (mstart>=m || nums1[nstart]<nums2[mstart])) {
				right = nums1[nstart++];
			}else {
				right = nums2[mstart++];
			}
			
		}
		if ((left&1) == 0) {    //偶
			return (left + right)/2.0;
		}
		
		return right;  //奇
	}
	
	/**
	 * 方法3
	 * 第k小的数，中位数
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n)
	 * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)
	 */
	public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		
		int n = nums1.length;
		int m = nums2.length;
		int left = (m+n+1)/2;   //left和right在/2的时候由于向下取整，又因为需要兼顾奇数，所以这么设置，没有使用left=(m+n)/2;right=(m+n)/2+1;
		int right = (m+n+2)/2;  //（接上）如果使用了这个，则奇数的时候会求得两个不同的数。奇数是要/2再+1的。
		//将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k
		//k是求的中位数即第k小的数，使用二分法查找
		return (getK(nums1, 0, n-1, nums2, 0, m-1, left) + getK(nums1, 0, n-1, nums2, 0, m-1, right))/2.0;
	}
	
	public static int getK(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
		
		int len1 = end1-start1 +1;   //因为从0开始计算
		int len2 = end2-start2 +1;
		 //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (len1>len2) {
			//为了让len1<len2,所以使用递归函数将其颠倒，所以。。
			return getK(nums2, start2, end2, nums1, start1, end1, k);
		}
		if (len1 == 0) {
			return nums2[start2+k-1];       //距离中位数还差k个，所以用start+k找到中位数
		}
		if (k==1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		int i = start1 + Math.min(len1, k/2)-1;    //以防超过某一数组的边界
		int j = start2 + Math.min(len2, k/2)-1;
		if (nums1[i]>nums2[j]) {
			return getK(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1));
		}else {
			return getK(nums1, i+1, end1, nums2, start2, end2, k-(i-start1+1));
		}
	}
	
}
