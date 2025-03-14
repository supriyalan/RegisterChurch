package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class gospelHall extends Base{


	 public static ChromeDriver driver;
	
	 
	@Test
	public static void getHebrewsText() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		callingPropertyFile(); 
        driver.get(prop.getProperty("gospelhallurl"));	
        String test = driver.findElement(By.xpath("//div[@data-id='4d0da6b1-4710-452b-a634-9b38a7e41760']")).getText();
		System.out.println(test);
		driver.quit();
	}
	
	
	
}
