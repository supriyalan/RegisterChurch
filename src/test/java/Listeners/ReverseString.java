package Listeners;

public class ReverseString {

	public static void main(String[] args) {
		
		String Str = "SUPRIYA";
		String Rev = " ";
		
		for(int i = Str.length()-1;i>=0;i--) {
			Rev = Rev+Str.charAt(i);
		}
			System.out.println(Rev);
		}

	}

