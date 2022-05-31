package testjava;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Base;
import pom.Homepageswaglasbs;
import pom.Loginpageswaglasbs;
import utils.Utility;

public class TestNgprac {
	WebDriver driver;
	Homepageswaglasbs homepageswaglasbs;
	Loginpageswaglasbs loginpageswaglasbs;
	int row=0;
	int cell=0;
	int Testid;
	@Parameters("browsername")
	@BeforeTest
	public void launchBrowser(String browser) 
	{
		System.out.println(browser);
		if(browser.equals("Chrome")) 
		{
			driver=Base.openChromeBrowse();
		}
		
		if(browser.equals("Firefox")) 
		{
			driver=Base.openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@BeforeClass
	 public void launchbrowser() 
	 {
		homepageswaglasbs=new Homepageswaglasbs(driver);
		loginpageswaglasbs =new Loginpageswaglasbs (driver);
		
	 }
	
	@BeforeMethod
	public void loginpage() throws EncryptedDocumentException, IOException
	{
driver.navigate().to("https://www.saucedemo.com/");
		
		String data=Utility.getdatafromexcelsheet("Sheet1", row=0,cell= 0);
		loginpageswaglasbs.sendusername(data);
		
		data=Utility.getdatafromexcelsheet("Sheet1",row= 0,cell= 1);
        loginpageswaglasbs.sendpass(data) ;
        
		loginpageswaglasbs.clicklogin() ;
		
	
		}
	
	@Test
	public void verifyaddcart() throws InterruptedException
	{
		Testid=1001;
		homepageswaglasbs.clickaddcart( driver) ;
		Thread.sleep(2000);
		
		String a2=driver.getCurrentUrl();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html",a2 );

	}
	
	@Test
	public void verifydrop()
	{
		Testid=1002;
		homepageswaglasbs.clicldrop(driver); 
		homepageswaglasbs.clickaddcart1(driver) ;
		String a1=driver.getCurrentUrl();
		Assert.assertEquals("https://www.saucedemo.com/inventory.htmp",a1 );
      Assert.fail();
	}
	
	@AfterMethod
	public void verifylogout(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.capturescreenshotas(driver, result.getName());
		}
		homepageswaglasbs.clicthree(driver); 
		Thread.sleep(3000);
		homepageswaglasbs.cliclogout(driver);
	}
	
	@AfterClass
	public void clearbrowesr()
	{
		loginpageswaglasbs=null;
		homepageswaglasbs=null;
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}

}
