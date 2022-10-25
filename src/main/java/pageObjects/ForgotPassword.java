package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	
	public WebDriver driver;
	
		private By email=By.cssSelector("[id='user_email']");
		private By sendMeInstructions=By.cssSelector("[type='submit']");
		
		
	
	public ForgotPassword(WebDriver driver) {    
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
	
	
	public WebElement sendMeInstructions()
	{
		 return driver.findElement(sendMeInstructions);
	}

	
	
	
	
	
	
	

}
