package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	public HomePage homePage;
@Parameters({"username","password"})
	@Test(description = "Login using valid credentials", priority = 1, groups = { "smoke" })
	public void userLoginUsingValidUsernameAndValidPassword(String username1,String password1) throws IOException {
		//String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		//String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		boolean isDashBoardDisplayed = login.isDashboardisDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, Messages.VALIDCREDENTIALSERROR);

	}

	@Test(description = "Login using valid username and invalid password", priority = 2, groups = { "smoke" })
	public void userLoginUsingValidUsernameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.INVALIDPASSWORDLOGIN);

	}

	@Test(description = "Login using invalid username and valid password", priority = 3)
	public void userLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Messages.INVALIDUSERNAMELOGIN);

	}

	@Test(description = "Login using invalid username and invalid password", priority = 4, dataProvider = "loginProvider")
	public void userLoginUsingInvalidUsernameAndInvalidPassword(String username1, String password1) throws IOException {
		// String username1 = ExcelUtility.getStringData(4, 0, "LoginPage");
		// String password1 = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage = login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Messages.INVALIDUSERNAMEANDPASSWORDLOGIN);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "45612", "1254" }, new Object[] { "admin123", "123" }, new Object[] {
				ExcelUtility.getStringData(3, 0, "LoginPage"), ExcelUtility.getStringData(3, 0, "LoginPage") } };
	}
}
