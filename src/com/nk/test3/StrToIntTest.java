package com.nk.test3;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * @author zheng
 * 
 * 
 */
public class StrToIntTest {

	public static void main(String[] args) {

		String string = "+2147483647";
		System.out.println(Integer.valueOf(string));
		StrToInt("123");
		
	}

    public static int StrToInt(String str) {
    
    	int res = 0;
    	int flag = 1;
    	if (str.trim().equals("") || str == null) {
			return 0;
		}
    	if (str.charAt(0) == '+') {  //判断是否含有+-号
			flag = 1;
		}
    	if (str.charAt(0) == '-') {
			flag = -1;
		}
    	for (int i = ((str.charAt(0) == '-')||(str.charAt(0) == '+')?1:0); i < str.length(); i++) {   //如果最前面有个符号是+-就向前进一位
    		
    		if (str.charAt(i)<48||str.charAt(i)>57) {
				return 0;
			}
			res = res*10 + str.charAt(i)-48;
			System.out.println(res);
		}
    	
    	return res*flag;
    }
	
}
