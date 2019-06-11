package com.nk.test3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * �ǲ��Ǻܼ򵥣�OK���㶨����
 * 
 * @author zheng
 * 
 * ���η�ת�ַ���/...
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
		//���ö��У���Ȼ�鷳��
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
