package regchurch.registerchurch;
import windowhandles.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTesting {

	static ChromeDriver driver = new ChromeDriver();
	
	
	@BeforeClass
	public static void url()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
	}
	
		@Test(priority=0,groups ="launch")
		public static void alertyes() throws InterruptedException, IOException
		{
		driver.findElement(By.xpath("//input[@onclick='launchConfirmation()']")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert1.accept();
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File("screenshots\\alertyes.png"));
		}
		
		@Test(priority=1)
		public static void alertno() throws InterruptedException, IOException
		{
		driver.findElement(By.xpath("//input[@onclick='launchConfirmation()']")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert2.dismiss();
		screenshot st = new screenshot();
		String[] Destinationfile = null;
		st.getscreenshot(Destinationfile);
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File("screenshots\\alertno.png"));
		}
		
		@Test(priority=2)
		public static void mouseaction() throws IOException
		{
		WebElement dropdown = driver.findElement(By.xpath("//span[@id='blogsmenu']"));
		Actions act = new Actions(driver);
		act.moveToElement(dropdown).perform();
		driver.findElement(By.linkText("SeleniumTwoByArun")).click();
		driver.navigate().back();
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File("screenshots\\mouseaction.png"));
		}
		
		@Test(priority=3)
		public static void newwindow() throws InterruptedException, IOException
		{
			driver.findElement(By.linkText("Open a popup window")).click();
			Thread.sleep(3000);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> iterator = windows.iterator();
			while(iterator.hasNext())
			{
			String newwindow = iterator.next();
			driver.switchTo().window(newwindow);
			File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourcefile, new File("screenshots\\newwindow.png"));
			if(driver.getTitle().equals("New Window"))
			{
			String text = driver.findElement(By.xpath("//div/h3")).getText();
			System.out.println(text);
			Thread.sleep(4000);
			}}
			String originalwindow = driver.getWindowHandle();
			driver.switchTo().window(originalwindow);
			File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourcefile, new File("screenshots\\oldwindow.png"));
		}
		@AfterClass
		public static void quit()
		{
			driver.quit();
		}

}
