package JavaPrograms;

public class Arrays {

	/*
	public static void main(String[] args) {

		//find min and max in an array
		
		int[] a = {12,30,500,90,900};
		int max=0;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
			
		}
			
		System.out.println("max is a[i]" +max);
	
	}

*/

	/*
	public static void main(String[] args) {
	
	int[] a = {12,30,500,90,900};
	int min=a[0];
	
	for(int i=0;i<a.length;i++)
	{
		if(a[i]<min)
		{
			min=a[i];
		}
		
	}
		
	System.out.println("max is a[i]" +min);

}
	
	*/
	
	//printing the array elements with for and for each loop
	
	/*
	public static void main(String[] args) {
		
		int[] a = {10,90,89,39,30};
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
	}
	
	*/
	
	/*
	public static void main(String[] args) {
		
		int[] a = {10,90,89,39,30};
		for( int b : a)
		{
		System.out.println(b);
		}
	}
	
	*/
	
	//sorting an array
	/*
	public static void main(String[] args) {
		int[] a = {10,90,89,39,30};
		int temp;
		
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=1;j<a.length-1;j++) 
			{
				if(a[i]>a[j])
				{
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				}
			}
		}
		System.out.println("sorted order is" + java.util.Arrays.toString(a));
	}

*/
	
	//removing duplicates from an array
	
	/*
	public static void main(String[] args) {
		int[] a = {10,10,90,90,30,30,20,20};
		
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					System.out.println(a[i]);
				}
			}
		}
		
	}
	
	*/
	
	/*
	//sum of elements in an array
	public static void main(String[] args) {
		int[] a = {10,10,90,90,30,30,20,20};
		int sum=0;
		
		for(int num: a)
		{
			sum = sum+num;
		}
			
		System.out.println(sum);
	
	}
	*/
	
	//reverse of a name
	
	/*
	public static void main(String[] args) {
		
		String str= " this is a name";
		String revstr = "";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			revstr = revstr+str.charAt(i);
		}
		
		System.out.println(revstr);
	}
	
	*/
	
	/*
	//find a word in a sentence
	public static void main(String[] args) {
	
		String s= "This is practice automation test";
		String word = "is";
		
		int result = word.indexOf(s);
		if(result == -1)
		{
			System.out.println("word is not present  in the sentence");
		}
		else System.out.println("word is  present");
	}

	*/
	
	//reverse of a number
	
	/*
	public static void main(String[] args) {
		
		int num = 1234567;
		int rev=0;
		
		while(num!=0)
		{
			rev=rev*10+num%10;
			num=num/10;
		}
		System.out.println(rev);
	}
	
	*/
	
	//sum of the numbers
	/*
	public static void main(String[] args) {
		 int num = 123456;
		 int sum = 0;
		 
		 while(num!=0)
		 {
			 sum = sum+num%10;
			 num=num/10;
			 
		 }
		System.out.println(sum); 
	}
	
	*/
	
	//count the number of digits in a number
	/*
	public static void main(String[] args) {
		int num = 123456789;
		int count =0;
		while(num!=0)
		{
			num = num/10;
			count++;
		}
		System.out.println(count);
	}
	
	*/
	
	//fibonacci series
	/*
	public static void main(String[] args) {
		
		int n1=0;
		int n2=1;
		int sum=0;
		
		System.out.println(n1);
		System.out.println(n2);
		
		for(int i=1;i<=9;i++)
		{
		sum = n1+n2;
		System.out.println(sum);
		
		n1=n2;
		n2=sum;
		}
	}
	*/
	
	//number is a palindrome
	/*
	public static void main(String[] args) {
	int num=12321;
	int rev = 0;
	
	while(num!=0)
	{
		rev=rev*10+num%10;
		num=num/10;
	}
	System.out.println(rev);
	if(num==rev)
		{
		System.out.println("number is a palindrome");
		}
	else 
	{
		System.out.println("number is not a palindrome");
	}
	}
	
	*/
	
	/*
	//swap two numbers
	public static void main(String[] args) {
		int a=100;
		int b=200;
		
		int temp;
		
		temp = a;
		a=b;
		b=temp;
		
		System.out.println(a);
		System.out.println(b);
		
	
	}
	 
	 */
	
	/*
	//searching for an element in an array
	public static void main(String[] args) {
	int[] a = {10,20,30,49,59,60};
	int num = 10;
	
	for(int i=0;i<a.length-1;i++)
	{
		if(a[i]==num)
		{
			System.out.println("number found in array" +num);
		}
	}
	
	}		
	
	*/
	
	/*
	//number of words in a string
	public static void main(String[] args) {
	String a = "supriya is reading";
	int count = 1;

	for(int i=0;i<a.length()-1;i++)
		{
			if(a.charAt(i) == ' ')
				{
				count++;
				}
		}
	System.out.println(count);
	}
	
	*/
	/*
	//number of times character is repeating in a string
		public static void main(String[] args) {
		String a = "supriya is is is reading";
		char ch = 'i';
		int count = 0;
		
		for(int i=0;i<a.length()-1;i++)
		{
			if(a.charAt(i) == ch)
				{
				count++;
				}
		}
		System.out.println(count);
		}
		
		*/
	
	/*
	//number of times a word is repeating in a string
	
	public static void main(String[] args) {
		
		String word = " this is is is a word word";
		String[] splitword = word.split(" ");
		int count = 0;
		
		for(int i=0;i<splitword.length-1;i++)
		{
			for(int j=i+1;j<splitword.length-1;j++)
			{
				if(splitword[i].equals(splitword[j]))
				{
					count++;
				}
			}
			
		}
		System.out.println(count);
	}
	
	*/
	
	
	/*
	//largest of 3 numbers
	public static void main(String[] args) {
		int a =100;
		int b=200;
		int c=300;
		
		if(a>b && a>c)
		{
			System.out.println("A is greatest" +a);
			
		}
		else if (b>a && b>c)
		{
			System.out.println("B is greatest" +b);
		}
		else System.out.println("C is greatest" +c);
	}
	*/
	
	//print even and odd numbers in an array
	
	/*public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]%2==0)
			{
			System.out.println("Even numbers are " + a[i]);
			}
			else if(a[i]%2!=0)
			{
			System.out.println("odd numbers are " + a[i]);
			}
			
		}
		
	} */
	
	// to convert string of arrays to arraylist
	/*
	public static void main(String[] args) {
	String[] arr = {"This","is","a","sample"};

	List<String> arraylist = java.util.Arrays.asList(arr);
	for(String alist : arraylist)
	{
		System.out.println(alist);
	}
		

	}	*/
	
	//anagrams
	/*
	public static void main(String[] args) {
		String a1 = "bat";
		String a2 = "tab";
		
		char[] b1 = a1.toCharArray();
		char[] b2 = a2.toCharArray();
		
		java.util.Arrays.sort(b1);
		java.util.Arrays.sort(b2);
		 
		if(java.util.Arrays.equals(b1, b2))
		{
		System.out.println("Anagrams");
		}
	}
	*/
	
	/*
	//arraylist to array 
	public static void main(String[] args) {
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(2);
		alist.add(3);
		alist.add(4);
		alist.add(5);
		
		System.out.println(alist.toString());
		
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}