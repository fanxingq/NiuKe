package com.nk.test2;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 * 
 * @author zheng
 *
 * ���ݵ�����ʾ����������ջʵ�֣�ʹ�ø���ջ�����Сֵ����ջʱ����һ��ջͬʱ��ջ��
 * ȷ��ʱ�临�Ӷ�ӦΪO��1����
 */
public class NewStack {

	private static Stack<Integer> supStack = new Stack<Integer>();    //����ջ
	private static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		
		
		
		
	}
	
	public static void push(int node) {   
		
		//ÿ��ѹ��ջ֮ǰ�����븨��ջ�����бȽϣ�ÿ��Ҳ����Сֵѹ������ջ
        if (supStack.isEmpty()) {  //���Ϊ��ֱ��ѹ��ȥ
			supStack.push(node);
		}
		int supop = supStack.peek();    //������pop()����Ϊ�Ὣջ��Ԫ��ȡ����
		if (supop>node) {
			supStack.push(node);
		}else {
			supStack.push(supop);
		}
		
		stack.push(node);
		
    }
    
    public static void pop() {
        
    	stack.pop();    //������Ҫ��ջ
    	supStack.pop();
    	
    }
    
    public static int top() {
        
    	return stack.peek();
    }
    
    public static int min() {
        
    	return supStack.peek();
    }
	
	
	

}
