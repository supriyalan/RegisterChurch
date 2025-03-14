package regchurch.registerchurch;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelpoi {

	@DataProvider(name="exceldatatest")
	@Test
	public static Object[][] excelpoitesting() throws IOException
	{
		
		File file = new File("C:\\Users\\lsupr\\eclipse-workspace\\registerchurch\\exceldata.xlsx");
		//System.out.println(file.exists());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		XSSFSheet sheet = excel.getSheet("one");
		
		int noofrows = sheet.getLastRowNum();
		int noofcols = sheet.getRow(1).getLastCellNum();
		System.out.println(noofrows+ "--" +noofcols);
		Object[][] data = new Object[noofrows][noofcols];
		for(int i=1;i<=noofrows;i++)
		{
			XSSFRow celldata = sheet.getRow(i);
			String FirstName = celldata.getCell(0).getStringCellValue();
			String LastName = celldata.getCell(1).getStringCellValue();
			System.out.println(FirstName+ " -- " +LastName);
			return data;
		}
		return data;
	}
	
}	
	
	
	
	
	//@DataProvider(name="exceldatatest")
	//@Test
	/*public static String[][] excelpoitesting() throws IOException
	{
		
		File file = new File("C:\\Users\\lsupr\\eclipse-workspace\\registerchurch\\exceldata.xlsx");
		//System.out.println(file.exists());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		XSSFSheet sheet = excel.getSheet("one");
		
		int noofrows = sheet.getPhysicalNumberOfRows();
		int noofcols = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[noofrows][noofcols];
		for(int i=1;i<=noofrows;i++) {
		for(int j=0;j<noofcols;j++) {
		System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		}
		System.out.println();
		}
		excel.close();
		fis.close();
		return data;
} */