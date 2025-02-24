package Listeners;

public class Sample {

	public static void main(String[] args) {
		System.out.println("hello");
		
		Sample sam = new Sample();
		sam.methodOne();
		//methodTwo();
		//methodThree();
		//methodFour();
	}
	
	public void methodOne() {
		
		String str = "supriya is preparing";
		String rev = "";
		for(int i=str.length()-1;i>=0;i--)
		{
		rev=rev+str.charAt(i);
		}
		System.out.println(rev);

	}

	public static void methodTwo() {
		System.out.println("inside methodtwo");
	}
	
	public static void methodThree() 
	{
		int[] a = {1,4,3,5,6};
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
	}
	
	public static void methodFour() 
	{
		int[] a = {1,4,3,5,6};
		
		for(int i=a.length-1;i>=0;i--)
		{
			System.out.println(a[i]);
		}
		
	}

}
