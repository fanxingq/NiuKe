package com.nk.test1;

import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * @author zheng
 *
 */
public class StackToQueue {

	static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String[] args) {

		//["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
		//1,2,3,4,5
		
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(pop());
		push(4);
		System.out.println(pop());
		push(5);
		System.out.println(pop());
		System.out.println(pop());
	}
	    public static void push(int node) {
	        
	    	stack1.push(node);
	    	System.out.println("����Ϊ��"+stack1.toString());
	    }
	    
	    public static int pop() {
	    	
	    	int result;
	    	while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
	    	result = stack2.pop();
	    	while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
				
			}
			return result;
	    
	    }
}
