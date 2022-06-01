package java_practice;

public class CountSpecialCharString {

	public static void main(String[] args) {
		int count=0;
		String str="rupesh@sahu#$@";
		char arr[]=new char[str.length()];
				arr=str.toCharArray();
	    for(int i=0;i<arr.length;i++){
	    	if((isSpecialChar(arr[i])))
	    		count++;
	    	
	    }
		System.out.println(String.valueOf(count));

	}
	
	public static boolean isSpecialChar(char c){
		
		return (((c>=32)&&(c<=47)) || ((c>=58)&&(c<=64)) ||((c>=91)&&(c<=96))||((c>=123)&&(c<=126)));
		
	}

}
