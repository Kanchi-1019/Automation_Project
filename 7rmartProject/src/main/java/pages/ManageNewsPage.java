package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id=\"news\"]")
	WebElement news;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;

	public ManageNewsPage clickOnTheNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNewsOnTheNewsField(String enterNews) {
		news.sendKeys(enterNews);
		return this;
	}

	public ManageNewsPage clickOnTheSaveButton() {
		WaitUtility wait = new WaitUtility();
		saveButton.click();
		wait.waitUntilTheElementToBeClickable(driver, saveButton);
		return this;
	}

	public boolean alertForNewMsgAdd() {
		return alertMsg.isDisplayed();
	}

}
