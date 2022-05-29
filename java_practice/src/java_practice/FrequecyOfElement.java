package java_practice;

public class FrequecyOfElement {

	public static void main(String[] args) {

		int arr[]={1,2,4,1,3,1,3,5,2,1,4,1,3};
		int fr[]=new int[arr.length];
		int visited=-1;
	    for (int i=0;i<arr.length;i++){
	    	int count=1;
	    	for(int j=i+1;j<arr.length;j++){
	    		if(arr[i]==arr[j])
{
	count++;
	fr[j]=visited;
}
	    		if(fr[i]!=visited){
	    			fr[i]=count;
	    		}

	    	}
	    }
		for(int i=0;i<arr.length;i++)
		System.out.println(fr[i]);

	}

}
