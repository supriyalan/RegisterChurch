package windowhandles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Scanner {
		@Test
		public static void multiSelection() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/dynamictable");
			driver.manage().window().maximize();
			List<WebElement> rowdata = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]//div//span"));
			for(int i=0;i<rowdata.size();i++)
			{
				if(rowdata.get(i).getText().equalsIgnoreCase("Chrome"))
				{
					String cpuvalue = driver.findElement(By.xpath("//span[normalize-space()='Chrome']/following-sibling :: span[contains(text(),'%')]")).getText();
					System.out.println(cpuvalue);
				String chromecpuvalue = driver.findElement(By.xpath("//p[@class='bg-warning']")).getText();
				System.out.println(chromecpuvalue);
				if(chromecpuvalue.contains(cpuvalue))
				{
					System.out.println("both values are matching" );
				}
			}
			}
		}
		

		@Test
		public static void table() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/dynamictable");
			driver.manage().window().maximize();
			//List<WebElement> rowdata = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]//div//span"));
			String cpuvalue = driver.findElement(By.xpath("//span[normalize-space()='Chrome']/following-sibling :: span[contains(text(),'%')]")).getText();
			System.out.println(cpuvalue);
			String chromecpuvalue = driver.findElement(By.xpath("//p[@class='bg-warning']")).getText();
			System.out.println(chromecpuvalue);
			if(chromecpuvalue.contains(cpuvalue))
				{
					System.out.println("both values are matching" );
				}
			}
		
		@Test
		public static void animatedButton() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/animation");
			driver.manage().window().maximize();
			driver.findElement(By.id("animationButton")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("movingTarget"))).click();
			//driver.findElement(By.id("movingTarget")).click();
			
		}
		
		@Test
		public static void textInput() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/textinput");
			driver.manage().window().maximize();
			driver.findElement(By.id("newButtonName")).sendKeys("Type");
			driver.findElement(By.id("updatingButton")).click();
		}
		
}


