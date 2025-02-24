package forDTCC;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class PracticeAutomation {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void dropDownList() {
		
		
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/dynamictable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> alltablevalues = driver.findElements(By.xpath("//div[@role='table']"));
		for(int i=0;i<alltablevalues.size();i++)
		{
			if(alltablevalues.get(i).getText().contains("Chrome"))
			{
				System.out.println(driver.findElement(By.xpath("//div[@role='table']//div//span[contains(text(),'%')]")).getText());
			}
		}
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Chrome CPU')]")).getText());
	}
	
	@Test()
	public void frame() {
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement id = driver.findElement(By.id("iframe2"));
		driver.switchTo().frame(id);
		driver.findElement(By.linkText("Selenium IDE")).click();
	}
	
	@Test()
	public void calender() throws InterruptedException, IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://parsippanygospelhall.org/");
		
		File inputScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(inputScreenshot, new File(".//screenshots.bible.png"));
		
	}
}
