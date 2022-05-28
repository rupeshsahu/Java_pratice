package java_practice;

public class reverseString {

	public static void main(String[] args) {
		
		System.out.println(reverseStr("RUPESH"));
	

	}
	
	public static String reverseStr(String str1){
		
	char[] a=str1.toCharArray();
	int left=0,right=0;
	right=a.length-1;
	for (left=0;left<right;left++,right--){
		
		char temp=a[left];
		a[left]=a[right];
		a[right]=temp;
	}
 return String.valueOf(a);
		
	}
	
	

}
