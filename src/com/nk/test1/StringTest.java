package com.nk.test1;

/**
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author zheng
 *
 * ����Ҫ��ǰ�������ո���Ŀ��֮��Ӻ���ǰ�滻�ո�
 */
public class StringTest {

	public static void main(String[] args) {
		
//		String str = "We Are Happy";
		StringBuffer str = new StringBuffer("");
		String string = replaceSpace(str);
		System.out.println(string);
		
	}
	
	public static String replaceSpace(StringBuffer str) {
		
		
		String string = str.toString();
		String[] arr = string.split("");
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(" ")) {
				arr[i] = "%20";
			}
			result = result +arr[i];
		}
		
		return result;
    	
    }
	
	/*
	����1���滻�ַ���������ԭ�����ַ��������滻�������¿���һ���ַ������滻��
	����2���ڵ�ǰ�ַ����滻����ô�滻�Ÿ���Ч�ʣ�������java�����е�replace��������
	      ��ǰ�����滻��������ַ�Ҫ���������ƶ���Ҫ����ƶ�������Ч�ʵ���
	      �Ӻ���ǰ���ȼ�����Ҫ���ٿռ䣬Ȼ��Ӻ���ǰ�ƶ�����ÿ���ַ�ֻΪ�ƶ�һ�Σ�����Ч�ʸ���һ�㡣

	public class Solution {
	    public String replaceSpace(StringBuffer str) {
	        int spacenum = 0;//spacenumΪ����ո���
	        for(int i=0;i<str.length();i++){
	            if(str.charAt(i)==' ')
	                spacenum++;
	        }
	        int indexold = str.length()-1; //indexoldΪΪ�滻ǰ��str�±�
	        int newlength = str.length() + spacenum*2;//����ո�ת����%20֮���str����
	        int indexnew = newlength-1;//indexoldΪΪ�ѿո��滻Ϊ%20���str�±�
	        str.setLength(newlength);//ʹstr�ĳ�������ת����%20֮��ĳ���,��ֹ�±�Խ��
	        for(;indexold>=0 && indexold<newlength;--indexold){ 
	                if(str.charAt(indexold) == ' '){  //
	                str.setCharAt(indexnew--, '0');
	                str.setCharAt(indexnew--, '2');
	                str.setCharAt(indexnew--, '%');
	                }else{
	                    str.setCharAt(indexnew--, str.charAt(indexold));
	                }
	        }
	        return str.toString();
	    }
	}
		*/
	
}
