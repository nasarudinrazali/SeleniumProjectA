package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class base {
	
	public static WebDriver driver; 
// You declare the driver object  and its return type here globally so that you do not have to repeat Webdriver driver for Chrome/Firefox/Edge
// After declaring  WebDriver driver, just reuse the driver object
// If you declare Webdriver driver for every block of the loop (Chrome,firefox,Edge) the scope of the driver you define
//... is only limited to that particular browser driver, the scope will die outside the the loop but when we define
//... public WebDriver driver, the scope of the driver will be applied globally.
	
	public Properties prop; // We declare outside of the method so that it can be inherited to other clasess
	
// When the access modifier is public, it can be accessed throughout the java class and outside of this java class
	
	public WebDriver InitializeDriver() throws IOException
		{
		prop=new Properties(); //Properties class is declared outside the class, we will use methods in this class to pull out data from data.properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\dean razali\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//FileInputStream class, we use this class to read the data in data.properties file.
		prop.load(fis);
		String browserName=prop.getProperty("browser"); //call the properyt named "browser" in the data.properties file
		System.out.println(browserName);
		
		
		if(browserName.contains("chrome"))  //we use contains because it is boolean and because we have another condition below in the same block
		{
//"==" should be used during reference comparison. (in the same memory allocation)
//equals() method should be used for content comparison. equals() method evaluates the content to check the equality.	
// chrome is the value of the property named "browser" in data.properties file// you cannot use if(browserName=="chrome") on property-value
//Instead we use browserName.equals("chrome") to extract value from a property
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dean razali\\Desktop\\Chrome.Gecko,Edge drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) //if the chrome has headless =chromeheadless, headless will be executed
			{
				options.addArguments("headless");
			}
		
		driver=new ChromeDriver(options);	//No more Webdriver driver because we have declared the driver object globally and its return type above
		//Execute in chrome driver
		}
		else if(browserName.equals("firefox")) //we use equal because it is only one condition.
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dean razali\\Desktop\\Chrome.Gecko,Edge drivers\\geckodriver\\msedgedriver.exe");
		driver=new FirefoxDriver();//No more Webdriver driver because we have declared the driver object globally and its return type above
			//Execute firefox driver  //Assignment
		}
		else if(browserName.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dean razali\\Desktop\\Chrome.Gecko,Edge drivers\\edgedriver.exe");
		driver=new EdgeDriver(); //No more Webdriver driver because we have declared the driver object globally and its return type above
		//Execute edge driver	//Assignment
		}
		
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//We use Duration.ofSeconds because TimeUnit.Seconds are deprecated
		return driver;  // You have to return the driver in this method so that this method can be called from ther classes
						//Move your mouse to the error and click change the return type to Webdriver
			
		}
		
	
	//Screenshot method
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException // Add Webdriver driver so that it expects the driver from TestNG Listener
	{
	TakesScreenshot ts=(TakesScreenshot)driver;  //variable responsible to take the screenshot
	File source=ts.getScreenshotAs(OutputType.FILE); 
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileHandler.copy(source,new File(destinationFile));
	
	return destinationFile;
	
	//Click on FileHandler.... error and click on add throws IOException
		
		
	
		
}

}
