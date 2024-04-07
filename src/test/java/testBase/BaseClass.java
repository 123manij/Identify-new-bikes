package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Properties p;
	public static TakesScreenshot ts;
	public Logger logger;
	
	 @BeforeClass
	 @Parameters({"browser"})
	  public void setUp(String brName) throws InterruptedException, IOException {
		 
		 //Loading log4j2 file
		 logger=LogManager.getLogger(this.getClass());
		 
		  FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		  p = new Properties();
		  p.load(file);
		 
		 if(brName.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
		 
//		  Thread.sleep(5000);
		 }
		 else if(brName.equalsIgnoreCase("edge")){
			  driver = new EdgeDriver();
			
		 }
		 driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  ts=(TakesScreenshot) driver;
		  driver.get(p.getProperty("appURL"));
     }
	
	 @AfterClass
	  public void tearDown() {
		  driver.quit();
	  }
	 
	 public void screenshot(String name) throws IOException {
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String destination = System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		 File target=new File(destination);
		 FileUtils.copyFile(source, target);
		 
	 }
	 public static String takeScreenshot(String fname) {
			// TODO Auto-generated method stub
		 
				
				File source = ts.getScreenshotAs(OutputType.FILE);
				String destination = System.getProperty("user.dir")+"\\screenshots\\"+fname+".png";
				File target=new File(destination);
				source.renameTo(target);
			    return destination;
	
}
}
