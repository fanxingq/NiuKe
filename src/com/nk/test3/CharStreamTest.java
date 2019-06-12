package com.nk.test3;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * @author zheng
 *
 */
public class CharStreamTest {

	private int[] hashtable = new int[256];
	private StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {

		
		
	}
	
	//Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        hashtable[ch] ++;
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    
    	char[] cs = sb.toString().toCharArray();
    	for (char c : cs) {
			if (hashtable[c] == 1) {  //输出一次，则第一个char就除去
				return c;
			}
		}
    	
    	return '#';
    }
	
	

}
