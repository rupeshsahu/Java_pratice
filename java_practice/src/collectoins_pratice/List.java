package collectoins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class List {

	public static void main(String[] args) {
		
ArrayList list1=new ArrayList();
list1.add(1);
list1.add(2);
list1.add(3);
list1.add(4);
list1.add(5);
list1.add(6);
Iterator itr=list1.iterator();
while(itr.hasNext())
{
	System.out.println(itr.next());
}


LinkedList ll = new LinkedList();
Vector<String> v=new Vector<String>();
Stack<String> stack=new Stack<String>();
stack.push("Rupesh");
stack.push("Shubham");
stack.push("Puneet");
stack.push("satish");
stack.push("pranjal");
stack.push("aman");
stack.push("tulsi");
stack.push("Ashwini");
stack.push("Aman");
System.out.println(stack.pop());
System.out.println(stack.pop());
System.out.println(stack.pop());
Iterator<String> itr1=stack.iterator();
while(itr1.hasNext()){
	System.out.println(itr1.next());
}

	}

}
