package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class CategoryTest extends Base {
	@Test(description = "User can able to Choose File", priority = 1)
	public void userCanAbleToChooseFile() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		CategoryPage category = new CategoryPage(driver);
		category.clickOnCategory();
		category.clickNewCategory();
		String categoryName=ExcelUtilities.getStringData(1, 0,"CategoryPage" );
		category.enterValueOnCategoryNameField(categoryName);
		boolean isImagePreviewEnabled = category.imagePreviewOfCategory();
		category.toChooseFile();
		assertTrue(isImagePreviewEnabled, "Unable to Choose the File");
	}

	@Test(description = "User can able to reset the Category list", priority = 2)

	public void userCanAbleToResetTheCategoryList() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		CategoryPage category = new CategoryPage(driver);
		category.clickOnCategory();
		String searchCategory=ExcelUtilities.getStringData(1, 1,"CategoryPage");
		category.categorySearch(searchCategory);
		category.clickOnResetButton();
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/list-category";
		Assert.assertEquals(actual, expected);

	}

}
