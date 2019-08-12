package com.leetcode.test1;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author zheng
 * 
 * T3
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {

		String s = "abbad";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}

	public static int lengthOfLongestSubstring(String s) {
        
		/**
		 * 标签：滑动窗口暴力解法时间复杂度较高，会达到 O(n^2)，
		 * 故而采取滑动窗口的方法降低时间复杂度定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，
		 * 加 1 表示从字符位置后一个才开始不重复我们定义不重复子串的开始位置为 start，结束位置为 end随着 end不断遍历向后，
		 * 会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，
		 * 此时 [start, end] 区间内不存在重复字符无论是否更新 start，都会更新其 map 数据结构和结果 ans。
		 * 时间复杂度：O(n)
		 */
		
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();
		int start = 0;
		for (int end = 0; end < c.length; end++) {
			
			if (map.containsKey(c[end])) {
				start = Math.max(start, map.get(c[end]));       //将start更新为map里的value即上一个数的位置，map存的是目前最新的key对应的value值
			}
			result = Math.max(result, end-start+1);      //result存放最新的结果，每次都要比较更新
			map.put(c[end], end+1);
			
		}
		
		return result;
    }
}
