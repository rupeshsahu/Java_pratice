package collectoins;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Queue_collection {

	public static void main(String[] args) {
		
		PriorityQueue <String> q1=new PriorityQueue<String>();
		q1.add("Rupesh");
		q1.add("shubham");
		q1.add("puneet");
		q1.add("satish");
		q1.add("pranjal");
		
		System.out.println(q1.element());
		q1.remove();
		q1.poll();
		System.out.println(q1.element());
		q1.poll();
		System.out.println(q1.element());
		
		
		
		

	}

}
