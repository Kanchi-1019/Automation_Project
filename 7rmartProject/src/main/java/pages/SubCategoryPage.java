package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
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
	@FindBy(xpath = "//select[@id='un']")
	private WebElement selectCategory;
	@FindBy(id="subcategory")
	private WebElement enterName;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement newAddAlert;
	@FindBy(xpath = "//td[text()='Toys']")
	private WebElement searchItem;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement selectCategory1;

	public void clickOnSubCategory() {
		subCategoryClick.click();
	}

	
	public void clickOnSearchButtonOfSubCategory() {
		searchSubCategory.click();
	}

	public void selectSubCategory(String item) {
		Select select = new Select(selectSearch);
		select.selectByVisibleText(item);
	}
	public void selectCategoryToAddSubCategory(String item)
	{
		Select select=new Select(selectCategory1);
		select.selectByVisibleText(item);
	}

	public void submitSearch() {
		submitSearch.click();
	}

	public void clickOnNewButton() {
		clickNew.click();
	}

	public void selectCategoryFromList(String categorySelect) {
		Select select = new Select(selectCategory);
		select.selectByVisibleText(categorySelect);
	}

	public void enterSubCategoryName(String subcategory) {
		enterName.sendKeys(subcategory);
	}

	public void toChooseFile() throws FileNotFoundException {
		
		chooseFile.sendKeys(Constants.IMAGEDATAFILE);

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
