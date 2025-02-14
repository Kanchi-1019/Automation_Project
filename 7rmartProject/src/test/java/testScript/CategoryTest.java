package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	@Test(description = "User can able to Choose File", priority = 1)
	public void userCanAbleToChooseFileAndGetImagePreview() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categoryName = ExcelUtility.getStringData(1, 0, "CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		CategoryPage category = new CategoryPage(driver);
		category.clickOnCategory();
		category.clickNewCategory();
		category.enterValueOnCategoryNameField(categoryName);
		boolean isImagePreviewEnabled = category.imagePreviewOfCategory();
		category.toChooseFile();
		assertTrue(isImagePreviewEnabled,Messages.ERRORMESSAGEIMAGEPREVIEW);
	}

	@Test(description = "User can able to reset the Category list", priority = 2)

	public void userCanAbleToResetTheCategoryList() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String searchCategory = ExcelUtility.getStringData(1, 1, "CategoryPage");
		String urlExpected = ExcelUtility.getStringData(1, 2, "CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		CategoryPage category = new CategoryPage(driver);
		category.clickOnCategory();
		category.categorySearch(searchCategory);
		category.clickOnResetButton();
		String actual = driver.getCurrentUrl();
		String expected = urlExpected;
		Assert.assertEquals(actual, expected,Messages.ERRORMESSAGEFORRESET);

	}

}
