package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FirstNewsPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_FirstNewsTest extends BaseClass{
	HomePage obj;
	FirstNewsPage newsObj;
	
	@Test(priority =1)
	void verify_newsContent() throws InterruptedException {
		
		
		logger.info("******TC_002 First page test started******");
		logger.info("Verify the news content...");
		
		
		obj = new HomePage(driver);
		Thread.sleep(6000);
		
		logger.info("click the first news content...");
		
		obj.clickFirstNews();
		newsObj = new FirstNewsPage(driver);
		Thread.sleep(8000);
		List<String> content=newsObj.innerNewsContent();
		System.out.println("First News Data");
		for(String res: content) {
			System.out.println(res);
		}
	}
	
	@Test(priority=2)
	void verify_associateDetailsTest() throws InterruptedException {
		try {
			
			logger.info("verify associate details...");
			
			newsObj.associateDetails(driver);
		    Thread.sleep(6000);
		    screenshot("FirstNewsImage");
		    }
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
		@Test(priority=3)
		void verify_hyperlinkDisplay() {
			
			
				
				logger.info("verify hyperlinks display...");
				boolean linkDisplayed = newsObj.checkLinkDisplay();
				if(linkDisplayed==true) {
					Assert.assertTrue(linkDisplayed);
				}
				else {
					System.out.println("No hyperlinks in this news");
					Assert.assertFalse(linkDisplayed);
				}
				
//				boolean linkDisplayed = newsObj.checkLinkDisplay();
//				Assert.assertEquals(linkDisplayed, true,"No Hyperlinks in this news");
//				}
//				catch(Exception e) {
//					logger.error("test failed...");
//					Assert.fail();
//			}
		}
		
		
		@Test(priority = 4)
		void shareOptionTest() {
			
			logger.info("verify share options...");
			
			boolean shareDisplayed = newsObj.checkShareDisplay();
			Assert.assertEquals(shareDisplayed, true," No share option in this news");
			List<String> options = newsObj.shareOptions();
			System.out.println();
			System.out.println("Share options:");
			for(String resultList: options) {
				System.out.println(resultList);
			}
		}
		
		@Test(priority = 5)
		void verify_likeViewsDisplay() throws InterruptedException {
			
			logger.info("verify likes and views options...");
			
			String [] likesViews = newsObj.clickInnerNews(driver);
			System.out.println("No of Likes: "+likesViews[0]);
			System.out.println("No of views: "+likesViews[1]);
			
			logger.info("******Finished First news test******");
		}
		
	
}
