package OmayoBlogspot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FileUpload {
	
	@Test
	public static void uploadFile() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\lsupr\\Documents\\Saturday 2.30-3pm joeys appt.txt");
	}
		@Test
		public static void frame() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			WebElement frame1 = driver.findElement(By.id("iframe1"));
			driver.switchTo().frame(frame1);
		driver.findElement(By.linkText("What is Selenium?")).click();

}
		@Test
		public static void multiSelection() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
			driver.manage().window().maximize();
			WebElement multiselection = driver.findElement(By.xpath("//select[@name='FromLB']"));
			Select sel = new Select(multiselection);
			sel.selectByVisibleText("USA");
			sel.selectByVisibleText("Spain");
			sel.selectByVisibleText("Malaysia");
			driver.findElement(By.xpath("//input[@value='->']")).click();
}
		@Test
		public static void fileSelection() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@name='img']")).sendKeys("C:\\Users\\lsupr\\samp.txt");
			WebElement cardropdown = driver.findElement(By.id("Carlist"));
			Select sel = new Select(cardropdown);
			sel.selectByVisibleText("BMW");
					
}
		
		@Test
		public static void table() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
			driver.manage().window().maximize();
			List<WebElement> tvalues = driver.findElements(By.xpath("//table[@border='1']//tbody//tr//td"));
			for(int i=0;i<tvalues.size();i++)
			{
				System.out.println(tvalues.get(i).getText());
			}
			
			WebElement submit = driver.findElement(By.xpath("//table[@border='1']//tbody//tr[3]//td[6]/form/input"));
			System.out.println(submit);
			
			/*List<WebElement> submit = driver.findElements(By.xpath("//table[@border='1']//tbody//tr[3]//td[6]/form/input[@id='submitButton']"));
			for(int i=0;i<submit.size();i++)
			{
				System.out.println(submit.get(i).getText());
			}*/
}
		
		@Test
		public static void windowHandles() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Open a popup window")).click();
			driver.findElement(By.linkText("SeleniumTutorial")).click();
			
			Set<String> windowids = driver.getWindowHandles();
			for(String window : windowids)
			{
				driver.switchTo().window(window);
				try {

					String newwindowtext = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
					System.out.println(newwindowtext);
					break;
				}
				catch(Exception e)
				{
					driver.close();
				}
				
			}
			
}
		
		@Test
		public static void autoSuggestions() throws InterruptedException {

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			driver.findElement(By.id("autocomplete")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("autocomplete")).sendKeys("united");
			Thread.sleep(2000);
			for(int i=0;i<4;i++)
			{
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			}
		
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
			}
		
		@Test
		public static void tableData() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			List<WebElement> tabledata = driver.findElements(By.xpath("(//table[@id='product'])[1]//tbody//tr[5]"));
			for(int i=0;i<tabledata.size();i++)
			{
				System.out.println(tabledata.get(i).getText());
			}
}
		
		@Test
		public static void mouseHover() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			WebElement mousehover = driver.findElement(By.id("mousehover"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(mousehover).perform();
			
		}
		
		@Test
		public static void switchtoFrame() {

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			WebElement iframe = driver.findElement(By.id("courses-iframe"));
			driver.switchTo().frame(iframe);
			Actions act2 = new Actions(driver);
			WebElement more = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'][@data-toggle='dropdown'])[1]"));
			act2.moveToElement(more);
			driver.findElement(By.xpath("(//a[text()='About us'])[1]")).click();
					
			}
		
		@Test
		public static void allImages() throws MalformedURLException, IOException, URISyntaxException {

			WebDriver driver = new ChromeDriver();
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			List<WebElement> linktexts = driver.findElements(By.tagName("a"));
			for(int i=0;i<linktexts.size();i++)
			{
				String linktext = linktexts.get(i).getText();
				String url = linktexts.get(i).getAttribute("href");
				System.out.println(linktext + url);
					HttpURLConnection huc = (HttpURLConnection)(new URI(url).toURL().openConnection());
					huc.connect();
					if(huc.getResponseCode()>=400)
					{
						System.out.println("broken url is " + url);
					}
			}
}
		
		@Test
		public static void calender(){

			WebDriver driver = new ChromeDriver();
			driver.get("https://parsippanygospelhall.org/");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("(//a[@href='/ministries'])[1]")).click();
		
			driver.findElement(By.xpath("(//a[@href='/movie-night'])[1]")).click();
			
		
}
		
		
}