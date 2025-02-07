package testScript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import pages.Sub_CategoryPage;
import utilities.ExcelUtilities;

@Test(description = " User can able to  click Sub_Category button", priority = 1)

public class Sub_CategoryTest extends Base {
	public void userCanClickOnSubCategoryButton() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		Sub_CategoryPage subCategory = new Sub_CategoryPage(driver);
		boolean isSubCategoryDisplayed = subCategory.isSubCategoryisDisplayed();
		subCategory.clickOnSubCategory();
		assertTrue(isSubCategoryDisplayed, "Sub-Category not Displayed");
	}

	@Test(description = "User can delete SubCategory from the SubCategory List", priority = 2)
	public void userCanDeleteSubCategoryFromList() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		Sub_CategoryPage subCategory = new Sub_CategoryPage(driver);
		subCategory.clickOnSubCategory();
		boolean isDeleteButtonEnable = subCategory.isDeleteIconEnabled();
		subCategory.clickOnDeleteButton();
		assertTrue(isDeleteButtonEnable, "Delete Button Not Enabled");

	}

	@Test(description = "User can able to Select SubCategory from Search List", priority = 3)
	public void selectSubCategoryFromSearchList() throws IOException {

		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		Sub_CategoryPage subCategory = new Sub_CategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnSearchButtonOfSubCategory();
		subCategory.selectSubCategory();
		boolean isSearchSubmitButtonDisplayed = subCategory.isSubmitButtonDisplayed();
		subCategory.submitSearch();
		assertTrue(isSearchSubmitButtonDisplayed, "Search Submit Button not Displayed");

	}

	@Test(description = " User can able to add new Sub_category")
	public void userCanAbleToAddNewSub_Category() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		Sub_CategoryPage subCategory = new Sub_CategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnNewButton();
		subCategory.selectCategoryFromList();
		subCategory.enterSubCategoryName();
		subCategory.toChooseFile();

		subCategory.clickOnSaveButton();

	}
}
