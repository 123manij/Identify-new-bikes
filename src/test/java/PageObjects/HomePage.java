package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//PageFactoryClass
public class HomePage extends BasePage{

		WebDriver driver;
		
		//constructor
		public HomePage(WebDriver driver){
			super(driver);
		}
		
		//WebElement Locators
	     
		@FindBy(xpath="//button[@type='button'][contains(@title,'Account manager')]") 
		WebElement btn_account;
		
		@FindBy(xpath="//div[ @id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']")
		WebElement view_newsDisplay;
		
		@FindBy(xpath="//div[@role='listitem' and contains(@class,'e_a_37591358')]//a[@data-automation-id='newsItemTitle']")
		List<WebElement> list_news;
		
		@FindBy(xpath="//div[@role='listitem' and contains(@class,'e_a_37591358')][1]//a[@data-automation-id='newsItemTitle']")
		WebElement link_FirstNews;
		
		@FindBy(xpath="//div[@role='listitem' and contains(@class,'e_a_37591358')][2]//a[@data-automation-id='newsItemTitle']")
		WebElement link_SecondNews;
		
		@FindBy(xpath="//div[@role='listitem' and contains(@class,'e_a_37591358')][3]//a[@data-automation-id='newsItemTitle']")
		WebElement link_ThirdNews;
		
		@FindBy(xpath="//div[@role='listitem' and contains(@class,'e_a_37591358')][4]//a[@data-automation-id='newsItemTitle']")
		WebElement link_FourthNews;
		
		//Action methods
		
		public void clickAccountButton() {
			btn_account.click();
		}
		
		public boolean checkNewsDisplayed() {
			boolean newsDisplayStatus=view_newsDisplay.isDisplayed();
			return newsDisplayStatus;
		}
		
		public boolean checkTooltipStatus() {
			boolean tooltipStatus=((list_news.get(0).getAttribute("title").equals(list_news.get(0).getText())) && (list_news.get(1).getAttribute("title").equals(list_news.get(1).getText())) && (list_news.get(2).getAttribute("title").equals(list_news.get(2).getText())) && (list_news.get(3).getAttribute("title").equals(list_news.get(3).getText())));
		    return tooltipStatus;
		}
		
		
		public void clickFirstNews() {
			link_FirstNews.click();
		}
		
		public void clickSecondNews() {
			link_SecondNews.click();
		}
		
		public void clickThirdNews() {
			link_ThirdNews.click();
		}
		
		public void clickFourthNews() {
			link_FourthNews.click();
		}
}
