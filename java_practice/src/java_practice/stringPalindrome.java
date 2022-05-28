package java_practice;

public class stringPalindrome {

	public static void main(String[] args) {
	checkStringPalindrome("A quick brown fox jumps oer the little lazy dog");


	}
	
	public static void checkStringPalindrome(String string)
	{
		
	try{
		int lenght=string.length();
		int i=0;
		int j=lenght;
		char temp;
		String str1="";
		for (int k=j-1;k>=0;k--){
			str1=str1+string.charAt(k);	
			
		}
		System.out.println(str1);
	}
	catch(Exception e)
	{
		System.out.println(e.getStackTrace());
	}
	}

}
