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

public class validateNavigationBar extends base {
	
	
	public WebDriver driver;// so that the "driver" in driver=InitializeDriver(); is pointed to the local driver in public WebDriver driver; (local copy drive) 
	//..... in order for parallel testing to work 
	public static Logger log=LogManager.getLogger(validateNavigationBar.class.getName());   /// We use base class not validateNavigationBar class
	@BeforeTest																//because this class for log 4j inherits the driver capability
	public void initialize() throws IOException								//.....from "base" class	
	{
		driver=InitializeDriver(); 
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));  // We dont have to rewrite the properties class, just inherit it from
		//.... base class ( we already declared properties class in base), just use the getPropertmethod	
		log.info("Navigation to Homepage");
		
	}
	
	
	@Test
	public void validateNavigationBar() throws IOException
	{	
		
		LandingPage lp= new LandingPage(driver); 
		
		//To check the navigation bar is broken or not using another common assertion that is Assert.assertTrue
		//Is Displayed will return the boolean value. We will combine Assert.assertTrue with is Displayed method
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		
	}
	
	

}
