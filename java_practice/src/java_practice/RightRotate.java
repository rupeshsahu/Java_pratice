package java_practice;

public class RightRotate {

	public static void main(String[] args) {
		int arr[]={1,2,3,4,5};
     for(int i=0;i<3;i++)
     {
    	 int temp=arr[arr.length-1];
    	 for(int j=arr.length-2;j>=0;j--){
    		 
    		 arr[j+1]=arr[j]; 
    		 
    	 }
    	 arr[0]=temp;
     }
     
     for(int l:arr)
    	 System.out.println(l);

	}

}
