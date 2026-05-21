package anandtomracademy.globalresources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreportstest {

	public static ExtentReports Extentreportstest() {
		
		// TODO Auto-generated constructor stub
		 	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	        reporter.config().setReportName("Automation results");
	        reporter.config().setDocumentTitle("Test Results");
	        
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Anand");
	        return extent;
	}

}
