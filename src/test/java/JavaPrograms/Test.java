package JavaPrograms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.com/");
		
		WebElement allselect = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
		
		Select sel = new Select(allselect);
		
		List<WebElement> options = sel.getOptions();
		int size = options.size();

for(int i=0;i<size;i++)
{
	
	System.out.println(options.get(i).getText());
	if(options.contains("Amazon Pharmacy"))
	{
		
	}
}
		
		
		
	}

}
