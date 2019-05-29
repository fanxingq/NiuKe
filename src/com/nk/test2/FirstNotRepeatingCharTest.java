package com.nk.test2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * @author zheng
 * 
 * 用LinkedHashMap有序的存储键值对，遍历数组找出map对应值为1的index
 * 
 */
public class FirstNotRepeatingCharTest {

	public static void main(String[] args) {

		int i = FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
		System.out.println(i);
		
	}
	
	public static int FirstNotRepeatingChar(String str) {
		
		HashMap<Character, Integer> mapnum = new LinkedHashMap<Character, Integer>();   //输出为有序键值对
		HashMap<Character, Integer> mapadd = new HashMap<Character, Integer>();
		char c = 0 ;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!mapnum.containsKey(cs[i])) {
				mapnum.put(cs[i], 1);
			}else {
				mapnum.put(cs[i], mapnum.get(cs[i])+1);
			}
			if (!mapadd.containsKey(cs[i])) {
				mapadd.put(cs[i], i);
			}
			
		}
		for(Map.Entry<Character, Integer> entry : mapnum.entrySet()){   //map的遍历
			if (entry.getValue() == 1) {
				c = entry.getKey();
				return mapadd.get(c);
			}
		}
        return -1;
    }
	
	//简便点的方法
	public int FirstNotRepeatingChar2(String str) {
        HashMap<Character, Integer> mapnum = new LinkedHashMap<Character, Integer>();
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!mapnum.containsKey(cs[i])) {
				mapnum.put(cs[i], 1);
			}else {
				mapnum.put(cs[i], mapnum.get(cs[i])+1);
			}
			
		}
		for (int i = 0; i < cs.length; i++) {   //遍历数组
			if (mapnum.get(cs[i]) == 1) {
				return i;
			}
		}
        return -1;
    }
}
