package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	
	//public static ChromeDriver driver;
    public ExtentTest test;
 	public static Properties prop;
 	public static WebDriver driver;


	public static WebDriver initialiseBrowser(String browsername)
	{

		if(browsername.equalsIgnoreCase("Chrome")){
		 driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("Safari")){
		driver = new SafariDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("googleurl"));
		return driver;
	}

	
	
	  public String captureScreenshot(ChromeDriver driver, String testname) {
		    File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String destination = System.getProperty("user.dir") + "/screenshots/" + testname + System.currentTimeMillis() + ".png";
		    try {
		        FileUtils.copyFile(source, new File(destination));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return destination;
		   	}
	  
	  /*
	   *   public String captureScreenshot(WebDriver driver, String methodName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        String path = "screenshots/" + methodName + "_" + System.currentTimeMillis() + ".png";
	        File dest = new File(path);
	        src.renameTo(dest);
	        return path;
	    }
	   */

	public static ExtentReports extentreporting()
	{
		File file = new File(System.getProperty("user.dir")+"//src/test/java//ExtentReports//ExtentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
   	   	spark.config().setDocumentTitle("Automation Test Report");
   	 	spark.config().setReportName("Selenium Test Results");
   	 	spark.config().setTheme(Theme.STANDARD);
   	 	ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "Supriya");
        return extent;
	}
	  
	@DataProvider(name = "datatogooglesearch")
	public Object[][] googleData() throws IOException
	{
		
		File file = new File("C:\\Users\\lsupr\\eclipse-workspace\\registerchurch\\src\\test\\java\\dataConfig\\googledata.xlsx");
		//System.out.println(file.exists());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		XSSFSheet sheet = excel.getSheet("one");
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rows+ "--" +cols);
		Object[][] data = new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
		return data;
			}
	
	
	public static void callingPropertyFile() throws IOException
	{
		try {
			prop = new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fis = new FileInputStream("C:\\Users\\lsupr\\eclipse-workspace\\registerchurch\\src\\test\\java\\dataConfig\\data.properties");
        prop.load(fis);
        fis.close();
	}
	
	}
	

