package java_practice;
public class singlenumber {
    public static void main(String[] args) {
        int a=123;
        int b=12;
        int c=0;
        int d=17;
System.out.println(solution(arr()));
    

    }


    static int[] arr(){
        int arr1[]=new int[]{12,12,28,37,14,40,14,37,40};
        return arr1;
    }

    static int solution(int[]A)
    {
        int temp=0;
        for(int i=0;i<A.length;i++)
        {
            temp=temp^A[i];
            System.out.println(temp);
        }
        return temp;
    }
    
}
