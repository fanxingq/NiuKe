package com.nk.test1;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @author zheng
 * 
 * 递归容易出现栈溢出的情况
 * 用循环代替递归
 *
 */
public class FibonacciTest {

//	private static int[] record = null;
	public static void main(String[] args) {

		int fibonacci = Fibonacci(5);    // 0+1+2+3+4
		System.out.println(fibonacci);
		
		
	}
	
	public static int Fibonacci(int n) {
		
		//方法1
		if (n>39) {
			return -1;
		}
		if (n == 0 || n == 1) {
			return n;
		}
		int preNum = 0;
		int nowNum = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			
			result = preNum + nowNum;
			preNum = result - preNum;
			nowNum = result;
			
		}
		return result;
		
		/*//方法2
		if (n<=1) {
			return n;
		}
		if (record == null) {
			record = new int[n+1];
		}
		if (record[n-1] != 0 && record[n-2] != 0) {
			record[n] = record[n-1] + record[n-2];
		}else {
			return Fibonacci(n-1) + Fibonacci(n-2);           //计算到了第0项和第1项
		}
		return 0;*/
		
		
		/* 
		链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3
来源：牛客网

id:luck
这个题可以说是迭代（Iteration） VS 递归（Recursion），
f(n) = f(n-1) + f(n-2)，第一眼看就是递归啊，简直完美的递归环境，递归肯定很爽，这样想着关键代码两三行就搞定了，注意这题的n是从0开始的：
if(n<=1) return n;
else return Fibonacci(n-1)+Fibonacci(n-2);
然而并没有什么用，测试用例里肯定准备着一个超大的n来让Stack Overflow，为什么会溢出？因为重复计算，而且重复的情况还很严重，举个小点的例子，n=4，看看程序怎么跑的：
Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
             = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
             = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
由于我们的代码并没有记录Fibonacci(1)和Fibonacci(0)的结果，对于程序来说它每次递归都是未知的，因此光是n=4时f(1)就重复计算了3次之多。
那么如何求解呢，动态规划似乎不错，关于动态规划三个条件：最优子结构、无后效性、子问题重叠这些就不谈了，因为理(wo)论(ye)性(bu)太(tai)强(dong)了。
下例是一个简单的动态规划，以一定的空间代价避免代价更大的重复计算的栈空间浪费：
if(n<=1){
    return n;
}
int[] record = new int[n+1];
record[0] = 0;
record[1] = 1;
for(int i=2;i<=n;i++){
    record[i] = record[i-1] + record[i-2];
}
return record[n];
虽然看起来很蠢，空间浪费了sizeof(int)*(n-1)，但是对于那个超大n的测试用例应该是可以通过了，时间复杂度也达到了O(n)。
那能不能把“优雅”的递归和动态规划结合起来呢？递归的优点在于便于理解和编码，而重复计算的关键原因在于代码里直接就“递”进去然后等着“归”了，所以避免重复的关键在于对子问题是否已经得出解的判断，即：
public static int[] record = null;
public int Fibonacci(int n){
    if(n<=1){
         return n;
    }
    if(null == record){
        record = new int[n+1];
    }
    if(0!=record[n-2] && 0!=record[n-1]){              //倒着计算
        record[n] = record[n-2] + record[n-1];
    } else {
        return Fibonacci(n-2) + Fibonacci(n-1);
    }
}
		 */
    }

}
