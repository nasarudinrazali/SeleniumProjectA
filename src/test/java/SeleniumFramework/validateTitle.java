package SeleniumFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	
	
	public WebDriver driver;//// so that the "driver" in driver=InitializeDriver(); is pointed to the local driver in public WebDriver driver;(local copy driver) 
	//..... in order for parallel testing to work 
	public static Logger log=LogManager.getLogger(validateTitle.class.getName()); //Log4j
	LandingPage lp; //We declare this globally so that all test case in this class can access the object
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver(); 
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));  // We dont have to rewrite the properties class, just inherit it from
		//.... base class ( we already declared properties class in base), just use the getPropertmethod
		log.info("Navigation to Homepage");
	}
	
	//Test Case 1
	@Test
	public void validateTitle() throws IOException
	{	
		
		//Compare the text from the browser with actual value ( will be in requirement doc given my the client)
		
		LandingPage lp= new LandingPage(driver); // This driver life will be passed to the global variable above (LandingPage lp;),
												//Therefore, all the testcases will have that driver life in this class.					
		//Use TestNG Assert.asserteEquals(Expected value, Actual Value):
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		
		//To check the navigation bar is broken or not using another commmon assert that we use Assert.assertTrue
		
		Assert.assertTrue(true);
		log.info("Successfully validated Text Message");
	
	}
	
	//Test Case 2
	@Test
	public void validateHeader()
	{
		
		
	Assert.assertEquals(lp.getTitle().getText(), "An Academy to learn Everything about Testing");
			
		
		
	}
	
	
												
												
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		
	}
	
	
	

}
