package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Sub_CategoryPage {
	public WebDriver driver;

	public Sub_CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategoryClick;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement deleteIcon;
	@FindBy(xpath = "//a[@href=\"javascript:void(0)\"]")
	private WebElement searchSubCategory;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement selectSearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement submitSearch;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement clickNew;
	@FindBy(xpath = "//select[@name='cat_id']")
	private WebElement selectCategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement enterName;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement newAddAlert;
	@FindBy(xpath="//td[text()='Toys']")private WebElement searchItem;
	

	public void clickOnSubCategory() {
		subCategoryClick.click();
	}

	public void clickOnDeleteButton() {
		deleteIcon.click();
	}

	public void clickOnSearchButtonOfSubCategory() {
		searchSubCategory.click();
	}

	public void selectSubCategory() {
		Select select = new Select(selectSearch);
		select.selectByVisibleText("Toys");
	}

	public void submitSearch() {
		submitSearch.click();
	}

	public void clickOnNewButton() {
		clickNew.click();
	}

	public void selectCategoryFromList() {
		Select select = new Select(selectCategory);
		select.selectByVisibleText("iphone");
	}

	public void enterSubCategoryName() {
		enterName.sendKeys("Iphone 16series");
	}

	public void toChooseFile() {
		String projectPath = System.getProperty("user.dir");
		chooseFile.sendKeys(projectPath + "\\src\\test\\resources\\Sub_CategoryImage.jpg");
	}

	public void clickOnSaveButton() {
		saveButton.click();

	}

	public boolean isSubCategoryisDisplayed() {
		return subCategoryClick.isDisplayed();
	}

	public boolean newAddAlertDisplayed() {
		return newAddAlert.isDisplayed();
	}

	public boolean isSubmitButtonDisplayed() {
		return submitSearch.isDisplayed();
	}

	public boolean isitemDisplayed() {
		return searchItem.isDisplayed();
	}

}
