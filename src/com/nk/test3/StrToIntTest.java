package com.nk.test3;

/**
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
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
    	if (str.charAt(0) == '+') {  //�ж��Ƿ���+-��
			flag = 1;
		}
    	if (str.charAt(0) == '-') {
			flag = -1;
		}
    	for (int i = ((str.charAt(0) == '-')||(str.charAt(0) == '+')?1:0); i < str.length(); i++) {   //�����ǰ���и�������+-����ǰ��һλ
    		
    		if (str.charAt(i)<48||str.charAt(i)>57) {
				return 0;
			}
			res = res*10 + str.charAt(i)-48;
			System.out.println(res);
		}
    	
    	return res*flag;
    }
	
}
