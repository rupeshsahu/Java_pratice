package java_practice;

public class fibonacci_recursion {
static int n1=0,n2=1,n3=0;
	public static void main(String[] args) {
		
		
		for (int i=0;i<12;i++)
		System.out.println(fib(i));
		

	}
	
	static int fib(int i){//program to find nth element of fibonacci series.
		
		if (i<=1)
		return i;
		
		return fib(i-1)+fib(i-2);
		
	}

}
