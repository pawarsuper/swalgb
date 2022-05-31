package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepageswaglasbs {

	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	private WebElement addtocart;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement threeline;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	private WebElement logout;
	
	//dropdown
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement dropdown;
	
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	private WebElement addtocart1;
	
	public Homepageswaglasbs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickaddcart(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(addtocart).click().build().perform();
	}
	
	public void clicthree(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(threeline).click().build().perform();
	}
	
	public void cliclogout(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(logout).click().build().perform();
	}

	public void clicldrop(WebDriver driver) 
	{
		Select s=new Select(dropdown);
		s.selectByIndex(2);
	}
	
	public void clickaddcart1(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(addtocart1).doubleClick().build().perform();
	}
	
}
