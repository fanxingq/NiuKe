package com.nk.test3;

/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I����
 * ��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 * @author zheng
 *
 */
public class ReverseSentenceTest {

	public static void main(String[] args) {

		
		String string = " ";
		System.out.println(string.length());
		System.out.println(ReverseSentence(string));
		
	}


	public static String ReverseSentence(String str) {
     
//		String res = "";   //����ʹ��StringBuffer������append()
		StringBuffer sb = new StringBuffer();
		if (str==null||str.trim().equals("")) {   //��Ϊ���ܱ�֤���м����� �� ���ַ���������Ҫtrimһ�¡�
			return str;
		}
		String[] s2 = str.split(" ");
		for (int i = s2.length-1; i >= 0; i--) {
			
			if (i == 0) {
//				res = res + s2[i];
				sb.append(s2[i]);
			}else {
//				res = res + s2[i] + " ";
				sb.append(s2[i]);
				sb.append(" ");
			}
			
		}

//		return res;
		return sb.toString();
    }
	
}
