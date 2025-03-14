package windowhandles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.MyListeners;

@Listeners(MyListeners.class) 
public class windows { 
	
	@Test(groups= "launch")
	public static void newwindowtesting() throws IOException {

		{
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://www.google.com/");
			driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("youtube");
			driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(Keys.ENTER);
			Actions act = new Actions(driver);
			WebElement click = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md'][text()='YouTube: Home']"));
			act.keyDown(Keys.CONTROL).click(click).keyUp(Keys.CONTROL).build().perform();
			
			String originalwindow = driver.getWindowHandle();
			Set<String> windowid = driver.getWindowHandles();
			Iterator<String> iterator = windowid.iterator();
			while(iterator.hasNext())
			{
			String openednewwindow = iterator.next();
			driver.switchTo().window(openednewwindow);
			if(driver.getTitle().equals("YouTube"))
			{
				driver.findElement(By.xpath("//input[@id='search']")).sendKeys("thank you jesus");
				File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sourcefile, new File("screenshots\\thankyoujesusword.png"));
				driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
			}
			}
			driver.switchTo().window(originalwindow);
			driver.findElement(By.xpath("//a[text()='Music']")).click();
			driver.navigate().back();
			WebElement texttoclear = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(texttoclear).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
			driver.quit();
			}
		}
	}