package com.nk.test2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
 * ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * 
 * @author zheng
 * 
 * ��LinkedHashMap����Ĵ洢��ֵ�ԣ����������ҳ�map��ӦֵΪ1��index
 * 
 */
public class FirstNotRepeatingCharTest {

	public static void main(String[] args) {

		int i = FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
		System.out.println(i);
		
	}
	
	public static int FirstNotRepeatingChar(String str) {
		
		HashMap<Character, Integer> mapnum = new LinkedHashMap<Character, Integer>();   //���Ϊ�����ֵ��
		HashMap<Character, Integer> mapadd = new HashMap<Character, Integer>();
		char c = 0 ;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!mapnum.containsKey(cs[i])) {
				mapnum.put(cs[i], 1);
			}else {
				mapnum.put(cs[i], mapnum.get(cs[i])+1);
			}
			if (!mapadd.containsKey(cs[i])) {
				mapadd.put(cs[i], i);
			}
			
		}
		for(Map.Entry<Character, Integer> entry : mapnum.entrySet()){   //map�ı���
			if (entry.getValue() == 1) {
				c = entry.getKey();
				return mapadd.get(c);
			}
		}
        return -1;
    }
	
	//����ķ���
	public int FirstNotRepeatingChar2(String str) {
        HashMap<Character, Integer> mapnum = new LinkedHashMap<Character, Integer>();
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!mapnum.containsKey(cs[i])) {
				mapnum.put(cs[i], 1);
			}else {
				mapnum.put(cs[i], mapnum.get(cs[i])+1);
			}
			
		}
		for (int i = 0; i < cs.length; i++) {   //��������
			if (mapnum.get(cs[i]) == 1) {
				return i;
			}
		}
        return -1;
    }
}
