package windowhandles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BorkenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		List<WebElement> listoflinks = driver.findElements(By.xpath("//a"));

		for(int i =0;i<listoflinks.size();i++) {
			String linkis = listoflinks.get(i).getText();
			String url = listoflinks.get(i).getAttribute("href");
			System.out.println(linkis + url);
			
		}
		

		driver.quit();
	

	}
	
	
	public static void brokenlinks() throws MalformedURLException, IOException, URISyntaxException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		List<WebElement> listoflinks = driver.findElements(By.xpath("//a"));

		for(WebElement link : listoflinks ) {
			
			String url = link.getAttribute("href");
			if(url ==null) {
				System.out.println("URL is empty" +url);
			}
			else 
			{
				HttpURLConnection huc = (HttpURLConnection)(new URI(url).toURL().openConnection());
				huc.connect();	
				if(huc.getResponseCode()>=400) {
				System.out.println( "url is broken" +url);
			}
		}

		driver.quit();
	}
	}
	
	public static void brokenImages() throws MalformedURLException, IOException, URISyntaxException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		 List<WebElement> allimages = driver.findElements(By.tagName("img"));
		 for(WebElement img : allimages)
		 {
			 System.out.println(img.getText());
		 }
		 
		 for(WebElement image : allimages) {
			 String imageurl = image.getAttribute("src");
			 
			 if(imageurl==null) {
				 System.out.println(imageurl+ "is null");
			 }
			 else {
				 HttpURLConnection huc = (HttpURLConnection)(new URI(imageurl).toURL().openConnection());
				 huc.connect();
				 if(huc.getResponseCode()>400) {
					 System.out.println(imageurl+ " is broken");}
					 
				 }
			 }	
		 }
}