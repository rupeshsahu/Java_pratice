package java_practice;

public class Experiment {

	public static void main(String[] args) {
		String str ="RUpesh";
		String temp="";
		
		for(int i=0;i<str.length();i++)
			temp=str.charAt(i)+temp;
		System.out.println(temp);
		

	}

}
