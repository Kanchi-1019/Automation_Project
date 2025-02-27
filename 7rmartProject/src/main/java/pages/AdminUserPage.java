package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement clickManageUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNew;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement clickSearch;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement inputNewUserName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement inputNewPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectNewUserType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement inputSearchUsername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement selectSearchType;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertNewAdminUser;
	
	
	PageUtility page = new PageUtility();
	
	public AdminUserPage clicktheMangeUserFromAdminUserList() {
		clickManageUser.click();
		return this;
	}

	public AdminUserPage clickOnTheNewButtonOnManageUser() {
		clickNew.click();
		return this;
	}

	public AdminUserPage inputUsernameInNewAdminUserNameField(String newAdminUsername) {
		inputNewUserName.sendKeys(newAdminUsername);
		return this;
	}

	public AdminUserPage inputPasswordInNewAdminPasswordField(String newAdminPassword) {
		inputNewPassword.sendKeys(newAdminPassword);
		return this;
	}

	public AdminUserPage selectUserTypeOfNewAdminUser(String value) {
		
		page.selectDropdownWithValue(selectNewUserType, value);
		return this;
		
	}

	public AdminUserPage saveNewAdminUser() {
		saveButton.click();
		return this;
	}

	public AdminUserPage clickOnSearchButtonToSearch() {
		clickSearch.click();
		return this;
	}

	public AdminUserPage inputTheSearchUsername(String searchUsername) {
		inputSearchUsername.sendKeys(searchUsername);
		return this;

	}

	public AdminUserPage selectUserTypeToSearch(String value) {
		page.selectDropdownWithValue(selectSearchType, value);
		return this;

	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public boolean alertForNewAdminUser() {
		return alertNewAdminUser.isDisplayed();
	}
}
