package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class Google extends Base{
	    
	//public static WebDriver driver;
	
	@BeforeMethod
	public static void login() throws IOException
	{
		callingPropertyFile();
		driver = initialiseBrowser(prop.getProperty("browsername"));
		
    }
	
	@Test(dataProvider= "datatogooglesearch", dataProviderClass = Base.class)
	public void homePage(String googledata) throws IOException
	{
		//driver.get(prop.getProperty("googleurl"));	
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(googledata);
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(Keys.ENTER);
			
	}
	
	@Test
	public void about()
	{
		driver.findElement(By.linkText("About")).click();
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "Google");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
