package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	public WebDriver driver;
	
		private By email=By.cssSelector("[id='user_email']");
		private By password=By.cssSelector("[type='password']");
		private By login=By.cssSelector("[value='Log In']");
		private By forgotPassword=By.cssSelector("[href*='password/new']"); //href*- by using regular expression, you can just give a part of the text
																	//eg: password/new/index.php, you just input 'password/new.
	
		
		//forgotPassword method here is exposed to the Forgot Password class
		
	public ForgotPassword forgotPassword() 
	{
	driver.findElement(forgotPassword).click();	
	return new ForgotPassword(driver); //after  
	//Before ----> ForgotPassword fp=new ForgotPassword(driver); //The step in before is you created an object and return it which is not clean
	//			   return fp;
	//After -----> return new ForgotPassword(driver);			//You can just return the object with return new ForgotPassword(driver) without
																//....ForgotPassword return type coz it has been already declared at the method level: public ForgotPassword forgotPassword()
																//You must be wondering how to call the object because we dont give the object name
																//Do not worry, once you call this method to the other class, you can give any object name
	}															
	
	 
	public LoginPage(WebDriver driver) {    
		// This constructor is automatically created when we send driver in the argument of LoginPage Object in Homepage.Java class
		//Click on the error after sending the driver to the argument and click on Construct
		//We send the driver here so to give life to the driver here (to give the webdriver capability)
		//.....in Homepage class.
		// TODO Auto-generated constructor stub
		this.driver=driver; 
		// to differentiate between the driver in public WebDriver driver;	and public LoginPage(WebDriver driver)
		//formula: this.insidetheclass=outsidetheclass;
		}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	

	public WebElement getLogin() 
	{
		return driver.findElement(login);
	}
	
	
	
	
	
	
	

}
