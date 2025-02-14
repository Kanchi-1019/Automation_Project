package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test(description = "User can able to add new admin user using valid credentials", priority = 1)
	public void addNewAdminUserWithValidCredentials() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String value = ExcelUtility.getStringData(1, 2, "AdminUser");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnTheAdminUserOnSideBar();
		admin.clicktheMangeUserFromAdminUserList();
		admin.clickOnTheNewButtonOnManageUser();
		FakerUtility faker=new FakerUtility();
		String newAdminUsername = faker.createRandomUsername();
		String newAdminPassword = faker.createRandomPassword();
		admin.inputUsernameInNewAdminUserNameField(newAdminUsername);
		admin.inputPasswordInNewAdminPasswordField(newAdminPassword);
		admin.selectUserTypeOfNewAdminUser(value);
		admin.saveNewAdminUser();
		boolean isAlertDisplayedForNewAdminUser = admin.alertForNewAdminUser();
		Assert.assertTrue(isAlertDisplayedForNewAdminUser, Messages.ERRORMESSAGEFORADDADMINUSER);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "User can able to search Admin user using valid username and usertype", priority = 2)
	public void searchAdminUserUsingValidUsernameAndUserType() throws IOException {
		String username1 = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringData(1, 1, "LoginPage");
		String searchUsername = ExcelUtility.getStringData(5, 0, "AdminUser");
		String value = ExcelUtility.getStringData(5, 1, "AdminUser");
		String url = ExcelUtility.getStringData(5, 2, "AdminUser");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnTheAdminUserOnSideBar();
		admin.clicktheMangeUserFromAdminUserList();
		admin.clickOnSearchButtonToSearch();
		admin.inputTheSearchUsername(searchUsername);
		admin.selectUserTypeToSearch(value);
		admin.clickOnSearchButton();
		String actual = driver.getCurrentUrl();
		String expected = url;
		Assert.assertEquals(actual, expected, Messages.ERRORMESSAGEFORSEARCHCATEGORY);

	}

}
