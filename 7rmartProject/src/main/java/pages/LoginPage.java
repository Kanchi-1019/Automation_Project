package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;

	public void enterUsernameOnUsernameField(String username1) {
		username.sendKeys(username1);
	}

	public void enterPasswordOnPasswordField(String password1) {
		password.sendKeys(password1);
	}

	public LoginPage clickOnSigninButton() {
		WaitUtility wait=new WaitUtility();
		wait.waitUntilTheElementToBeClickable(driver,signInButton);
		signInButton.click();
		return new LoginPage(driver);
	}

	public boolean isAlertDisplayed() {

		return alert.isDisplayed();
	}

	public boolean isDashboardisDisplayed() {
		return dashboard.isDisplayed();
	}
	
}
