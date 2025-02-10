package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Manage News']")WebElement manageNewsButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath="//textarea[@id=\"news\"]")WebElement news;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement saveButton;
	
	public void clickOnTheManageNews()
	{
		manageNewsButton.click();
	}
	public void clickOnTheNewButton()
	{
		newButton.click();
	}
	public void enterNewsOnTheNewsField(String enterNews)
	{
		news.sendKeys(enterNews);
	}
	public void clickOnTheSaveButton()
	{
		saveButton.click();
	}
	
	

}
