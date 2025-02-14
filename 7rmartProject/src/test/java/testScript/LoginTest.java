package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "Login using valid credentials", priority = 1, groups = { "smoke" })
	public void userLoginUsingValidUsernameAndValidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isDashBoardDisplayed = login.isDashboardisDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,Messages.VALIDCREDENTIALSERROR);

	}

	@Test(description = "Login using valid username and invalid password", priority = 2, groups = { "smoke" })
	public void userLoginUsingValidUsernameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.INVALIDPASSWORDLOGIN);

	}

	@Test(description = "Login using invalid username and valid password", priority = 3)
	public void userLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Messages.INVALIDUSERNAMELOGIN);

	}

	@Test(description = "Login using invalid username and invalid password", priority = 4)
	public void userLoginUsingInvalidUsernameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtility.getStringData(4, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Messages.INVALIDUSERNAMEANDPASSWORDLOGIN);

	}
}
