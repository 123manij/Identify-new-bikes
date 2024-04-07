package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SecondNewsPage extends BasePage{
WebDriver driver;
	
	//constructor
	public SecondNewsPage(WebDriver driver){
		super(driver);
	}
	
	//WebElement Locators
	
		@FindBy(xpath = "//div//p")
		List<WebElement> innerNews;
			
		@FindBy(xpath="//div[@data-automation-id='personaDetails']")
		WebElement associateDetailsStatus;
			
		@FindBy(xpath="//div//p//a")
		WebElement linkDisplayStatus;
			
		@FindBy(xpath="//button[@name='Share']")
		WebElement shareButtonStatus;
			
		@FindBy(xpath="//*[@id='title_text']")
		WebElement btn_innerNewsContent;
			
		@FindBy(xpath="//*[@data-automation-id='sp-socialbar-likedbymessage']//span[contains(@class,'ms-Button-label')]")
		WebElement btn_likes;
			
		@FindBy(xpath="//*[@data-automation-id='sp-socialbar-viewcount']")
		WebElement btn_views;
			
		@FindBy(xpath="//ul//button")
		List<WebElement> list_Share;
		
		//Action methods
		
		
		public List<String> innerNewsContent(){
			List<String> newsC = new ArrayList<String>();
			for(WebElement res: innerNews) {
				newsC.add(res.getText());
			}
				return newsC;
			}
		
		public void associateDetails(WebDriver driver) {
			Actions act = new Actions(driver);
			act.moveToElement(associateDetailsStatus).perform();
		}
		
		public boolean checkLinkDisplay() {
			try {
			boolean linkDisplay = linkDisplayStatus.isDisplayed();
			return linkDisplay;
			}
			catch(Exception e) {
				return false;
			}	
		}
		
		public boolean checkShareDisplay() {
			boolean shareDisplay = shareButtonStatus.isDisplayed();
			return shareDisplay;
		}
		
		public void clickShareButton() {
			shareButtonStatus.click();
		}
		
		public List<String> shareOptions(){
			List<String> optionList = new ArrayList<String>();
			clickShareButton();
			//List<WebElement> options = list_Share;
			for(WebElement res: list_Share) {
				optionList.add(res.getAttribute("name"));
			}
			return optionList;
		}
		
        public String[] clickInnerNews(WebDriver driver) throws InterruptedException {
			
			Actions act = new Actions(driver);
			act.moveToElement(btn_innerNewsContent).doubleClick().perform();
			
			boolean flag=false;
			while(flag==false){
				try{
//					Actions act = new Actions(driver);
					act.sendKeys(Keys.PAGE_DOWN).perform();
					if(btn_likes.isDisplayed() && btn_views.isDisplayed()) {
						flag = true;
					}
				}
				catch(Exception e){
					continue;
				}	
			}
			String likes = btn_likes.getText();
			String views = btn_views.getAttribute("aria-label");
			String likesCount[] = likes.split(" ");
			String viewsCount[] = views.split(" ");
			String likesAndViews[]= new String[2];
			likesAndViews[0]=likesCount[0];
			likesAndViews[1]=viewsCount[0];
			return likesAndViews;
		}
}
