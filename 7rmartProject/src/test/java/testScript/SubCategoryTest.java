package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public HomePage homePage;
	public SubCategoryPage subCategory;

	@Test(description = "User can able to Select SubCategory from Search List using category and Subcategory name", priority = 1)
	public void selectSubCategoryFromSearchListUsingCategoryAndSubCategoryName() throws IOException {

		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categorySelect = ExcelUtility.getStringData(1, 0, "Sub_CategoryPage");
		String subcategory = ExcelUtility.getStringData(1, 1, "Sub_CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		subCategory = homePage.clickOnSubCategory();
		subCategory.clickOnSearchButtonOfSubCategory().selectCategoryFromList(categorySelect)
				.inputSubCategory(subcategory).submitSearch();
		boolean isSearchedItemDisplayed = subCategory.isitemDisplayed();
		Assert.assertTrue(isSearchedItemDisplayed, Messages.ERRORMESSAGEFORSEARCHSUBCATEGORY);
	}

	@Test(description = " User can able to add new Sub_category", priority = 2)
	public void userCanAbleToAddNewSubCategoryUsingCategoryAndSubcategoryName() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String item = ExcelUtility.getStringData(2, 0, "Sub_CategoryPage");
		String enterName = ExcelUtility.getStringData(2, 1, "Sub_CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		subCategory = homePage.clickOnSubCategory();
		subCategory.clickOnNewButton().selectCategoryToAddSubCategory(item).enterSubCategoryName(enterName)
				.toChooseFile().clickOnSaveButton();
		boolean isSubCategoryCreatedAlertdisplayed = subCategory.newAddAlertDisplayed();
		Assert.assertTrue(isSubCategoryCreatedAlertdisplayed, Messages.ERRORMESSAGEFORADDSUBCATEGORY);
	}
}
