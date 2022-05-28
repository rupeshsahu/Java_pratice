package java_practice;

public class check_prime {

	public static void main(String[] args) {
		
		System.out.println(CheckPrime(2));
		
		

	}
	
	public static boolean CheckPrime(int n){
		boolean flag=false;
		for (int i=2;i<=n/2;i++)
		{
			System.out.println(i);
			if (n%i==0){
				
				return false;
				
			}
		
		}
		
		return true;
	}

}
