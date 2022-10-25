package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class StepDefinitionImpl extends base  { //we will inherit the properties from base class
	
	@Given("I landed on Login Page")     
	
	//"I landed on Login Page" from the .feature and paste in the argument of @Given
	//Type @Given annotation and import Cucumber
										//The texts after the @Given annotation, must follow
	public void I_landed_On_Login_Page() throws IOException //.... the texts what have defined in .feature file 
										//....so that they can match with the texts in .feature file
	{	
		driver=InitializeDriver();		
		driver.get(prop.getProperty("url"));
	}
	
	
	//From @Given("Enter <email> and <password>")
	//To --->@Given("Enter <.+> and <.+>")
	//You cannot use <email> and <password> because it will find the exact match of the name
	//We want the values <email> and <password>
	//In order to receive the value in any format e.g String,Integer,etc, use regex:  ".+"
	//The values will be received from .feature file
	//The values such as email and password from .feature file will go to the regex
	

	@Given("^Enter username (.+) and password (.+)$") 
	public void Enter_username_and_password(String username, String password)   
	{
		LandingPage landPage=new LandingPage(driver);
		landPage.getLogin();
		LoginPage l=new LoginPage(driver);
		l.getEmail().sendKeys(username);;
		l.getPassword().sendKeys(password);

		
	}
	
	@When("I click on Login button")
	public void I_click_on_Login_button()
	{
		LoginPage l=new LoginPage(driver);
		l.getLogin().click();	
	}
	
	
	
	
	
	
	
}
