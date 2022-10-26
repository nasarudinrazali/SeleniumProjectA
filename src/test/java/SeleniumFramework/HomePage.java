package SeleniumFramework;
import org.apache.logging.log4j.*;   //Kena import log4j manually klau tak nanti log4j tak keluar
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePage extends base  { // we use the extends keyword to call the methods in base.java class. This is an inheritance concept
	// xxxx extends (which class properties you want to use, in our case we want to use "base" class properties)
	
	
	public WebDriver driver; // so that the "driver" in driver=InitializeDriver(); is pointed to the local driver in public WebDriver driver (local copy driver); 
							//..... in order for parallel testing to work 
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver(); 
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));  // We dont have to rewrite the properties class, just inherit it from
		//.... base class ( we already declared properties class in base), just use the getPropertmethod	
		log.info("Navigation to Homepage");
	}

	
	@Test(dataProvider="getData")
	public void HomePage(String username, String password, String text) throws IOException
	{	
		
		//1) Type InitializeDriver(); , then add throws declaration
		//2) Since InitializeDriver() returns driver, then type driver=InitializeDriver(); you dont need to write Webdriver driver,
		//because it has been declared in base.class, just use the driver object
		
		//the class name where we want to call the method from. Then, for the return type, we type "driver"
		//Click on the error and add throw declaration
		
		driver.get(prop.getProperty("url"));  // We want to run the same test twice, that is why here is the second url
		
		LandingPage lp= new LandingPage(driver); // click  on the error and import from page object that we have created, then pass "driver" in the argument to send to the LandingPange.java
		LoginPage l=lp.getLogin();					//after that click on the error and click on "Create Constructor" so that this driver which has life wil be send to LandingPage.java
		//l kat sini is the object of LoginPage not Landing Page.                    
		
		//and Constructor will be automatically created  - we do this in order to give life to the driver in LandingPage.java
		
		
		
		LoginPage login= new LoginPage(driver); // click  on the error and import from page object that we have created, then pass "drive"r in the argument to send to the LoginPage.java
												//after that click on the error and click on "Create Constructor" so that this driver which has life wil be send to LoginPage.java
												//and Constructor will be automatically created  - we do this in order to give life to the driver in LoginPage.java
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		log.info(text);
		
	
		login.getLogin().click();	

		ForgotPassword ff=l.forgotPassword();  // ForgotPassword ff to catch the ForgotPassword object from Forgot Password class in pageOjects 
		
												// fp here is the object that we create and you can give any name
		
		ff.getEmail().sendKeys("asdsdd@gmail.com");
		ff.sendMeInstructions().click();
		System.out.println("Aku sayang Kamooo Test");
		System.out.println("Aku tidak WOIII");
		
		
	}											
	
		
		
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		
	}
	
		
	@DataProvider	
	public Object[][] getData()
			
	
	{
		//Row stands for how many data types the test should run 
		//Column stands for how many values per each test
		Object[][] data = new Object[2][3]; // You have to give the array size here eg. array size of 0,1 = 2 not 1.
		//0th row
		data[0][0]="restricteduser@gmailcom"; // give the index here (starts with 0_
		data[0][1]="1232323";
		data[0][2]="restricteduser";
		//1st row	
		data[1][0]="nonrestricteduser@gmai.com";
		data[1][1]="348478";
		data[1][2]="nonrestricteduser";
		
		return data;		
	}

}
	

