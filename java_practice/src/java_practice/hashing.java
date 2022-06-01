package java_practice;
import java.util.*;

public class hashing {


    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<Integer,String>();

   map.put(1,"Mango");  //Put elements in Map  
   map.put(2,"Apple");    
   map.put(3,"Banana");   
   map.put(4,"Grapes"); 
   map.put(5,"5"); 
   
   System.out.println(map);
    
       
   System.out.println("Iterating Hashmap...");  
   for(Map.Entry m : map.entrySet()){    
    System.out.println(m.getKey()+" "+m.getValue());
   }
        

    }
    
}
