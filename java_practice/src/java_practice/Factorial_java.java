package java_practice;

public class Factorial_java {

	public static void main(String[] args) {
		
System.out.println(fac(3));
	}
	
	public static int fac(int n){
		
		if (n==0)
			return 1;
		System.out.println(n);
		return n*fac(n-1);
	}

}
