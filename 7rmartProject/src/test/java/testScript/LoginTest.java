package testScript;

import java.io.IOException;
import java.net.http.WebSocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.WaitUtility;

public class LoginTest extends Base {
	@Test(description = "Login using valid credentials", priority = 1)
	public void userLoginUsingValidUsernameAndValidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isDashBoardDisplayed=login.isDashboardisDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,"Unable to login with given Credentials");

	}

	@Test(description = "Login using valid username and invalid password", priority = 2)
	public void userLoginUsingValidUsernameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(2, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		//WaitUtility wait=new WaitUtility();
		//wait.waitUntilTheAlertIsPresent(driver,signInBu);
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "Successfull login with invalid password");

	}

	@Test(description = "Login using invalid username and valid password", priority = 3)
	public void userLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, "Successfull login with invalid username");

	}

	@Test(description = "Login using invalid username and invalid password", priority = 4)
	public void userLoginUsingInvalidUsernameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(4, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		boolean isAlertMessageDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, "Successfull login with invalid credentials");

	}
}
