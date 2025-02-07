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

	public void clickOnLogout() {
		Logout.click();
	}

	public void clickOnAdminButton() {
		adminDropDown.click();
	}

	public void clickOnSettings() {
		settings.click();
	}

	public void clickOnDashBoard() {
		dashBoard.click();
	}

	public boolean isManageProductIsDisplayed() {
		return rR1.isDisplayed();
	}

}