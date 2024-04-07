package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_HomepageNewsTest extends BaseClass{
	
	HomePage obj;
		
		  @Test(priority=1)
		  void verify_userDetails() throws InterruptedException {
			  
			  logger.info("******TC_001 Homepage test started******");
			  logger.info("Verify the user details...");
			  
			  obj=new HomePage(driver);
			  Thread.sleep(10000);
			  
			  logger.info("Click the Account details button");
			  obj.clickAccountButton();
			  //Thread.sleep(2000);
			  System.out.println("User Information:");
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
					WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mectrl_currentAccount_primary")));
					System.out.println("User Name: "+ele.getText());
					WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(6));
					WebElement ele2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("mectrl_currentAccount_secondary")));
					System.out.println("Email id: "+ele2.getText());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		  }
	  
	  
		  @Test(priority = 2)
		   void verify_newsDisplay() {
			  
			  logger.info("Verify the news display...");
			  
			  boolean newsDisplay = obj.checkNewsDisplayed();
			  Assert.assertEquals(newsDisplay, true, "News are not displayed");
		  }
		  
		  
		  @Test(priority = 3)
		  void verify_tooltipTest() {
			  
			  logger.info("Verify whether the tooltip and title are same...");
			  
			  boolean tooltipStatus = obj.checkTooltipStatus();
			  Assert.assertEquals(tooltipStatus, true, "Tooltip text are not same");
		  }
	  

}
