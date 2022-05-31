package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	

	public static void capturescreenshotas(WebDriver driver,String screenshotName) throws IOException
	{
	
		File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss");
		String timestamp=sdf.format(d);
		File destination=new File("C:\\Users\\supri\\eclipse-workspace\\mavenSwaglasbs\\test-output\\Screenshot\\Testid" +" -"+screenshotName+" -"+timestamp+".jpeg");
		FileHandler.copy(screenshotfile, destination);
		
		
	}
public static String getdatafromexcelsheet(String Sheetname,int row,int cell) throws EncryptedDocumentException, IOException


{
	String data ;
	FileInputStream inputstream=new FileInputStream(".\\src\\main\\resources\\testdataaa\\super.xlsx");

	Workbook book=WorkbookFactory.create(inputstream);
	Sheet st=book.getSheet(Sheetname);
	Row rt=st.getRow(row);
	Cell cr=rt.getCell(cell);
	try
	{
		data=cr.getStringCellValue();
		System.out.println(data);
	}
catch(Exception e)
	{
	double dd=cr.getNumericCellValue();
	data=Double.toString(dd);
	}
return data;

}
}
