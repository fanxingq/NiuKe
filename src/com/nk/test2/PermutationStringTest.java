package com.nk.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 
 * @author zheng
 *
 */
public class PermutationStringTest {

	public static void main(String[] args) {

		
		
	}

	public ArrayList<String> Permutation(String str) {
	       List<String> list = new ArrayList<String>();
			if (str!= null && str.length()>0) {
				//递归的初始值为（str数组，空的list，初始下标0）
				PermutationHelper(str.toCharArray(), 0, list);
				Collections.sort(list);
			}
			
			return (ArrayList<String>) list;
	    }
	    public void PermutationHelper(char[] cstr, int i, List<String> list){
		
			 //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
			if (i == cstr.length-1) {
				String string = String.valueOf(cstr);
				if (!list.contains(string)) {
					list.add(string);
	                return;
				}
			}else {
				for (int j = i; j < cstr.length; j++) {
					swap(cstr, i, j);
					PermutationHelper(cstr, i+1, list);
					swap(cstr, i, j);   //每次交换完要回到原来的状态
				}
			}
			
		}
		
		public void swap(char[] cs, int i, int j){
			
			char temp = cs[i];
			cs[i] = cs[j];
			cs[j] = temp;
			
		}
	
	

	
}
