package java_practice;

public class NearestPalindrome {

	public static void main(String[] args) {
		int n=122;
		int l=n-1;
		int r=n+1;
		while (!isPalindrome(l))
		{
			l--;
		}
		
		while (!isPalindrome(r))
		{
			r++;
		}
		System.out.println(l+"  "+r);
		
		if((n-l)<(r-n))
		{
			System.out.println(l);
		}
		else{
			System.out.println(r);
		}
	}
	
	
	public static boolean isPalindrome(int n){
		int reversed=0;
		int temp=n;
		while(n>0){	
	reversed=reversed*10+(n%10);
	n=n/10;
		}
		
		if(reversed==temp)
			return true;
		else
			return false;
	}

}
