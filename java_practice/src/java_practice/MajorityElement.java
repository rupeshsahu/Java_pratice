package java_practice;

import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {
		
		int arr[]={5,5,4,5,8,5,8,8,8,8};
		findMajority(arr);

	}
	
	
	private static void findMajority(int[] arr)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) 
            {
                    int count = map.get(arr[i]) +1;
                    if (count > arr.length /3) 
                    {
                        System.out.println("Majority found :- " + arr[i]);
                        return;
                    } else
                        map.put(arr[i], count);
            }
            
            else
                map.put(arr[i],1);
            }
            System.out.println(" No Majority element");
    }
 
	 

}
