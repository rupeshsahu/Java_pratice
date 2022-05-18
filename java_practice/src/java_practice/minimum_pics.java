package java_practice;
public class minimum_pics {

    public static void main(String[] args) {
        System.out.println(solution(arr()));
        
    }


    static int[] arr(){
       int a[]=new int[]{98,54,52,15,23,97,12,64,52,85};
       
        return a;
    }
    static int solution(int A[])
    {
        int odd_min=Integer.MAX_VALUE,even_max=0;
        for(int i=0;i<A.length;i++){

            if(A[i]%2==0){
                if(A[i]>even_max)
                even_max=A[i];
            
            }
            else{
                if(A[i]<odd_min)
                odd_min=A[i];
            
            }





        }

return even_max-odd_min;
    }
    
}
