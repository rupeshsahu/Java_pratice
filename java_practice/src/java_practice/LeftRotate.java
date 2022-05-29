package java_practice;

public class LeftRotate {

	public static void main(String[] args) {


		int[] arr={1,2,3,4,5};
		
		for (int i=0;i<3;i++)
		{
			int temp=arr[0];
			for(int j=0;j<arr.length-1;j++)
			{
				
				arr[j]=arr[j+1];
			}
			arr[arr.length-1]=temp;
				
		}
		for(int l:arr)
			System.out.println(l);

	}

}
