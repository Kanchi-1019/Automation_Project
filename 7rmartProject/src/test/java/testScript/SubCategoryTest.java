package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends Base {

	@Test(description = "User can able to Select SubCategory from Search List", priority = 1)
	public void selectSubCategoryFromSearchListUsingCategoryAndSubCategoryName() throws IOException {

		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String categorySelect=ExcelUtilities.getStringData(1, 0,"Sub_CategoryPage");
		String subcategory=ExcelUtilities.getStringData(1, 1, "Sub_CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnSearchButtonOfSubCategory();
		subCategory.selectCategoryFromList(categorySelect);
		subCategory.enterSubCategoryName(subcategory);
		subCategory.submitSearch();
		boolean isSearchedItemDisplayed = subCategory.isitemDisplayed();
		Assert.assertTrue(isSearchedItemDisplayed, "Item not Listed");
	}

	@Test(description = " User can able to add new Sub_category", priority = 2)
	public void userCanAbleToAddNewSubCategoryUsingCategoryAndSubcategoryName() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String item=ExcelUtilities.getStringData(2, 0, "Sub_CategoryPage");
		String enterName=ExcelUtilities.getStringData(2, 1, "Sub_CategoryPage");
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
		Assert.assertTrue(isSubCategoryCreatedAlertdisplayed, "Unable to create Sub_category");
	}
}
