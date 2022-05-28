package java_practice;

public class CheckPalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println(checkPalindrome(123));

	}
	
	public static boolean checkPalindrome(int n)
	{int r,sum=0,temp;
	
	temp=n;
		while(n>0){
			r=n%10;
			sum=sum*10+r;
			n=n/10;
		}
		System.out.println("number is:"+temp);
		System.out.println("palindrome  is:"+sum);
		if(sum==temp)
			return true;
		else
			return false;
	}

}
