package forTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google {

	ChromeDriver driver;
	
	@Test
	public void homePage()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@class='gLFyfn']")).sendKeys("jesus");
		driver.findElement(By.xpath("//textarea[@class='gLFyfxx']")).sendKeys(Keys.ENTER);
		
		
	}
	
	@Test
    public void testExample() {
              Assert.assertTrue(driver.getTitle().contains("Nonexistent Title"));
    }
	
	public void tearDown()
	{
		driver.quit();
	}
}
