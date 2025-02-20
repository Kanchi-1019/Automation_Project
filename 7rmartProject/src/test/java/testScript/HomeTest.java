
package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
public HomePage homePage;
	@Test(description = "User can able to logout successfully", priority = 1)
	public void isTheUserAbleToLogout() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String expectedTitle=ExcelUtility.getStringData(1, 0,"HomePage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1);
		homePage=login.clickOnSigninButton();
		homePage.clickOnAdminButton().clickOnLogout();
		String actual = driver.getTitle();
		String expectedResult = expectedTitle;
		Assert.assertEquals(actual, expectedResult,Messages.ERRORMESSAGEFORLOGOUT);

	}

	
}
