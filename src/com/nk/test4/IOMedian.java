package com.nk.test4;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * @author zheng
 * 
 * 使用最大最小堆做
 */
public class IOMedian {

	// 降序就是最大堆，lambda表达式了解下
	private static PriorityQueue<Integer> leftHeap = new PriorityQueue<>((x, y) -> y - x);
	// 升序就是最小堆
	private static PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
	// 当前是奇数还是偶数
	private static boolean isOdd = true;

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 4, 1, 6, 7, 0, 8 };
		for (int i = 0; i < arr.length; i++) {
			Insert(arr[i]);
			Double res = GetMedian();
			System.out.println(res);
		}
	}

	public static void Insert(Integer num) {

		if (isOdd) {// 数据是奇数的时候 insert的数据进入 [左边，最大堆]中
			if (leftHeap.isEmpty()) {
				leftHeap.add(num);
			} else {// 这个时候rightHeap一定不是null，就不讨论了。考虑鲁棒性可以讨论
				int rightMin = rightHeap.peek();
				if (num <= rightMin) {// 直接插入到[左边，最小堆]中
					leftHeap.add(num);
				} else {
					rightHeap.add(num);// 先把cur插入[右边最小rightMin|最小堆]中
					leftHeap.add(rightHeap.poll());// 然后把rightMin放入[最大堆|左边最大leftMax]中
				}
			}
		} else {// 数据是偶数的时候 insert的数据进入 [右边，最小堆]中
				// 这个时候leftHeap一定不是null，就不讨论了。考虑鲁棒性可以讨论
			int leftMax = leftHeap.peek();
			if (num >= leftMax) {// 直接插入到[右边，最小堆]中
				rightHeap.add(num);
			} else {
				leftHeap.add(num);// 先把cur插入[右边最小rightMin|最小堆]中，
				rightHeap.add(leftHeap.poll());// 然后把rightMin放入[最大堆|左边最大leftMax]中
			}
		}
		isOdd = !isOdd;// 改变奇偶性
	}

	public static Double GetMedian() {

		if (leftHeap.isEmpty())
			return 0.0;
		if (!isOdd)// 这里插入num改变了奇偶性，这里是奇数的意思
			return leftHeap.peek() / 1.0;
		else
			return (leftHeap.peek() + rightHeap.peek()) / 2.0;
	}

}
