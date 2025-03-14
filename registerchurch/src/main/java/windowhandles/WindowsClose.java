package windowhandles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsClose {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.id("selenium143")).click();
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iterator = windowids.iterator();
		while(iterator.hasNext())
		{
			String openedwindow = iterator.next();
			driver.switchTo().window(openedwindow);
			if(driver.getTitle().equals("Selenium143")) {
			driver.findElement(By.xpath("//a[@href='http://selenium-by-arun.blogspot.com/2012/11/what-is-selenium.html']")).click();}	
		}
		}
	}

