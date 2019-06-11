package com.nk.test3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * 
 * @author zheng
 * 
 * 两次翻转字符串/...
 */
public class LeftRotateStringTest {

	public static void main(String[] args) {

		
		String str = "abcXYZdef"; 
		String string = LeftRotateString(str, 1);
		System.out.println(string);
		
		
	}


	public static String LeftRotateString(String str,int n) {
    
		String res = "";
		if (str.equals("") || str == null) {
			return res;
		}
		int num = 0;
		if (n%(str.length())==0) {
			num = str.length();
		}else {
			num = n%(str.length());
		}
		StringBuffer sb1 = new StringBuffer(str.substring(0,num));
		StringBuffer sb2 = new StringBuffer(str.substring(num, str.length()));
		sb2.append(sb1);
		return sb2.toString();
		
		
		/*
		//借用队列，显然麻烦了
		String res = "";
		if (str.equals("") || str == null) {
			return res;
		}
		char[] cs = str.toCharArray();
		Queue<Character> queue = new LinkedList<Character>();
		int num = 0;
		
		if (n%(cs.length)==0) {
			num = cs.length;
		}else {
			num = n%(cs.length);
		}
		for (int i = 0; i < cs.length; i++) {
			queue.add(cs[i]);
		}
		for (int i = num; i > 0; i--) {
			
			Character c = queue.peek();
			queue.add(c);
			queue.poll();
		}
		for (int i = 0; i < cs.length; i++) {
			res = res + queue.peek();
			queue.poll();
		}
		return res;*/
		
		
    }
	
	
}
