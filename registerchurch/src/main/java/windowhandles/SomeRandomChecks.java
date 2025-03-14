package windowhandles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SomeRandomChecks {

	public static void main(String[] args) {
		
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://omayo.blogspot.com/");	
			driver.manage().window().maximize();
			List<WebElement> tvalues = driver.findElements(By.xpath("//table[@id='table1']//th"));
			for(int i=0;i<tvalues.size();i++)
			{
				System.out.println(tvalues.get(i).getText());
			}
		driver.quit();
		image();
	}
	
	
	public static void image() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");	
		driver.manage().window().maximize();
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		for(int i=0;i<allimages.size();i++)
		{
			String name = allimages.get(i).getText();
			String url = allimages.get(i).getAttribute("src");
			System.out.println(name + url);
		}
		
		driver.quit();
	}
	}


