package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	public HomePage homePage;
	public CategoryPage categoryPage;
	@Test(description = "User can able to Choose File", priority = 1)
	public void userCanAbleToChooseFileAndGetImagePreview() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String categoryName = ExcelUtility.getStringData(1, 0, "CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage=login.clickOnSigninButton();
		categoryPage=homePage.clickOnCategoryPage();
		categoryPage.clickNewCategory().enterValueOnCategoryNameField(categoryName);
		boolean isImagePreviewEnabled = categoryPage.imagePreviewOfCategory();
		assertTrue(isImagePreviewEnabled,Messages.ERRORMESSAGEIMAGEPREVIEW);
	}

	@Test(description = "User can able to reset the Category list", priority = 2)

	public void userCanAbleToResetTheCategoryList() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String searchCategory = ExcelUtility.getStringData(1, 1, "CategoryPage");
		String urlExpected = ExcelUtility.getStringData(1, 2, "CategoryPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage=login.clickOnSigninButton();
		categoryPage=homePage.clickOnCategoryPage();
		categoryPage.categorySearch(searchCategory).clickOnResetButton();
		String actual = driver.getCurrentUrl();
		String expected = urlExpected;
		Assert.assertEquals(actual, expected,Messages.ERRORMESSAGEFORRESET);

	}

}
