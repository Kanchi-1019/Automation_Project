package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUserTest extends Base {
	@Test(description = "User can able to add new admin user using valid credentials", priority = 1)
	public void addNewAdminUserWithValidCredentials() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String newAdminUsername = ExcelUtilities.getStringData(1, 0, "AdminUser");
		String newAdminPassword = ExcelUtilities.getStringData(1, 1, "AdminUser");
		String value = ExcelUtilities.getStringData(1, 2, "AdminUser");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username1);
		login.enterPasswordOnPasswordField(password1);
		login.clickOnSigninButton();
		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickOnTheAdminUserOnSideBar();
		admin.clicktheMangeUserFromAdminUserList();
		admin.clickOnTheNewButtonOnManageUser();
		admin.inputUsernameInNewAdminUserNameField(newAdminUsername);
		admin.inputPasswordInNewAdminPasswordField(newAdminPassword);
		admin.selectUserTypeOfNewAdminUser(value);
		admin.saveNewAdminUser();
	}

	@Test(description = "User can able to search Admin user using username and usertype", priority = 2)
	public void searchAdminUserUsingUsernameAndUserType() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		String searchUsername = ExcelUtilities.getStringData(5, 0, "AdminUser");
		String value = ExcelUtilities.getStringData(5, 1, "AdminUser");
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

	}

}
