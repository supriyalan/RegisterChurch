package regchurch.registerchurch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {

	@Test
	public void dropdowns() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("trump");
		List<WebElement> dropdownvalues = driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]"));
		for(WebElement value : dropdownvalues)
		{
			if(value.getText().equalsIgnoreCase("trump putin"))
			{
				value.click();
				break;
			}
			
		}
		
		
	}
}
