package java_practice;

public class RandomNumber {

	public static void main(String[] args) {
		int i=0;
		while(i!=6)
		{
		i=(int) (Math.random()*(7-1)+1);
		System.out.println(i);
		}
		

	}

}
