package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageswaglasbs {
	@FindBy(xpath="//input[@data-test='username']")
	private WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	public Loginpageswaglasbs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendusername(String user) 
	{
		username.sendKeys(user);
	}

	public void sendpass(String pass) 
	{
		password.sendKeys(pass);
	}

	public void clicklogin() 
	{
		login.click();
	}

}
