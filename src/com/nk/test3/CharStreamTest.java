package com.nk.test3;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
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
			if (hashtable[c] == 1) {  //���һ�Σ����һ��char�ͳ�ȥ
				return c;
			}
		}
    	
    	return '#';
    }
	
	

}
