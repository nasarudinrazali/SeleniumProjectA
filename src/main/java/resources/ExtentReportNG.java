package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent; //declare ExtentReports class extent globally
	
	
	public static ExtentReports getReportObject() {
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";  //Create the path first and store it in a variable
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);     		//Then give the path as an argument of the ExtentSparkReporter class
		reporter.config().setReportName("Web Automation Results");				//Configure
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent= new ExtentReports();  // This the class that is responsible to execute the Extent Reports // Remove ExtentReports data type when  you have declared the ExtentReportClass globally
		extent.attachReporter(reporter);  //give the "reporter variable" where the configurations are present it
		extent.setSystemInfo("Tester", "Yumika");  // give the tester a name
		return extent;
		
		
	}
	

}
