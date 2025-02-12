package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")private  WebElement clickAdminUser;
	@FindBy(xpath="//p[text()='Manage Users']")private  WebElement clickManageUser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private  WebElement clickNew;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private  WebElement clickSearch;
	@FindBy(xpath="//input[@id='username']")private  WebElement inputNewUserName;
	@FindBy(xpath="//input[@id='password']")private WebElement inputNewPassword;
	@FindBy(xpath="//select[@id='user_type']")private WebElement selectNewUserType;
	@FindBy(xpath="//button[@name='Create']")private WebElement saveButton;
	@FindBy(xpath="//input[@name='un']")private WebElement inputSearchUsername;
	@FindBy(xpath="//select[@id='ut']")private WebElement selectSearchType;
	@FindBy(xpath="//button[@value='sr']")private WebElement searchButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertNewAdminUser;
	
	
	public void clickOnTheAdminUserOnSideBar()
	{
		clickAdminUser.click();
	}
	public void clicktheMangeUserFromAdminUserList()
	{
		clickManageUser.click();
	}
	public void clickOnTheNewButtonOnManageUser()
	{
		clickNew.click();
	}
	public void inputUsernameInNewAdminUserNameField(String newAdminUsername)
	{
		inputNewUserName.sendKeys(newAdminUsername);
	}
	public void inputPasswordInNewAdminPasswordField(String newAdminPassword)
	{
		inputNewPassword.sendKeys(newAdminPassword);
	}
	public void selectUserTypeOfNewAdminUser(String value)
	{
		Select select=new Select(selectNewUserType);
		select.selectByValue(value);
	}
	public void saveNewAdminUser()
	{
		saveButton.click();
	}
	public void clickOnSearchButtonToSearch()
	{
		clickSearch.click();
	}
	public void inputTheSearchUsername(String searchUsername)
	{
		inputSearchUsername.sendKeys(searchUsername);
		
	}
	public void selectUserTypeToSearch(String value)
	{
		Select select=new Select(selectSearchType);
		select.selectByValue(value);
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public boolean alertForNewAdminUser()
	{
		return alertNewAdminUser.isDisplayed();
	}
}
