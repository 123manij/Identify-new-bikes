package testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
 
public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Becognizant Automation Report"); // Title of report
		sparkReporter.config().setReportName("Becognizant Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","Becognizant");
		extent.setSystemInfo("Testers Name","Lakshmi,Bhavya,Meha,Manoj");
		extent.setSystemInfo("Browser name","Chrome,Edge");
		extent.setSystemInfo("OS","Windows 10");
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,result.getName()+" test executed successfully");
		
		
}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL,result.getThrowable()+" test failed");
		String imgpath=BaseClass.takeScreenshot(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP,result.getThrowable()+" test skipped");
}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
}
}