package forDTCC;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintDataTable {

	@Test
	public static void returnData() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/verifytext");
		String text = driver.findElement(By.xpath("(//span[@class='badge-secondary'])[4]")).getText();
	System.out.println(text);
	}
	
	@Test
	public static void scrollButton() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/scrollbars");
		driver.manage().window().maximize();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(200,400)");
		
		driver.findElement(By.id("hidingButton")).click();
		//driver.close();
	}
	
	//3466
	@Test
	public static void startStopButton() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/progressbar");
		driver.manage().window().maximize();
		driver.findElement(By.id("startButton")).click();
		Thread.sleep(17329);
		driver.findElement(By.id("stopButton")).click();
		
	}
	
	@Test
	public static void animatedButton() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/animation");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("animationButton")).click();
		Thread.sleep(10000);
		String expected = driver.findElement(By.xpath("//div[text()='Animation done']")).getText();
		String actual = "Animation done";
		Assert.assertEquals(actual, expected);
		//System.out.println(expected);
		driver.findElement(By.id("movingTarget")).click();
		
		
	}
	
	@Test
	public static void clientsideWaitButton() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/clientdelay");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("ajaxButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("bg-success"), "Data calculated on the client side."));
		String Actualtext = driver.findElement(By.className("bg-success")).getText();
		Assert.assertEquals(Actualtext, "Data calculated on the client side.", "both are matching");
}
	
	@Test
	public static void alerts() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("alertButton")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		driver.findElement(By.id("promptButton")).click();
		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("bat");
		alert4.accept();
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.alertIsPresent());
		Alert alert5 = driver.switchTo().alert();
		System.out.println(alert5.getText());
		alert5.accept();
		
		}
	
	@Test
	public static void autoWait() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/autowait");
		driver.manage().window().maximize();
		WebElement dropdown = driver.findElement(By.id("element-type"));
		dropdown.click();
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Input");
		driver.findElement(By.className("form-check-label")).click();
		driver.findElement(By.id("target")).click();
		driver.findElement(By.id("target")).sendKeys("input text");
		driver.findElement(By.id("applyButton3")).click();
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.id("opstatus"), "Target element state restored."));
			
}
	
	@Test
	public static void tableCompare() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/dynamictable");
		driver.manage().window().maximize();
		List<WebElement> allelements = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]//div//span"));
		for(int i=0;i<allelements.size();i++)
		{
			String chrometext = allelements.get(i).getText();
			if(chrometext.equals("Chrome"))
			{
				String cpuvalue = driver.findElement(By.xpath("(//span//following-sibling::span[contains(text(),'%')])")).getText();
				System.out.println(cpuvalue);
				String bottomvalue = driver.findElement(By.xpath("//p[contains(text(),'Chrome CPU')]")).getText();
				System.out.println(bottomvalue);
				if(bottomvalue.contains(cpuvalue))
				{
					System.out.println("cpu values are equal");
				}
				else
				{
					System.out.println("cpu values are not equal");
				}
				break;
					
			}
			
		}
	}
	

	@Test
	public static void tableprint() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/dynamictable");
		driver.manage().window().maximize();
		List<WebElement> alltablevalues = driver.findElements(By.xpath("//div[@aria-describedby='table_desc']"));
		{
			for(int i=0;i<alltablevalues.size();i++)
			{
				String values = alltablevalues.get(i).getText();
				System.out.println(values);
				if(values.contains("Chrome"))
				{
					String cpuvalue = driver.findElement(By.xpath("//div//span[contains(text(),'%')]")).getText();
					System.out.println(cpuvalue);
					String bottomvalue = driver.findElement(By.xpath("//p[contains(text(),'Chrome CPU')]")).getText();
					System.out.println(bottomvalue);
					
					
				}
			}
		}
		
	}
	
	@Test
	public static void calenderpicker() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
		driver.findElement(By.id("first_date_picker")).click();
		String month = driver.findElement(By.className("ui-datepicker-month")).getText();
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		
		while(!(month=="December" && year == "2024"))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			break;
		}
		driver.findElement(By.xpath("//a[text()='25']")).click();
		
	}	
		@Test
		public static void fourthpicker() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("fourth_date_picker")).click();
			
		WebElement monthdropdown = driver.findElement(By.className("ui-datepicker-month"));
		Select sel1 = new Select(monthdropdown);
		sel1.selectByVisibleText("Dec");
		WebElement yearpick = driver.findElement(By.id("ui-datepicker-year"));
		Select sel2 = new Select(yearpick);
		sel2.selectByVisibleText("2025");
		driver.findElement(By.xpath("//a[text()='25']")).click();
		
}
		
		@Test
		public static void overlappedElement() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/overlapped");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//div[@style='overflow-y: scroll; height:100px;']")).click();
			Actions act7 = new Actions(driver);
			act7.sendKeys(Keys.PAGE_DOWN).perform();
			driver.findElement(By.id("name")).sendKeys("text");
			
		}	
		
		@Test
		public static void disabledInput() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/disabledinput");
			driver.manage().window().maximize();
			driver.findElement(By.id("inputField")).sendKeys("sample text");
			driver.findElement(By.id("enableButton")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("inputField"))).sendKeys(Keys.chord(Keys.CONTROL,"a"));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("inputField"))).sendKeys("text after enabled");
			
}
		@Test
		public static void shadowdom() {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/shadowdom");
			driver.manage().window().maximize();
			driver.findElement(By.id("buttonGenerate")).click();
			driver.findElement(By.id("buttonCopy")).click();
			String editfield = driver.findElement(By.id("editField")).getText();
			String buttoncopy = driver.findElement(By.id("buttonCopy")).getText();
			Assert.assertEquals(editfield, buttoncopy);
			}
		
		@Test
		public static void uploadFile() throws AWTException, InterruptedException {

			WebDriver driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/upload");
			driver.manage().window().maximize();
			WebElement frame = driver.findElement(By.xpath("//iframe[@src='/static/upload.html']"));
			driver.switchTo().frame(frame);
			driver.findElement(By.className("browse-btn")).click();
			
			Robot robot = new Robot();
			StringSelection path = new StringSelection("C:\\Users\\lsupr\\samp.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			//driver.findElement(By.className("browse-btn")).sendKeys("C:\\Users\\lsupr\\samp.txt");
			
			
			
			
}
}