package regchurch.registerchurch;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterVbs {
	static ChromeDriver driver = new ChromeDriver();
	
	@BeforeClass
	public static void loginwithurl() 
	{
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.get("https://www.google.com");
	}
	
	@Test(priority=0,groups = "launch")
	public static void title() throws IOException
	{
	driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys("parsippany baptist church");
	driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
	driver.findElement(By.linkText("Register")).click();
	WebElement text = driver.findElement(By.xpath("//h1[@id='field_title']"));
	File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(sourcefile, new File("screenshots\\register.png"));
	String actual = text.getText();
	System.out.println(actual);
	Assert.assertEquals("Register for VBS","Register for VBS");
	}
	
	@Test(priority=1)
	public static void address()
	{
	driver.findElement(By.id("id_family_address_street1")).sendKeys("vail road");
	}
	
	@Test(priority=2)
	public static void flagdownarrow()
	{
	for(int i =0;i<4;i++)
	{
		driver.findElement(By.xpath("//div[@class='selected-flag']")).sendKeys(Keys.DOWN);
	}
		
	driver.findElement(By.xpath("//div[@class='selected-flag']")).sendKeys(Keys.ENTER);
	}
	
	
	@Test(priority=3,dataProvider = "exceldatatest", dataProviderClass = excelpoi.class )
	public static void relation(String FirstName, String LastName)
	{
	WebElement reltostudent = driver.findElement(By.id("id_family_emergency_contact_relationship"));
	Select options = new Select(reltostudent);
	options.selectByVisibleText("Mother");
	driver.findElement(By.id("id_student_first_name")).sendKeys(FirstName);
	driver.findElement(By.id("id_student_last_name")).sendKeys(LastName);
	driver.findElement(By.xpath("//label[@class='radioStyleLbl'][@for='id_student_gender_0']")).click();
	}
	
	@Test(priority=4)
	public static void birthday()
	{
	driver.findElement(By.xpath("//input[@id='id_student_birth_date']")).click();
	driver.findElement(By.xpath("//table[@class='dp_yearpicker dp_body']//following::tr//td[1]")).click();
	driver.findElement(By.xpath("//td[@class='dp_month_9']")).click();
	driver.findElement(By.xpath("//table[@class='dp_daypicker dp_body']//following::tr[2]//td[4]")).click();
	}
	
	@Test(priority=5)
	public static void schoolgrade() throws IOException
	{
	driver.findElement(By.id("id_student_age_groups_0")).click();		
	File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(sourcefile, new File("screenshots\\registerpage.png"));
	}
	
	@AfterClass
	public static void teardown()
	{
	driver.quit();
	}
	}
