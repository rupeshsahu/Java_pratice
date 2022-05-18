package java_practice;
public class odd_even_subsequence {
    public static void main(String[] args) {
System.out.println(solution(arr()));
        
    }

    static int[] arr(){
        int arr1[]=new int[]{12,10,28,37,43,40,14,12,48};
        return arr1;
    }
    static int solution(int[]A)
    {

        int count=0;
        boolean even_flag=true,odd_flag=true;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%2==0)
            {
                if(even_flag)
                {
                    count++;
                    even_flag=false;
                    odd_flag=true;
                }

            }
            else{
                if(odd_flag)
                {
                    count++;
                    even_flag=true;
                    odd_flag=false;

                }


            }
        }

            

        
        
        

        return count;

    }

}
