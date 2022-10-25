package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	//The website we use for this project is: http://www.qaclickacademy.com/
	//We are going to store the locators inside the HomePage first
	
	//2 - Declare this so that we can use the driver object in //4
	
	public WebDriver driver;	
	
	//1 Create the object(s)
		private By Signin =By.cssSelector("a[href*='sign_in']");   
		// What is href* . how to use the regular expression
		
		private By title=By.cssSelector("div[class='text-center']"); //or (".text-center>h2")
		private By navBar= By.cssSelector("[class='nav navbar-nav navbar-right']"); //or ul[[class='nav navbar-nav navbar-right']
		private By header=By.cssSelector("div[class*='video-banner'] h3"); //for xpath= //div[class*='video-banner']/h3"
		
	public LandingPage(WebDriver driver) { 
		// This constructor is automatically created when we send driver in the argument of LoginPage Object in Homepage.Java class
		//Click on the error after sending the driver to the argument and click on Construct
				//We send the driver here so to give life to the driver here (to give the webdriver capability)
				//.....in Homepage class.
		// This will give life to the "driver" here.
			// TODO Auto-generated constructor stub
		
		this.driver=driver;  
		// to differentiate between the driver in public WebDriver driver;	and public LandingPage(WebDriver driver)
		//formula: this.insidetheclass=outsidetheclass;
		}

	//3 Create one method to pull out driver.findElement(Signin)
	public LoginPage getLogin()
	{
	//4	
		driver.findElement(Signin).click();
		LoginPage l=new LoginPage(driver);  
		
//Kita simpan objek lain dlamm ni
//Landing page ----> Login Page, mula2 kita dekat landing page, lepas tu kita akan dibawa ke Login Page
//So declare LoginPage Class kat sini, so dekat test tak payah nak declare LoginPage class lagi dekat test nanti just bagi Return Type dgn Object je
		return l; //return the "l" object so that we can call in the other class
	}				// Click on the error to change the return type to Login Page
					
	//Another way to write this:
	/*public LoginPage getLogin()
	{	
		driver.findElement(Signin).click();
		return new LoginPage(driver);
												//return the object so that we can call in the other class
	}*/	
					
	
	
	public WebElement getTitle()
	{
		
		return driver.findElement(title);
		
	}
	
	public WebElement getNavBar() 
	{
		
	return driver.findElement(navBar);	
		
		
	}
	
	public WebElement getHeader()
	{
		
		return driver.findElement(header);
		
	}
	
	
	
	//There are 2 ways access methods of other class
	//1)Inheritance
	//2)Create a object of that class and invoke the method(s) of that class
	
	//5, Create object of this class in the test java class in test folder to call the method(s) contained in this class.
	
	
		
	//If you want to send anything as an argument, you need a constructor
	
}
