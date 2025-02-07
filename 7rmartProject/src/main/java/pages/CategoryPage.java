package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Category']")
	private WebElement categoryButton;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//input[@name='top_menu']")
	private WebElement showOnTopMenuYes;
	@FindBy(xpath = "//input[@value='yes' and @name='show_home']")
	private WebElement showOnLeftMenuYes;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	private WebElement categoryNameField;
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-warning\"]")
	private WebElement categoryResetButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement clickSearch;
	@FindBy(xpath = "//input[@placeholder='Category']")
	private WebElement enterSearchCategory;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement clickSearchButton;
	@FindBy(id = "imagePreview")
	private WebElement imagePreview;

	public void clickOnCategory() {
		categoryButton.click();
	}

	public void clickNewCategory() {
		newButton.click();
	}

	public boolean toChooseFile() {
		String projectPath = System.getProperty("user.dir");
		chooseFile.sendKeys(projectPath + "\\src\\test\\resources\\CategoryBook.png");
		return false;
	}

	public void enterValueOnCategoryNameField() {
		categoryNameField.sendKeys("NoteBooks");
	}

	public void clickOnResetButton() {
		categoryResetButton.click();
	}

	public void categorySearch() {
		clickSearch.click();
		enterSearchCategory.sendKeys("iphone");
		clickSearchButton.click();
	}

	public boolean imagePreviewOfCategory() {
		return imagePreview.isEnabled();
	}
}