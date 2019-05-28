package com.nk.test1;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author zheng
 *
 * 解决方案：从二维数组左下角开始对比，之后向右横向对比，处于中间结果时，再向上对比。
 */
public class ArrayTest {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		int[][] ar = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		boolean find = Find(16, ar);
		System.out.println(find);
	}

	public static boolean Find(int target, int[][] array) {

		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 0; j < array[i].length; j++) {
				if (target == array[i][j]) {
					return true;
				} else if (j == array[i].length - 1) {
					if (target > array[i][j]) {
						return false;
					}
				} else if ((target > array[i][j]) && (target < array[i][j + 1])) {
					for (int m = i; m >= 0; m--) {
						if (target == array[m][j + 1]) {
							return true;
						}

					}
				}

			}

		}

		return false;
	}
}
