package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	@Test(description = "User can able to Select SubCategory from Search List using category and Subcategory name", priority = 1)
	public void selectSubCategoryFromSearchListUsingCategoryAndSubCategoryName() throws IOException {

		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categorySelect = ExcelUtility.getStringData(1, 0, "Sub_CategoryPage");
		String subcategory = ExcelUtility.getStringData(1, 1, "Sub_CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnSearchButtonOfSubCategory();
		subCategory.selectCategoryFromList(categorySelect);
		subCategory.inputSubCategory(subcategory);
		subCategory.submitSearch();
		boolean isSearchedItemDisplayed = subCategory.isitemDisplayed();
		Assert.assertTrue(isSearchedItemDisplayed,Messages.ERRORMESSAGEFORSEARCHSUBCATEGORY);
	}

	@Test(description = " User can able to add new Sub_category", priority = 2)
	public void userCanAbleToAddNewSubCategoryUsingCategoryAndSubcategoryName() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String item = ExcelUtility.getStringData(2, 0, "Sub_CategoryPage");
		String enterName = ExcelUtility.getStringData(2, 1, "Sub_CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnNewButton();
		subCategory.selectCategoryToAddSubCategory(item);
		subCategory.enterSubCategoryName(enterName);
		subCategory.toChooseFile();
		subCategory.clickOnSaveButton();
		boolean isSubCategoryCreatedAlertdisplayed = subCategory.newAddAlertDisplayed();
		Assert.assertTrue(isSubCategoryCreatedAlertdisplayed, Messages.ERRORMESSAGEFORADDSUBCATEGORY);
	}
}
