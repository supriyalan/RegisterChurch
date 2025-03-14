package regchurch.registerchurch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaPrograms {

	@Test
	public void stringReversal() {
		
		String s = "This is a sample testing";
		String rev = "";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			rev = rev+s.charAt(i);
		
		}
		System.out.println(rev);
		
	}
	
	@Test
	public void numberReversal() {
		
		int num = 12345;
		int rev = 0;
		
		while(num!= 0)
		{
			rev = rev*10+num%10;
			num=num/10;
			
		}
		System.out.println(rev);
		
	}
	
	@Test
	public void sumOfDigits() {
		int num = 12345;
		int sum = 0;
		
		while(num!=0)
		{
			sum=sum+num%10;
			num=num/10;
		}
		System.out.println(sum);
	}
	
	@Test
	public void countOfDigits() {
		
		int num = 123456;
		int count =0;
		while(num!=0)
		{
			num=num/10;
			count++;
		}
		System.out.println(count);
	}
	
	@Test
	public void printArrayElements() {
		
		int[] a = {1,2,3,4,5};
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	@Test
	public void arrayReversal() {
		int[] a = {1,2,3,4,5};
		for(int i=a.length-1;i>=0;i--)
		{
			System.out.println(a[i]);
		}
	}
	
	@Test
	public void maxinArray() {
		int[] a = {10,20,30,400,50};
		int max=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		System.out.println(max);
	}
	
	@Test
	public void mininArray() {
		int[] a = {100,200,30,40,50};
		int min=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<min)
			{
				min=a[i];
			}
		}
		System.out.println(min);
	}
	
	@Test
	public void removeDuplicates() {
		int[] a = {10,10,20,20,30,30};
		
		for(int i=0;i<a.length;i++)
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
	
	@Test
	public void sumOfArray() {
		int[] a = {10,10,20,20,30,10};
		int sum=0;
		
		for(int i=0;i<a.length;i++) 
		{
			sum=sum+a[i];
			
		}
		System.out.println(sum);
	}
	
	@Test
	public void google() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
		List<WebElement> dropdown = driver.findElements(By.xpath("//ul/li[@role='presentation']"));
		for(int i=0;i<dropdown.size();i++)
		{
			if(dropdown.get(i).getText().contains("foods"))
					{
				driver.findElement(By.xpath("//li[@data-entityname=\"selenium<b> foods</b>\"]")).click();
					}
		}
		
	}
	
	@Test
	public void calendarAgain() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://parsippanygospelhall.org/calendar");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		while(!driver.findElement(By.id("fc-dom-1")).getText().equalsIgnoreCase("March 2025"))
		{
			driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevron-right']")).click();
			driver.findElement(By.id("fc-dom-1")).getText();
		}
		driver.findElement(By.xpath("//a[@href='/event/p7bw5fw/ladies-bible-study']")).click();
	}
	
	@Test
	public void tableAgain() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> fulltable = driver.findElements(By.id("table1"));
		
		for(int i=0;i<fulltable.size();i++)
		{
			System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText());
		} 	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void tableAgainn() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	List<WebElement> firstrow = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
	int praveenrow = 0;
	for(int i=0;i<firstrow.size();i++)
	{
		if(firstrow.get(i).getText().equalsIgnoreCase("Praveen"))
		{
			praveenrow = i+1;
			System.out.println(praveenrow);
		}
	
	}
	
	 System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+praveenrow+"]/td[3]")).getText());
	
}
	
	
	
	@Test
	public void tableAgainCom() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/dynamictable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String cpuvalue = driver.findElement(By.xpath("//div[@role='rowgroup'][2]//span[contains(text(),'Chrome')]//following-sibling::span[contains(text(),'%')]")).getText();
		System.out.println(cpuvalue);
		String cpupervalue = driver.findElement(By.xpath("//p[@class='bg-warning']")).getText();
		System.out.println(cpupervalue);
		if(cpuvalue.contains(cpupervalue))
		{
			System.out.println("both values are equal");
		}
		
}
	

	@Test
	public void dropdowns() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("trump");
		List<WebElement> trumpdropdownvalues = driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li"));
		for(WebElement value : trumpdropdownvalues)
		{
			if(value.getText().equalsIgnoreCase("trump greenland"))
			{
				value.click();
				break;
			}
		}
		
}
}