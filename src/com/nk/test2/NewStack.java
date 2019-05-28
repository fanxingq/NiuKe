package com.nk.test2;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * @author zheng
 *
 * 根据道友提示，借助辅助栈实现，使用辅助栈存放最小值，出栈时和另一个栈同时出栈。
 * 确保时间复杂度应为O（1）。
 */
public class NewStack {

	private static Stack<Integer> supStack = new Stack<Integer>();    //辅助栈
	private static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		
		
		
		
	}
	
	public static void push(int node) {   
		
		//每次压进栈之前，先与辅助栈顶进行比较，每次也将最小值压进辅助栈
        if (supStack.isEmpty()) {  //如果为空直接压进去
			supStack.push(node);
		}
		int supop = supStack.peek();    //不能用pop()，因为会将栈顶元素取出来
		if (supop>node) {
			supStack.push(node);
		}else {
			supStack.push(supop);
		}
		
		stack.push(node);
		
    }
    
    public static void pop() {
        
    	stack.pop();    //两个都要出栈
    	supStack.pop();
    	
    }
    
    public static int top() {
        
    	return stack.peek();
    }
    
    public static int min() {
        
    	return supStack.peek();
    }
	
	
	

}
