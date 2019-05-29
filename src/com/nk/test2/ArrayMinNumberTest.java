package com.nk.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author zheng
 *
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 
 * 关于比较器，比如例题中的{3，32，321} 数组中先放入3，而后3和32比较，
 * 因为332>323 所以3>32 数组此时为[32,3]; 
 * 再往数组中加入321，先与32比较，32132<32321 故 321<32  
 * 故321应排在32前面，再与3比较 3213<3321 故321<3 数组最终排序[321，32，3]
 *
 */
public class ArrayMinNumberTest {

	public static void main(String[] args) {

		int[] array = {3,32,321};
		String string = PrintMinNumber(array);
		System.out.println(string);
		
		
	}

	public static String PrintMinNumber(int [] numbers) {

		String str = "";
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {   //比较器，实现接口的匿名内部类。根据指定的 Comparator 产生的顺序对 List 集合元素进行排序

			@Override
			public int compare(Integer n1, Integer n2) {

				String str1 = n1 + "" + n2;
				String str2 = n2 + "" + n1;
				
				
				return str1.compareTo(str2);  //比较器就是一个接口，通过实现这个接口重写compare方法，返回正值代表大于返回0代表等于，返回负值代表小于。
			}
			
		}); 
		
		for (Integer i : list) {
			str += i;
		}
		
		return str;
    }
	
	
	
	
}
