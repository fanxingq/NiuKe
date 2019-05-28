package com.nk.test1;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����n<=39
 * @author zheng
 * 
 * �ݹ����׳���ջ��������
 * ��ѭ������ݹ�
 *
 */
public class FibonacciTest {

//	private static int[] record = null;
	public static void main(String[] args) {

		int fibonacci = Fibonacci(5);    // 0+1+2+3+4
		System.out.println(fibonacci);
		
		
	}
	
	public static int Fibonacci(int n) {
		
		//����1
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
		
		/*//����2
		if (n<=1) {
			return n;
		}
		if (record == null) {
			record = new int[n+1];
		}
		if (record[n-1] != 0 && record[n-2] != 0) {
			record[n] = record[n-1] + record[n-2];
		}else {
			return Fibonacci(n-1) + Fibonacci(n-2);           //���㵽�˵�0��͵�1��
		}
		return 0;*/
		
		
		/* 
		���ӣ�https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3
��Դ��ţ����

id:luck
��������˵�ǵ�����Iteration�� VS �ݹ飨Recursion����
f(n) = f(n-1) + f(n-2)����һ�ۿ����ǵݹ鰡����ֱ�����ĵݹ黷�����ݹ�϶���ˬ���������Źؼ����������о͸㶨�ˣ�ע�������n�Ǵ�0��ʼ�ģ�
if(n<=1) return n;
else return Fibonacci(n-1)+Fibonacci(n-2);
Ȼ����û��ʲô�ã�����������϶�׼����һ�������n����Stack Overflow��Ϊʲô���������Ϊ�ظ����㣬�����ظ�������������أ��ٸ�С������ӣ�n=4������������ô�ܵģ�
Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
             = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
             = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
�������ǵĴ��벢û�м�¼Fibonacci(1)��Fibonacci(0)�Ľ�������ڳ�����˵��ÿ�εݹ鶼��δ֪�ģ���˹���n=4ʱf(1)���ظ�������3��֮�ࡣ
��ô�������أ���̬�滮�ƺ��������ڶ�̬�滮���������������ӽṹ���޺�Ч�ԡ��������ص���Щ�Ͳ�̸�ˣ���Ϊ��(wo)��(ye)��(bu)̫(tai)ǿ(dong)�ˡ�
������һ���򵥵Ķ�̬�滮����һ���Ŀռ���۱�����۸�����ظ������ջ�ռ��˷ѣ�
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
��Ȼ�������ܴ����ռ��˷���sizeof(int)*(n-1)�����Ƕ����Ǹ�����n�Ĳ�������Ӧ���ǿ���ͨ���ˣ�ʱ�临�Ӷ�Ҳ�ﵽ��O(n)��
���ܲ��ܰѡ����š��ĵݹ�Ͷ�̬�滮��������أ��ݹ���ŵ����ڱ������ͱ��룬���ظ�����Ĺؼ�ԭ�����ڴ�����ֱ�Ӿ͡��ݡ���ȥȻ����š��顱�ˣ����Ա����ظ��Ĺؼ����ڶ��������Ƿ��Ѿ��ó�����жϣ�����
public static int[] record = null;
public int Fibonacci(int n){
    if(n<=1){
         return n;
    }
    if(null == record){
        record = new int[n+1];
    }
    if(0!=record[n-2] && 0!=record[n-1]){              //���ż���
        record[n] = record[n-2] + record[n-1];
    } else {
        return Fibonacci(n-2) + Fibonacci(n-1);
    }
}
		 */
    }

}
