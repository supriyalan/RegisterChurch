package JavaPrograms;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class WindowHandle {

	public static void main(String[] args) {


		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to("https://www.amazon.com/");
		
		JavascriptExecutor google = (JavaScriptExecutor)driver;
		google.executeScript(new Window("https://www.google.com/"));
		
		
	}

}
