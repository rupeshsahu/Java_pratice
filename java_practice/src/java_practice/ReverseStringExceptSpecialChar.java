package java_practice;

public class ReverseStringExceptSpecialChar {
	
	public static void main (String[]args)
	{
		String str="@Rup@esh@sahu@";
		char [] arr=str.toCharArray();
		int l=0,r=arr.length-1;
	
		
		while(l<r)
		{
			if(!isAlphabet(arr[l]))
				l++;
			else if(!isAlphabet(arr[r]))
				r--;
			else{
				char tempc=arr[l];
				arr[l]=arr[r];
				arr[r]=tempc;
				l++;
				r--;	
			}
			
		}
		
		System.out.println(String.valueOf(arr));
		
	}
	
	public static boolean isAlphabet(char c)
	{
		return(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z')));
	}

}
