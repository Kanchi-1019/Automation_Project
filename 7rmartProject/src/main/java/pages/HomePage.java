package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement clickAdminUser;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminDropDown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement Logout;
	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	private WebElement settings;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	private WebElement dashBoard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement heading;
	@FindBy(xpath = "//a[@class='nav-link']")
	private WebElement rR1;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")private WebElement categoryPageClick;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement manageNewsButton;
	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategoryClick;

	public HomePage clickOnLogout() {
		Logout.click();
		return this;
	}

	public HomePage clickOnAdminButton() {
		adminDropDown.click();
		return this;
	}
	public AdminUserPage clickOnTheAdminUserOnSideBar() {
		clickAdminUser.click();
		return new AdminUserPage(driver);
	}
	public CategoryPage clickOnCategoryPage()
	{
		categoryPageClick.click();
		return new CategoryPage(driver);
	}
	public ManageNewsPage clickOnTheManageNews() {
		manageNewsButton.click();
		return new ManageNewsPage(driver);
	}
	public SubCategoryPage clickOnSubCategory() {
		subCategoryClick.click();
		return new SubCategoryPage(driver);
	}


	

	
	
}