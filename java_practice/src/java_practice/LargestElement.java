package java_practice;

public class LargestElement {

	public static void main(String[] args) {

		int arr[]={4,12,3,12,412,23,21,3133};
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{if(arr[i]<max)
			max=arr[i];
		}
		System.out.println(max);

	}

}
