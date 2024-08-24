package windowhandles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshot {

	static ChromeDriver driver = new ChromeDriver();
	
	public static String getscreenshot(String[] args)
	{
		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.google.com/"); */
		
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Destinationfile = ("screenshots\\screenshot0000.png");
		try {
			FileHandler.copy(sourcefile, new File(Destinationfile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Destinationfile;

	}

}
