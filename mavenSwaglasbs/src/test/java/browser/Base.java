package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromeBrowse() 
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\supri\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\browsersss\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() 
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\supri\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\browsersss\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}


}
