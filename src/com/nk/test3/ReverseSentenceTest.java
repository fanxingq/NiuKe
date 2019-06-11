package com.nk.test3;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
     
//		String res = "";   //可以使用StringBuffer，调用append()
		StringBuffer sb = new StringBuffer();
		if (str==null||str.trim().equals("")) {   //因为不能保证会有几个“ ” 空字符，所以需要trim一下。
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
