package windowhandles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TryingLocators {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://parsippanybaptist.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		//driver.findElement(By.xpath("//a[@aria-label='Search Labs']")).click();
		String text = driver.findElement(By.xpath("(//div[@class='h2 font-def-heading2'])[1]")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("//div[@class='footer-text']")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("(//a[@href=\"/events\"])[1]")).click();
		driver.findElement(By.linkText("Subscribe to Calendar")).click();
		//Actions act = new Actions(driver);
		//act.sendKeys(Keys.ESCAPE).perform();
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ESCAPE);
		robo.keyRelease(KeyEvent.VK_ESCAPE);
		
		
	}

}
