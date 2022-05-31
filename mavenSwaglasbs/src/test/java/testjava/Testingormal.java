package testjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pom.Homepageswaglasbs;
import pom.Loginpageswaglasbs;

public class Testingormal {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		
		Loginpageswaglasbs loginpageswaglasbs =new Loginpageswaglasbs (driver);
		
		loginpageswaglasbs.sendusername("standard_user");
		loginpageswaglasbs.sendpass("secret_sauce") ;
		loginpageswaglasbs.clicklogin() ;
		
		Homepageswaglasbs homepageswaglasbs=new Homepageswaglasbs(driver);
		
		homepageswaglasbs.clickaddcart( driver) ;
		Thread.sleep(2000);
		String a2=driver.getCurrentUrl();
				//Assert.assertEquals("https://www.saucedemo.com/inventory.html",a2 );
	    if(a2.equals("https://www.saucedemo.com/inventory.html"))
	    {
	    	System.out.println("pass1");
	    }
	    else {
	    	System.out.println("fail1");
	    }
		homepageswaglasbs.clicthree(driver); 
		Thread.sleep(2000);
	homepageswaglasbs.cliclogout(driver);
		
		
		//2nd test
driver.navigate().to("https://www.saucedemo.com/");
		
		loginpageswaglasbs =new Loginpageswaglasbs (driver);
		loginpageswaglasbs.sendusername("standard_user");
		loginpageswaglasbs.sendpass("secret_sauce") ;
		loginpageswaglasbs.clicklogin() ;
		
		homepageswaglasbs=new Homepageswaglasbs(driver);
		Thread.sleep(2000);
		homepageswaglasbs.clicldrop(driver); 
		homepageswaglasbs.clickaddcart1(driver) ;
		
		String a1=driver.getCurrentUrl();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html",a1 );
		
		
	    if(a1.equals("https://www.saucedemo.com/inventory.html"))
	    {
	    	System.out.println("pass11");
	    }
	    else {
	    	System.out.println("fail11");
	    }
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    Thread.sleep(1000);
		homepageswaglasbs.clicthree(driver); 
		Thread.sleep(3000);
		homepageswaglasbs.cliclogout(driver);
		System.out.println("logout done");
		driver.close();
	}

}
