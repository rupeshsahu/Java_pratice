package java_practice;

public class BubbleSort {

	public static void main(String[] args) {
	
		
	int arr[]={1,3,4,4,5,7,1,8,9};
	for (int i=0;i<arr.length;i++){
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]>arr[j])
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	
	for(int l:arr){
		System.out.println(l);
	}
	}

}
