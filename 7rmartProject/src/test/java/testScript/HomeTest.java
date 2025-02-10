
package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {

	@Test(description = "User can able to logout successfully", priority = 1)
	public void isTheUserAbleToLogout() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdminButton();
		home.clickOnLogout();
		String actual = driver.getTitle();
		String expectedResult = "Login | 7rmart supermarket";
		Assert.assertEquals(actual, expectedResult);

	}

	
}
